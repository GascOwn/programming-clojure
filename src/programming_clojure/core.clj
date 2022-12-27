(ns programming-clojure.core
  (:gen-class) 
  (:require [clojure.string :as str]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

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