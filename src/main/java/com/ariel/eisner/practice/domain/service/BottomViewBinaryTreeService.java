package com.ariel.eisner.practice.domain.service;

import com.ariel.eisner.practice.domain.model.BinaryTreeNode;
import com.ariel.eisner.practice.domain.port.in.BottomViewBinaryTreeUseCase;

import java.util.*;
import java.util.stream.Collectors;

public class BottomViewBinaryTreeService implements BottomViewBinaryTreeUseCase {

    @Override
    public List<String> calculate(BinaryTreeNode root) {
        // dfs,
        // measure the distance on each iteration,
        // and store the pair <distance, node key> on stack
        // return a list with every top element of the stack

        TreeMap<Integer, List<String>> distancesByNode = new TreeMap<>();

        dfs(root, 0, distancesByNode);

        return distancesByNode.values().stream()
                .map(strings -> strings.get(0))
                .collect(Collectors.toList());
    }

    private void dfs(BinaryTreeNode node, Integer distance, TreeMap<Integer, List<String>> distancesByNode) {
        if (node == null) {
            return;
        }
        dfs(node.left(), distance-1, distancesByNode);
        dfs(node.right(), distance+1, distancesByNode);

        List<String> keys = distancesByNode.get(distance);
        if (keys == null) {
            keys = new ArrayList<>();
        }
        keys.add(node.key());
        distancesByNode.put(distance, keys);
    }
}
