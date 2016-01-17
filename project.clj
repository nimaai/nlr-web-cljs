(defproject nlr-web-cljs "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  ;; CLJ AND CLJS source code paths
  :source-paths ["src/clj" "src/cljs"]

  :dependencies [[domina "1.0.3"]
                 [org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [reagent "0.6.0-alpha"]]

  :plugins [[lein-cljsbuild "1.1.0"]
            [lein-figwheel "0.5.0-2"]]

  ;; cljsbuild options configuration
  :cljsbuild {:builds
              [{;; CLJS source code path
                :source-paths ["src/"]
                :figwheel true
                ;; Google Closure (CLS) options configuration
                :compiler {:main "nlr-web-cljs.main"
                           :output-to "resources/public/js/dist.js"
                           :output-dir "resources/public/js/out"
                           :asset-path "js/out"
                           :optimizations :none
                           :foreign-libs [{:file "node_modules/nlr-core/dist/main-limited.js"
                                           :provides ["js-nlr-core"]}]
                           :pretty-print true}}]}

  ;; to clean JS files generated during the build
  :clean-targets ^{:protect false} [:target-path "resources/public/js/"])
