(ns peep.event
  (:require [monger.core :as mg]
            [monger.collection :as mc])
  (:import org.bson.types.ObjectId))

(def ^:private db
  (let [conn (mg/connect)]
     (mg/get-db conn "peep")))

(defn store-event
  [type event]
  (mc/insert db "github-events" (merge { :_id (ObjectId.) :event-type type} event)))
