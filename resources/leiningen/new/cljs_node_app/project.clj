{{! Change mustache delimiter to <% and %> }}
{{=<% %>=}}

(defproject <% raw-name %> "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :clean-targets ["build" :target-path]

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170" :classifier "aot"]
                 ;; to use nodejs/require (remove if you don't need it)
                 [io.nervous/cljs-nodejs-externs "0.2.0"]
                 ;; to parse cli options (remove if you don't need it)
                 [org.clojure/tools.cli "0.3.3"]]

  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-npm "0.6.1"]
            [lein-doo "0.1.6"]
            [org.bodil/lein-noderepl "0.1.11"]]

  :profiles {:dev {:dependencies [[lein-doo "0.1.6"]]}}

  :npm {:dependencies [[source-map-support "0.4.0"]]
        :package {;; To distribute a node binary, set :bin
                  ; :bin {"<% name %>" "bin/main.js"}
                  ;; To distribute a node library, set :main
                  ; :main "bin/main.js"
                  ;; To push to a publicly available npm name set :private
                  ; :private false
                  }}

  :aliases {"build" ["cljsbuild" "once" "main"]
            "test" ["doo" "node" "test-node" "once"]
            "test-auto" ["doo" "node" "test-node" "auto"]}

  ;; This release-task does lein npm publish in addition to lein deploy
  :release-tasks [["vcs" "assert-committed"]
                  ["clean"]
                  ["build"]
                  ["change" "version"
                   "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag"]
                  ;; Uncomment the following line to distribute via npm
                  ; ["npm" "publish"]
                  ;; The following line deploys to a maven repo
                  ["deploy"]
                  ["change" "version"
                   "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]]

  :cljsbuild {:builds [{:id "main"
                        :source-paths ["src"]
                        :compiler {:output-to "build/main.js"
                                   :output-dir "build/js"
                                   :optimizations :advanced
                                   :target :nodejs
                                   :source-map "build/main.js.map"}}
                       {:id "test-node"
                        :source-paths ["src" "test"]
                        :compiler {:main <% namespace %>-runner
                                   :output-to     "build/test-node.js"
                                   :target :nodejs
                                   :output-dir    "build/test-js"
                                   :optimizations :none
                                   :pretty-print  true}}]})
