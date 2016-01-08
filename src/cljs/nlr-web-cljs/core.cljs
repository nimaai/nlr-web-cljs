(ns nlr-web-cljs.core
  (:require [nlr-core]
            [reagent.core :as r]))

(defonce timer (r/atom (js/Date.)))

(defonce time-updater (js/setInterval
                       #(reset! timer (js/Date.)) 1000))

; (.write js/document (.getEnglishName js/nlrCore 0))

(defn current-time []
  ; <ul class="nav navbar-nav navbar-left">
  ;   <li>
  ;     <strong id="current-time" class="navbar-brand"></strong>
  ;   <li>
  ; </ul>
  (let [time-str (-> @timer
                     .toTimeString
                     (clojure.string/split " ")
                     first)]
    [:ul.nav.navbar-nav.navbar-lef
     [:li
      [:strong.navbar-brand time-str]]]))

(defn ^:export run []
  (r/render [current-time]
            (js/document.getElementById "current-time")))
