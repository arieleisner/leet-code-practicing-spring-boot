package com.ariel.eisner.practice.domain.service;

import com.ariel.eisner.practice.domain.port.in.MaximumWeightPathUseCase;

import java.util.HashMap;
import java.util.Map;

public class MaximumWeightPathService implements MaximumWeightPathUseCase {
    @Override
    public int calculate(int[][] triangle) {
        if (triangle.length == 0) {
            return 0;
        }
        return dfsPostOrder(triangle, 0, 0, new HashMap<>());
    }

    private int dfsPostOrder(int[][] triangle, int row, int col, Map<String, Integer> memo) {
        if (row == triangle.length - 1) {
            return triangle[row][col];
        }

        String key = row + "," + col;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int left = dfsPostOrder(triangle, row + 1, col, memo);
        int right = dfsPostOrder(triangle, row + 1, col + 1, memo);

        int result = triangle[row][col] + Math.max(left, right);

        memo.put(key, result);

        return result;
    }
}
