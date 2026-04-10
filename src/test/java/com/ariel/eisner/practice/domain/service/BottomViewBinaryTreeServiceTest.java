package com.ariel.eisner.practice.domain.service;

import com.ariel.eisner.practice.domain.model.BinaryTreeNode;
import com.ariel.eisner.practice.domain.port.in.BottomViewBinaryTreeUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatcher;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BottomViewBinaryTreeServiceTest {

    public static Stream<Arguments> inputsAndOutputs() {
        BinaryTreeNode leaf1 = new BinaryTreeNode("1", null, null);
        BinaryTreeNode leaf2 = new BinaryTreeNode("2", null, null);
        return Stream.of(
                Arguments.of(leaf1, List.of("1")),
                Arguments.of(leaf2, List.of("2")),
                Arguments.of(new BinaryTreeNode("3", leaf1, leaf2), List.of("1", "3", "2")),
                Arguments.of(buildExampleTree(), List.of("0", "1", "3", "4", "8", "9"))
        );
    }

    private static BinaryTreeNode buildExampleTree() {
        BinaryTreeNode leaf0 = new BinaryTreeNode("0", null, null);
        BinaryTreeNode leaf4 = new BinaryTreeNode("4", null, null);
        BinaryTreeNode leaf6 = new BinaryTreeNode("6", null, null);
        BinaryTreeNode leaf8 = new BinaryTreeNode("8", null, null);
        BinaryTreeNode node1 = new BinaryTreeNode("1", leaf0, null);
        BinaryTreeNode node9 = new BinaryTreeNode("9", leaf8, null);
        BinaryTreeNode node3 = new BinaryTreeNode("3", node1, leaf4);
        BinaryTreeNode node7 = new BinaryTreeNode("7", leaf6, node9);
        return new BinaryTreeNode("5", node3, node7);
    }

    @ParameterizedTest
    @MethodSource("inputsAndOutputs")
    void calculateTest(BinaryTreeNode input, List<String> expectedOutput) {
        BottomViewBinaryTreeUseCase service = new BottomViewBinaryTreeService();

        List<String> result = service.calculate(input);

        Assertions.assertEquals(expectedOutput, result);
    }
}