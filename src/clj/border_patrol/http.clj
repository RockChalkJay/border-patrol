(ns border-patrol.http
  (:require [liberator.representation :refer [ring-response]]))

(defn ok [& body]
  (ring-response {:status 200 :body body}))

(defn precond-failed [& body]
  (ring-response {:status 412 :body body}))
