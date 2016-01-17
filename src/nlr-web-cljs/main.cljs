(ns nlr-web-cljs.main
  (:require [domina :as d]
            [nlr-web-cljs.nlr-core :as core]
            [reagent.core :as r]))

(enable-console-print!)

(defonce index (js.parseInt
                 (d/text
                   (d/by-id "index"))))

(defonce current-index (r/atom
                         (core/current-index (js/Date.))))

(defonce timer (r/atom (js/Date.)))

(defonce time-updater (js/setInterval
                        #(let [date (js/Date.)]
                           (do (reset! timer date)
                               (reset! current-index
                                       (core/current-index date))))
                        1000))

(defn now-info []
  (let [current-index @current-index]
    (if (= current-index index)
      (-> @timer
          .toTimeString
          (clojure.string/split " ")
          first)
      [:a {:href (str (.toLowerCase
                        (core/sanskrit-name current-index))
                      ".html")}
       "Go to now"])))

(defn now-info-component []
  [:li
   [:strong.navbar-brand (now-info)]])

(defn ^:export run []
  (r/render [now-info-component]
            (d/by-id "current-time")))
