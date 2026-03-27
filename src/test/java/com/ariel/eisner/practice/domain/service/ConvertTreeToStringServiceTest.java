package com.ariel.eisner.practice.domain.service;

import com.ariel.eisner.practice.domain.port.in.ConvertTreeToStringUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertTreeToStringServiceTest {

    @Test
    void executeWithEmptyTreeReturnsNull() {
        ConvertTreeToStringUseCase service = new ConvertTreeToStringService();
        int[][] tree = {};

        String result = service.execute(tree);

        Assertions.assertEquals("null", result);
    }

    @Test
    void executeWithOneNodeTreeReturnsNodeAndNullLeafs() {
        ConvertTreeToStringUseCase service = new ConvertTreeToStringService();
        int[][] tree = { { 0 } };

        String result = service.execute(tree);

        Assertions.assertEquals("0 null null", result);
    }

    @Test
    void executeWith3NodeTreeReturnsNodesAndNullLeafs() {
        ConvertTreeToStringUseCase service = new ConvertTreeToStringService();
        int[][] tree = { { 0 }, { 1, 2 } };

        String result = service.execute(tree);

        Assertions.assertEquals("0 1 null null 2 null null", result);
    }
}