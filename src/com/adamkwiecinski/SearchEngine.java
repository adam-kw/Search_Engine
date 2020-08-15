package com.adamkwiecinski;

import java.util.*;

public class SearchEngine {

    private final Map<String, Set<Integer>> index = new HashMap<>();
    private final List<String> dictionary;
    private SearchStrategy searchStrategy;

    public SearchEngine(List<String> dictionary, SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
        this.dictionary = dictionary;
        initializeIndex();
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public Map<String, Set<Integer>> getIndex() {
        return new HashMap<>(index);
    }

    public List<String> getDictionary() {
        return new ArrayList<>(dictionary);
    }

    private void initializeIndex() {
        for (String line : dictionary) {
            for (String w : line.split("\\s+")) {
                String word = w.toLowerCase();
                if (!index.containsKey(word)) {
                    index.put(word, new HashSet<>());
                }
                index.get(word).add(dictionary.indexOf(line));
            }
        }
    }

    public List<String> search(List<String> searchQuery, List<String> dictionary, Map<String, Set<Integer>> index) {
        return searchStrategy.search(searchQuery, dictionary, index);
    }
}
