(ns border-patrol.error)

(defrecord error-record [error-type message data])

(defn throw-error
  "Throws an ExceptionInfo containing an error-record."
  [error-type message & [data]]
  (throw (ex-info message (->error-record error-type message data))))

(defn user-exists [msg]
  (throw-error ::user-exists msg))

(defn unknown [msg]
  (throw-error ::unknown msg))

