(defproject
 boot-project
 "0.1.0-SNAPSHOT"
 :dependencies
 [[org.clojure/clojure "1.6.0"]
  [tailrecursion/boot.core "2.5.1" :exclusions [[org.clojure/clojure]]]
  [tailrecursion/hoplon "5.10.23"]
  [tailrecursion/boot.task "2.2.4"]
  [tailrecursion/boot.notify "2.0.2"]
  [tailrecursion/boot.ring "0.2.1"]]
 :source-paths
 [".boot/tmp/71548/_COLON_tailrecursion.hoplon.boot_SLASH_hoplon_src/dir.tmp"
  ".boot/tmp/71548/_COLON_tailrecursion.boot.task_SLASH_cljs_out/dir.tmp"
  ".boot/tmp/71548/_COLON_tailrecursion.hoplon.boot_SLASH_public_out/dir.tmp"
  "src"
  ".boot/tmp/71548/_COLON_tailrecursion.hoplon.boot_SLASH_hoplon_src_inc_css/dir.tmp"
  ".boot/tmp/71548/_COLON_tailrecursion.boot.task_SLASH_src_inc_out/dir.tmp"
  ".boot/tmp/71548/_COLON_tailrecursion.hoplon.boot_SLASH_cljs_out/dir.tmp"
  "resources"]
 :min-lein-version "2.0.0"
 :uberjar-name
 "hoplon-app-standalone.jar")
