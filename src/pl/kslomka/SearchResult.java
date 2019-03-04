package pl.kslomka;

import java.util.List;
import java.util.Map;

public class SearchResult {
    private final List<String> words;
    private final Map<String, Integer> result;

    public SearchResult(List<String> words, Map<String, Integer> result) {
        this.words = words;
        this.result = result;
    }

    public List<String> getWords() {
        return words;
    }

    public Map<String, Integer> getResult() {
        return result;
    }
}
