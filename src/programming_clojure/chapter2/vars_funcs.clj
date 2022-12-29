(ns programming-clojure.chapter2.vars-funcs 
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
