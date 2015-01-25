(ns seven-languages.big-test
  (:require [clojure.test :refer :all]
            [seven-languages.core :refer :all]
            [seven-languages.big :refer :all]
            ))

(deftest big-test
  (testing "big always true when threshold -1"
    (is (= (big "a" -1) true))))

(deftest big-longer-test
  (testing "big always true when string longer than threshold"
    (is (= (big "ab" 1) true))))

(deftest big-equal-test
  (testing "big always false when string same length as threshold"
    (is (= (big "a" 1) false))))

(deftest big-shorter-test
  (testing "big always false when string same shorter than threshold"
    (is (= (big "a" 2) false))))
