package com.adamkwiecinski;

import java.util.*;

public class SearchAny extends SearchStrategy {

    public SearchAny() {
    }

    @Override
    List<String> search(List<String> searchQuery, List<String> dictionary, Map<String, Set<Integer>> index) {
        List<String> result = new ArrayList<>();
        for(String w : searchQuery){
            String word = w.toLowerCase();
            Set<Integer> indexes = index.get(word);
            if(indexes != null && indexes.size() > 0) {
                for (Integer i : indexes) {
                    result.add(dictionary.get(i));
                }
            }
        }
        return result;
    }

}
