package com.adamkwiecinski;

import java.util.List;
import java.util.Map;
import java.util.Set;


abstract class SearchStrategy {
    public SearchStrategy() {
    }

    abstract List<String> search(List<String> searchQuery, List<String> dictionary, Map<String, Set<Integer>> index);
}
