(ns programming-clojure.chapter2.metadata)

;; metadata is very useful in Clojure, ex: expected types
(defn ^{:tag String} shout [^{:tag String} s] (clojure.string/upper-case s))

;; the :tag metadata type is so common that it has its own short form in ^Type
(defn ^String shout-short [^String s] (clojure.string/upper-case s))

;; it can also be placed at the end
(defn shout_end ([s] (clojure.string/upper-case s)) {:tag String})