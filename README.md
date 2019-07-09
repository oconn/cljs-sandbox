Looks like under simple/advanced compilation `clj->js` is losing reference to `keyword-fn` and is throwing `TypeError: Cannot read property 'cljs$core$IFn$_invoke$arity$1' of undefined`

I've create a simple example that demonstrates the issue.

1) Run clojure -Abuild
2) Start http-server in target/public
3) Open devtools

```clojure
(ns app.core)

;; Works
(js/console.log (clj->js {"some" {"value" true}}))

;; Fails
(try (clj->js {"some" {:value true}})
     (catch js/Error e
       (js/console.error "Failed to parse cljs object: " e)))
```
