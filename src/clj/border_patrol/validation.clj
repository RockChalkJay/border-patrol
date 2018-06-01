(ns border-patrol.validation
  (:require [struct.core :as st]))

(defonce +scheme+
         {:id   [st/required st/string]
          :pass [st/required [st/min-count 8 :message "Password must be at least 8 characters."]
                 [st/identical-to :pass-confirm :message "Passwords don't match."]]
          :first-name [st/required st/string]
          :last-name [st/required st/string]
          ;;TODO check email format
          :email [st/required st/string]})

(defn registration-errors [new-user]
  "Validates a new user registration"
  [new-user]
  (let [results (st/validate new-user +scheme+)]
    (if (first results)
      results)))
