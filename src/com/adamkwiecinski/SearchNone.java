package com.adamkwiecinski;

import java.util.*;

public class SearchNone extends SearchStrategy {

    public SearchNone() {
    }

    @Override
    List<String> search(List<String> searchQuery, List<String> dictionary, Map<String, Set<Integer>> index) {
        List<String> result = new ArrayList<>(dictionary);
        for(String w : searchQuery){
            String word = w.toLowerCase();
            Set<Integer> indexes = index.get(word);
            if(indexes != null && indexes.size() > 0) {
                for (Integer i : indexes) {
                    result.remove(dictionary.get(i));
                }
            }
        }
        return result;
    }

}
