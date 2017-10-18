(ns cloj-101.core
    (:require
     [cljs.pprint :refer [pprint]]
     cljsjs.react
     cljsjs.react.dom
     sablono.core)
     ;[clj101.persons :as persons]
   (:require-macros
    [sablono.core :refer [html]]))

(enable-console-print!)

(declare render-app)

(println "This text is printed from src/cloj-101/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello worlxd!"}))

;; Watch state for changes
(add-watch app-state :render
           (fn [k a o n] (render-app a)))

(defn on-js-reload []
  (swap! app-state update-in [:__figwheel_counter] inc))

(defn render-app [s]
  (ReactDOM.render (html [:p (:text @s)])
                   (.getElementById js/document "app")))

(render-app app-state)
