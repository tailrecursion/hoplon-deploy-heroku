#!/usr/bin/env boot

#tailrecursion.boot.core/version "2.5.0"

(set-env!
  :project      'hoplon-deploy-heroku
  :version      "0.1.0-SNAPSHOT"
  :main-class   'hello-world.core
  :dependencies '[[environ                   "1.0.0"]
                  [tailrecursion/hoplon      "5.10.14"]
                  [tailrecursion/boot.task   "2.2.1"]
                  [tailrecursion/boot.notify "2.0.2"]
                  [tailrecursion/boot.ring   "0.2.1"]]
  :out-path     "resources/public"
  :src-paths    #{"src"})

;; Static resources synced to output dir
(add-sync! (get-env :out-path) #{"resources/assets"})

(require
  '[tailrecursion.hoplon.boot :refer :all]
  '[tailrecursion.castra.task :refer [castra-dev-server]])

(deftask heroku
  "Prepare project.clj and Procfile for Heroku deployment."
  [& [main-class]]
  (let [jar-name   (format "%s-standalone.jar" (get-env :project))
        jar-path   (format "target/%s" jar-name)
        main-class (or main-class (get-env :main-class))]
    (set-env!
      :src-paths #{"resources"}
      :lein      {:min-lein-version "2.0.0"
                  :uberjar-name     jar-name
                  :plugins          '[[lein-environ "1.0.0"]]
                  :profiles         {:production {:env {:production true}}}})
    (comp
      (lein-generate)
      (with-pre-wrap
        (-> "project.clj" slurp
          (.replaceAll "(:min-lein-version)\\s+(\"[0-9.]+\")" "$1 $2")
          ((partial spit "project.clj")))
        (-> "web: java $JVM_OPTS -cp %s clojure.main -m %s"
          (format jar-path main-class)
          ((partial spit "Procfile")))))))

(deftask development
  "Start local dev server."
  []
  (comp
    (castra-dev-server 'hello-world.api)
    (watch)
    (hoplon {:prerender false})))

(deftask production
  "Compile application with Google Closure advanced optimizations."
  []
  (hoplon {:optimizations :advanced}))
