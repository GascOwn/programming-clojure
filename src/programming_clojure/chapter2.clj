(ns programming-clojure.chapter2 
  (:require [clojure.string :as str]))

(defn greeting
  "Returns a greeting"
  [username]
  (str "Hello, " username))

;; an ampersand is used to define variable arity
(defn date [person-1 person-2 & chaperones]
  (println person-1 "and" person-2 "went out with" (count chaperones) "chaperones."))

;; anonymous functions
(filter (fn [word] (> (count word) 2)) (str/split "A fine day" #"\W+"))

;; shorter version with %parameters
(filter #(> (count %) 2) (str/split "A fine day it is" #"\W+"))

;; it's also possible to declare funtions inside a scope
(defn indexable-words [text]
  (let [indexable-word? (fn [w] (> (count w) 2))]
    (filter indexable-word? (str/split text #"\W+"))))

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

;; metadata is very useful in Clojure, ex: expected types
(defn ^{:tag String} shout [^{:tag String} s] (clojure.string/upper-case s))

;; the :tag metadata type is so common that it has its own short form in ^Type
(defn ^String shout-short [^String s] (clojure.string/upper-case s))