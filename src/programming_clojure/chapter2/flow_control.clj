(ns programming-clojure.chapter2.flow-control)

;; Clojure has very few flow control forms
(defn is-small? [number]
  (if (< number 100) "yes" "no"))

;; do introduces side effects
(defn do-is-small? [number] 
  (if (< number 100) 
    "yes"
    (do
      (println "Saw a big number" number)
      "no")))

;; loop establishes bindings and evaluates the expression, but the expression can be targeted by recur
(loop [result [] x 5]
  (if (zero? x)
    result
    (recur (conj result x) (dec x))))

;; while recur is powerful, it's not often used as many library function provide recursion
(into [] (take 5 (iterate dec 5)))