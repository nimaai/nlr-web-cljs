(ns nlr-web-cljs.nlr-core
  (:require [js-nlr-core]))

(defn get-current-index []
  (.getLilaIndex js/nlrCore (js/Date.)))
