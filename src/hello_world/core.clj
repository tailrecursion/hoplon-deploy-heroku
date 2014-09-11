(ns hello-world.core
  (:gen-class)
  (:require
   [environ.core                   :refer [env]]
   [ring.adapter.jetty             :refer [run-jetty]]
   [ring.middleware.resource       :refer [wrap-resource]]
   [ring.middleware.session        :refer [wrap-session]]
   [ring.middleware.session.cookie :refer [cookie-store]]
   [ring.middleware.file-info      :refer [wrap-file-info]]
   [tailrecursion.castra.handler   :refer [castra]]))

(def app
  (->
    (castra 'hello-world.api)
    (wrap-session {:store (cookie-store {:key "a 16-byte secret"})})
    (wrap-resource "public")
    (wrap-file-info)))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (run-jetty #'app {:port port :join? false})))

;; For interactive development:
;; (.stop server)
;; (def server (-main))
