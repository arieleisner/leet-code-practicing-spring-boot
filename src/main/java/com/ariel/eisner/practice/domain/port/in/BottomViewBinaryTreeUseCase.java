package com.ariel.eisner.practice.domain.port.in;

import com.ariel.eisner.practice.domain.model.BinaryTreeNode;

import java.util.List;

/**
 * The horizontal distance of a binary tree node describes how far left or right the node
 * will be when the tree is printed out.
 * <p>
 * More rigorously, we can define it as follows:
 * <p>
 * The horizontal distance of the root is 0.
 * The horizontal distance of a left child is hd(parent) - 1.
 * The horizontal distance of a right child is hd(parent) + 1.
 * For example, for the following tree, hd(1) = -2, and hd(6) = 0.
 * <p>
 *              5
 *           /     \
 *         3         7
 *       /  \      /   \
 *     1     4    6     9
 *    /                /
 *   0                8
 * The bottom view of a tree, then, consists of the lowest node at each horizontal distance.
 * If there are two nodes at the same depth and horizontal distance, either is acceptable.
 * <p>
 * For this tree, for example, the bottom view could be [0, 1, 3, 6, 8, 9],
 * or also [0, 1, 3, 4, 8, 9], since 4 and overlaps in the hd = 0 at the bottom.
 * <p>
 * Given the root to a binary tree, return its bottom view.
 */
public interface BottomViewBinaryTreeUseCase {
    List<String> calculate(BinaryTreeNode root);
}
