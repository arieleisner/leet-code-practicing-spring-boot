package com.ariel.eisner.practice.domain.port.in;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraysService implements ArraysUseCase {

    /**
     * Given an array of elements, return the length of the longest
     * subarray where all its elements are distinct.
     *
     * For example, given the array [5, 1, 3, 5, 2, 3, 4, 1],
     * return 5 as the longest subarray of distinct elements is [5, 2, 3, 4, 1].
     */
    @Override
    public List<Integer> longestSubarrayDistinctElements(List<Integer> elements) {
        List<Integer> longestSubarray = new ArrayList<>();
        List<Integer> aux = new ArrayList<>();

        for (int i = 0; i < elements.size() - 1; ++i) {
            aux.add(elements.get(i));
            for (int j = i+1; j < elements.size(); ++j) {
                if (!aux.contains(elements.get(j))) {
                    aux.add(elements.get(j));
                } else {
                    break;
                }
            }
            if (longestSubarray.size() < aux.size()) {
                longestSubarray.clear();
                longestSubarray.addAll(aux);
            }
            aux.clear();
        }
        return longestSubarray;
    }
}
