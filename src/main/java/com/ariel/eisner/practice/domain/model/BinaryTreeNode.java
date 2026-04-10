package com.ariel.eisner.practice.domain.model;

public record BinaryTreeNode(
        String key,
        BinaryTreeNode left,
        BinaryTreeNode right
) {
}
