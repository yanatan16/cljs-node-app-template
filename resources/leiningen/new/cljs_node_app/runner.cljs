(ns runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [{{namespace}}-test]))

(doo-tests '{{namespace}}-test)
