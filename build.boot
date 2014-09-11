#!/usr/bin/env boot

#tailrecursion.boot.core/version "2.5.0"

(set-env!
  :project      'hoplon-deploy-heroku
  :version      "0.1.0-SNAPSHOT"
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

(deftask project-clj
  "Create project.clj file that Heroku will use to build uberjar."
  []
  (set-env!
    :src-paths #{"resources"}
    :lein      '{:min-lein-version "2.0.0"
                 :plugins          [[lein-environ "1.0.0"]]
                 :hooks            [environ.leiningen.hooks]
                 :uberjar-name     "hoplon-deploy-heroku-standalone.jar"
                 :profiles         {:production {:env {:production true}}}})
  (lein-generate))

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
