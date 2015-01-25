(ns seven-languages.collection-test
  (:require [clojure.test :refer :all]
            [seven-languages.collection :refer :all]
            ))

(deftest collection-list-test
  (testing "collection returns :list for a list"
    (is (= (collection '(1 2 3)) :list))))

(deftest collection-map-test
  (testing "collection returns :map for a map"
    (is (= (collection {1 2 3 4}) :map))))

(deftest collection-set-test
  (testing "collection returns :set for a set"
    (is (= (collection #{1 2 3}) :set))))