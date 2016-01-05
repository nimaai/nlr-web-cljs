(ns nlr-web-cljs.core
  (:require [nlr-core]))

(.write js/document (.getEnglishName js/nlrCore 0))
