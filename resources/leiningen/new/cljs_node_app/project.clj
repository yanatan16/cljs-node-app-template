{{! Change mustache delimiter to <% and %> }}
{{=<% %>=}}

(defproject <% raw-name %> "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :clean-targets ["build" :target-path]

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170" :classifier "aot"]]

  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-npm "0.6.1"]
            [lein-doo "0.1.6"]]

  :profiles {:dev {:dependencies [[lein-doo "0.1.6"]]}}

  :npm {:dependencies [[source-map-support "0.4.0"]]
        :package {;; For a binary, set :bin
                  ; :bin {"<% name %>" "bin/cli.js"}
                  ;; For a library, set :main
                  ; :main "index.js"
                  }}

  :aliases {"build" ["cljsbuild" "once" "main"]
            "test" ["doo" "node" "test-node" "once"]
            "test-auto" ["doo" "node" "test-node" "auto"]}

  :cljsbuild {:builds [{:id "main"
                        :source-paths ["src"]
                        :compiler {:output-to "build/main.js"
                                   :output-dir "build/js"
                                   :optimizations :advanced
                                   :target :nodejs
                                   :source-map "build/main.js.map"}}
                       {:id "test-node"
                        :source-paths ["src" "test"]
                        :compiler {:main runner
                                   :output-to     "build/test-node.js"
                                   :target :nodejs
                                   :output-dir    "build/test-js"
                                   :optimizations :none
                                   :pretty-print  true}}]})
