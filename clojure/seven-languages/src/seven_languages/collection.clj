(ns seven-languages.collection)

(def mapping {
	clojure.lang.PersistentList :list 
	clojure.lang.PersistentArrayMap :map
	clojure.lang.PersistentHashSet :set
	}
)

(defn collection
	[x] 
	(mapping (class x))
)
