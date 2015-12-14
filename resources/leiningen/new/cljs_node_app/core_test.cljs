(ns {{namespace}}-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [{{namespace}} :refer [run]]))

(deftest run-test
  (is (= (run ["node" "myscript" "-h"])
         {:arguments ["node" "myscript"]
          :options {:help true}
          :summary "  -h, --help"
          :errors nil})))
