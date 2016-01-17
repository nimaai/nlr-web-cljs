(ns nlr-web-cljs.nlr-core
  (:require [js-nlr-core]))

(defn current-index [date]
  (.getLilaIndex js/nlrCore date))

(defn sanskrit-name [index]
  (.getSanskritName js/nlrCore index))
