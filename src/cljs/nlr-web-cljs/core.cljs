(ns nlr-web-cljs.core
  (:require [nlr-core]
            [domina :as d]))

(enable-console-print!)

(println (d/text (d/by-id "index")))

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
