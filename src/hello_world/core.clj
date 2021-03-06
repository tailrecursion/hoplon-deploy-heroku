(ns hello-world.core
  (:gen-class)
  (:require
   [ring.adapter.jetty             :refer [run-jetty]]
   [ring.middleware.resource       :refer [wrap-resource]]
   [ring.middleware.session        :refer [wrap-session]]
   [ring.middleware.session.cookie :refer [cookie-store]]
   [ring.middleware.file-info      :refer [wrap-file-info]]
   [tailrecursion.castra.handler   :refer [castra]]))

(defn wrap-dir-index [handler]
  (fn [req]
    (handler
     (update-in req [:uri]
                #(if (= "/" %) "/index.html" %)))))

(def app
  (->
    (castra 'hello-world.api)
    (wrap-session {:store (cookie-store {:key "a 16-byte secret"})})
    (wrap-resource "public")    
    (wrap-dir-index)
    (wrap-file-info)))

(defn -main [& [port]]
  (let [port (Integer. (or port 8000))]
    (run-jetty #'app {:port port :join? false})))

;; For interactive development:
;; (.stop server)
;; (def server (-main))
