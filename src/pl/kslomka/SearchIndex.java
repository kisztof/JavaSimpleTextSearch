package pl.kslomka;

import java.util.*;

public class SearchIndex {
    private Map<String, ArrayList<String>> index;
    private IndexNormalizer normalizer;

    /**
     * @param normalizer
     */
    public SearchIndex(IndexNormalizer normalizer) {
        this.normalizer = normalizer;
        this.index = new HashMap<>();
    }

    /**
     * Builds index
     *
     * @param scanner
     * @param indexNamespace
     */
    public void build(Scanner scanner, String indexNamespace) {
        while (scanner.hasNext()) {
            String word = scanner.next();
            this.add(word, indexNamespace);
        }
    }

    /**
     * Get index key value
     *
     * @param key
     * @return
     */
    public ArrayList<String> get(String key) {
        return this.index.get(this.normalizer.normalize(key));
    }

    /**
     * Contains a key
     *
     * @param key
     * @return
     */
    public Boolean contains(String key) {
        return this.index.containsKey(this.normalizer.normalize(key));
    }

    /**
     * SearchIndex a value
     *
     * @param key
     * @param value
     */
    private void add(String key, String value) {
        String normalizedKey = this.normalizer.normalize(key);
        if (this.index.containsKey(normalizedKey)) {
            ArrayList<String> el = this.index.get(normalizedKey);
            if (!el.contains(value)) {
                el.add(value);
            }

        } else {
            this.index.put(normalizedKey, new ArrayList<>(Arrays.asList(value)));
        }
    }
}
