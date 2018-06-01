(ns border-patrol.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [border-patrol.layout :refer [error-page]]
            [border-patrol.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [border-patrol.env :refer [defaults]]
            [mount.core :as mount]
            [border-patrol.middleware :as middleware]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(mount/defstate app
  :start
  (middleware/wrap-base
    (routes
      (-> #'home-routes
          (wrap-routes middleware/wrap-csrf)
          (wrap-routes middleware/wrap-formats))
      (route/not-found
        (:body
          (error-page {:status 404
                       :title "page not found"}))))))
