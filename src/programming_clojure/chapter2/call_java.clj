(ns programming-clojure.chapter2.call-java)

;; Clojure can also call Java code, it has a special . notation
(def rnd (java.util.Random.))

;; methods are called by prepending a ., the function argument is added by simply adding it to the list
(. rnd nextInt 10)
(def p (java.awt.Point. 10 20))
(. p x)
(. System lineSeparator)
(. Math PI)

;; or with a shorter syntax
(.nextInt rnd 10)
(.x p)
(System/lineSeparator)
Math/PI

;; java classes can be imported
(import '(java.util Random Locale)
        '(java,text MessageFormat))
Random