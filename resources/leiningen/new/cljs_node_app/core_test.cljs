(ns {{namespace}}-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [{{namespace}} :refer [-main]]))

(deftest fix-me-test
  (is (= :success (-main))))
