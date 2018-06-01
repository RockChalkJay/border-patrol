(ns border-patrol.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [border-patrol.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[border-patrol started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[border-patrol has shut down successfully]=-"))
   :middleware wrap-dev})
