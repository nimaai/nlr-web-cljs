(ns nlr-web-cljs.core
  (:require [nlr-core]))

(enable-console-print!)

(defonce index (.getLilaIndex js/nlrCore (js/Date.)))
(println index)

; (defonce timer (r/atom (js/Date.)))

; (defonce time-updater (js/setInterval
;                        #(reset! timer (js/Date.)) 1000))

; (defn current-time []
;   (let [time-str (-> @timer
;                      .toTimeString
;                      (clojure.string/split " ")
;                      first)]
;     [:ul.nav.navbar-nav.navbar-lef
;      [:li
;       [:strong.navbar-brand time-str]]]))

; (defn ^:export run []
;   (r/render [current-time]
;             (js/document.getElementById "current-time")))
