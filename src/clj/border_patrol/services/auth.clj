(ns border-patrol.services.auth
  (:require [border-patrol.db.core :as db]
            [border-patrol.error :as error]
            [border-patrol.validation :refer [registration-errors]]
            [border-patrol.http :as http]
            [liberator.representation :refer [ring-response]]
            [buddy.hashers :as hashers]
            [clojure.string :as str]
            [clojure.tools.logging :as log])
  (:import
    (java.sql BatchUpdateException)))


(defn- handle-registration-errors [ex]
  (if (and
        (instance? BatchUpdateException (.getCause ex))
        (-> ex
            (.getCause)
            (.getMessage)
            (str/includes? "ERROR: duplicate key value")))
    (error/user-exists "User already exists.")
    (do
      (log/error ex)
      (error/unknown "An unknown error occurred when registering a user"))))

(defn register-user! [user]
  (if-let [errors (registration-errors user)]
    (http/precond-failed (first errors))
    (try
      (db/create-user!
        (-> user
            (dissoc :pass-confirm)
            (update :pass hashers/encrypt)))
      (http/ok)
      (catch Exception ex
        (handle-registration-errors ex)))))
