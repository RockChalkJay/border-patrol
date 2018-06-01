(ns border-patrol.routes.home
  (:require [border-patrol.layout :as layout]
            [border-patrol.services.auth :as auth]
            [compojure.core :refer [defroutes ANY]]
            [clojure.java.io :as io]
            [liberator.core :refer [resource defresource]]))

(defn home-page [_]
  (:body (layout/render "home.html" {:docs (-> "docs/docs.md" io/resource slurp)})))

(defn about-page [_]
  (:body (layout/render "about.html")))

(defn signup-page [_]
  (:body (layout/render "signup.html")))

(defroutes home-routes
           (ANY "/" []
             (resource :allowed-methods [:get]
                       :available-media-types ["text/html"]
                       :handle-ok home-page))
           (ANY "/about" []
             (resource :allowed-methods [:get]
                       :available-media-types ["text/html"]
                       :handle-ok about-page))
           (ANY "/signup" []
             (resource :allowed-methods [:post :get]
                       :available-media-types ["text/html" "application/json"]
                       :handle-ok signup-page
                       :post! (fn [ctx] (auth/register-user! (get-in ctx [:request :params]))))))

