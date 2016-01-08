(ns nlr-web-cljs.core
  (:require [nlr-core]
            [reagent.core :as r]))

(.write js/document (.getEnglishName js/nlrCore 0))
