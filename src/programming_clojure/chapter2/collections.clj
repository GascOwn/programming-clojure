(ns programming-clojure.chapter2.collections 
  (:require [clojure.string :as str]))

;; collections in Clojure are heterogenous, and can be destructured in functions
(defn greet-author [{fname :first-name}] (println "Hello," fname))
(greet-author {:last-name "Vinge" :first-name "Vernor"})
;; returns 1 2 
(let [[x y] [1 2 3]] [x y])
;; returns 3 
(let [[_ _ z] [1 2 3]] z)

;; members of a connection and the collection itself can be bound inside a collection 
(let [[x y :as coords] [1 2 3 4 5 6]]
  (str "x: " x ", y: " y ", total dimensions" (count coords)))
(defn ellipsize [words]
  (let [[w1 w2 w3] (str/split words #"\s+")]
    (str/join " " [w1 w2 w3 "..."])))
