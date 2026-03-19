package com.ariel.eisner.practice.domain.service;

import com.ariel.eisner.practice.domain.port.in.ArraysUseCase;

import java.util.ArrayList;
import java.util.List;

public class ArraysService implements ArraysUseCase {

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
