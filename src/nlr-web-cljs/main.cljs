(ns nlr-web-cljs.main
  (:require [nlr-web-cljs.nlr-core :as core]
            [domina :as d]))

(enable-console-print!)

(defonce index (js.parseInt (d/text (d/by-id "index"))))

; (if-not (= (core/get-current-index) index)
;   (println "not current lila"))

(println index)
(println (core/get-current-index))

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
