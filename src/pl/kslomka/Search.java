package pl.kslomka;

import java.util.*;
import java.util.stream.Collectors;

public class Search {
    private SearchIndex index;

    /**
     * @param index
     */
    public Search(SearchIndex index) {
        this.index = index;
    }

    /**
     * @param sentence
     * @return
     */
    public SearchResult search(String sentence) {
        List<String> rawResult = new ArrayList<>();
        List<String> words = Arrays.asList(sentence.split(" "))
                .stream()
                .distinct()
                .collect(Collectors.toList());

        for (String word : words) {
            if (this.index.contains(word)) {
                rawResult.addAll(this.index.get(word));
            }
        }

        return new SearchResult(words, this.groupResult(rawResult));
    }

    /**
     * @param rawResult
     * @return
     */
    private Map<String, Integer> groupResult(List<String> rawResult) {
        Map<String, Integer> occurences = new HashMap<>();
        for (String result : rawResult) {
            if (occurences.containsKey(result)) {
                occurences.put(result, occurences.get(result) + 1);
            } else {
                occurences.put(result, 1);
            }
        }

        return occurences;
    }
}
