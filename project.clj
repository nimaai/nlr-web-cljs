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

  :plugins [[lein-cljsbuild "1.1.0"]]

  ;; cljsbuild options configuration
  :cljsbuild {:builds
              [{;; CLJS source code path
                :source-paths ["src/cljs"]

                ;; Google Closure (CLS) options configuration
                :compiler {:main "nlr-web-cljs.core"
                           :output-to "resources/public/js/dist.js"
                           :output-dir "resources/public/js/out"
                           :asset-path "js/out"
                           :optimizations :none
                           :foreign-libs [{:file "https://raw.githubusercontent.com/nimaai/nlr-core/fix-dist-format/dist/main-without-data.js"
                                           :provides ["nlr-core"]}]
                           :pretty-print true}}]}

  ;; to clean JS files generated during the build
  :clean-targets ^{:protect false} [:target-path "resources/public/js/"])
