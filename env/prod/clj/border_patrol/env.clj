(ns border-patrol.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[border-patrol started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[border-patrol has shut down successfully]=-"))
   :middleware identity})
