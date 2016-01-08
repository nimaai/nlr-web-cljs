(defproject nlr-web-cljs "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  ;; CLJ AND CLJS source code paths
  :source-paths ["src/clj" "src/cljs"]
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.145"]
                 [reagent "0.6.0-alpha"]]

  ;; lein-cljsbuild plugin to build a CLJS project
  :plugins [[lein-cljsbuild "1.1.0"]]

  ;; cljsbuild options configuration
  :cljsbuild {:builds
              [{;; CLJS source code path
                :source-paths ["src/cljs"]

                ;; Google Closure (CLS) options configuration
                :compiler {;; CLS generated JS script filename
                           :output-to "resources/public/js/dist.js"

                           ;; minimal JS optimization directive
                           :optimizations :whitespace

                           ; Adds dependencies on foreign libraries. Be sure that the url returns a HTTP Code 200
                           ; Defaults to the empty vector [].
                           :foreign-libs [{:file "https://raw.githubusercontent.com/nimaai/nlr-core/fix-dist-format/dist/main.js"
                                           :provides ["nlr-core"]
                                           :module-type :commonjs}]

                           ;; generated JS code prettyfication
                           :pretty-print true}}]}
  ;; to clean JS files generated during the build
  :clean-targets ^{:protect false} [:target-path "resources/public/js/"])
