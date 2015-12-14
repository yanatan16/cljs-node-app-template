(ns {{namespace}}
  (:require [cljs.nodejs :as nodejs]
            [cljs.tools.cli :refer [parse-opts]]))

(nodejs/enable-util-print!)

(def options-spec
  [["-h" "--help"]])

(defn run [args]
  (parse-opts args options-spec))

(defn -main []
  (println "Hello world")
  (println (run (.-argv nodejs/process))))

(set! *main-cli-fn* -main)
