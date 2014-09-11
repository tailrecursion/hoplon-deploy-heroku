(defproject
 hoplon-deploy-heroku
 "0.1.0-SNAPSHOT"
 :dependencies
 [[org.clojure/clojure "1.6.0"]
  [tailrecursion/boot.core "2.5.0" :exclusions [[org.clojure/clojure]]]
  [tailrecursion/hoplon "5.10.14"]
  [tailrecursion/boot.task "2.2.1"]
  [tailrecursion/boot.notify "2.0.2"]
  [tailrecursion/boot.ring "0.2.1"]]
 :source-paths
 ["src" "resources"]
 :min-lein-version "2.0.0"
 :plugins
 [[environ/environ.lein "0.2.1"]]
 :hooks
 [environ.leiningen.hooks]
 :uberjar-name
 "hoplon-deploy-heroku-standalone.jar"
 :profiles
 {:production {:env {:production true}}})
