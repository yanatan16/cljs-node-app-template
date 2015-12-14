(ns leiningen.new.cljs-node-app
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files
                                             project-name multi-segment
                                             sanitize-ns]]
            [leiningen.core.main :as main]))



(defn cljs-node-app
  "FIXME: write documentation"
  [name]
  (let [render (renderer "cljs-node-app")
        main-ns (multi-segment (sanitize-ns name))
        data {:raw-name name
              :name (project-name name)
              :namespace main-ns
              :nested-dirs (name-to-path main-ns)}]
    (main/info "Generating fresh 'lein new' cljs-node-app project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             [".gitignore" (render "gitignore" data)]
             ["README.md" (render "README.md" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["src/{{nested-dirs}}.cljs" (render "core.cljs" data)]
             ["test/{{nested-dirs}}_test.cljs" (render "core_test.cljs" data)]
             ["test/{{nested-dirs}}_runner.cljs" (render "runner.cljs" data)]
             )))
