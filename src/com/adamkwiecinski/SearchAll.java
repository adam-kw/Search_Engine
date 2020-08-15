package com.adamkwiecinski;

import java.util.*;

public class SearchAll extends SearchStrategy {

    public SearchAll() {
    }

    @Override
    List<String> search(List<String> searchQuery, List<String> dictionary, Map<String, Set<Integer>> index) {
        List<String> result = new ArrayList<>();
        String words = "";
        words = String.join(words, searchQuery);
        Set<Integer> indexes = index.get(words);
        if(indexes != null && indexes.size() > 0) {
            for (Integer i : indexes) {
                result.add(dictionary.get(i));
            }
        }

        return result;
    }

}
