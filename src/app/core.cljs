(ns app.core)

;; Works
(js/console.log (clj->js {"some" {"value" true}}))

;; Fails
(try (clj->js {"some" {:value true}})
     (catch js/Error e
       (js/console.error "Failed to parse cljs object: " e)))
