(ns programming-clojure.chapter3.sequences 
  (:require [clojure.string :refer [join]]))

;; Every aggregate data structure in Clojure is a sequence
(def s '(1 2 3))

;; head and tail in Clojure are "first" and "rest"
(first s)
(rest s)

;; consing is constructing a new sequence by adding an item in front
(cons 0 s)

;; maps can be treated as seqs
(def person {:fname "Daniele" :lname "Anselmo"})
(first person)
(rest person)
(cons [:age 31] person)

;; maps and sets are not sorted, but they can be with sorted-set & elements / sorted-map & elements
(sorted-set :the :quick :brown :fox)
(sorted-map :a 1 :b 2 :c 3)

;; sequences can be created with (range start? end? step?), whose default end value is infinity
(range 10)

;; (repeat n x) creates an element x n times, while (iterate f x) begins with x and continues forever calculating the next value with f
(repeat 5 1)
(take 10 (iterate (fn [x] (* x x)) range))

;; cycle takes a function and cycles it infinitely
(take 10 (cycle (range 3)))

;; interleave takes two lists and alternates elements from each
(interleave (iterate inc 1) ["A" "B" "C" "D" "E"])

;; interpose returns each element of a seq segregated by a separator, it pairs with (apply str ...) to produce output strings
(def spesa (interpose ", " ["apples" "oranges" "bananas"]))
(apply str spesa)
;; (apply str ...) has been optimized with join
(join \, spesa)


;; Clojure also has a number of ways to filter seqs 
(def vowel? #{\a\e\i\o\u})
(def consonant? (complement vowel?))
(take-while consonant? "the-quick-brown-fox")


