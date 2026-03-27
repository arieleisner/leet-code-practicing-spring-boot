package com.ariel.eisner.practice.domain.service;

import com.ariel.eisner.practice.domain.port.in.ConvertTreeToStringUseCase;

import java.util.HashMap;

public class ConvertTreeToStringService implements ConvertTreeToStringUseCase {

    @Override
    public String execute(int[][] tree) {
        if (tree.length == 0) {
            return "null";
        }
        return dfsPreOrder(tree, 0, 0).toString().trim();
    }

    private StringBuilder dfsPreOrder(int[][] tree, int row, int col) {
        if (row >= tree.length) {
            return new StringBuilder(" null");
        }

        StringBuilder builder = new StringBuilder(" " + tree[row][col]);
        builder.append(dfsPreOrder(tree, row + 1, col));
        builder.append(dfsPreOrder(tree, row + 1, col + 1));
        return builder;
    }
}
