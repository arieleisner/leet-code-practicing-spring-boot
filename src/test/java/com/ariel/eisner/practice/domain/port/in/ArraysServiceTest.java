package com.ariel.eisner.practice.domain.port.in;

import com.ariel.eisner.practice.domain.service.ArraysService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ArraysServiceTest {

    @Test
    void longestSubarrayDistinctElements() {
        ArraysService service = new ArraysService();
        List<Integer> elements = List.of(5, 1, 3, 5, 2, 3, 4, 1);

        List<Integer> longestSubarray = service.longestSubarrayDistinctElements(elements);

        Assertions.assertEquals(List.of(5, 2, 3, 4, 1), longestSubarray);
    }
}