package com.ariel.eisner.practice.domain.service;

import com.ariel.eisner.practice.domain.port.in.MaximumWeightPathUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumWeightPathServiceTest {

    @Test
    public void testEmptyTriangle() {
        MaximumWeightPathUseCase service = new MaximumWeightPathService();

        int result = service.calculate(new int[][]{});

        Assertions.assertEquals(0, result);
    }

    @Test
    public void testSingleElementTriangle() {
        MaximumWeightPathUseCase service = new MaximumWeightPathService();

        int result = service.calculate(new int[][]{ {1} });

        Assertions.assertEquals(1, result);
    }

    @Test
    public void test2ElementTriangle() {
        MaximumWeightPathUseCase service = new MaximumWeightPathService();
        int[][] triangle = {
                {1},
                {2, 3}
        };

        int result = service.calculate(triangle);

        Assertions.assertEquals(4, result);
    }

    @Test
    public void testNegativeElementTriangle() {
        MaximumWeightPathUseCase service = new MaximumWeightPathService();
        int[][] triangle = {
                {1},
                {-2, -3},
                {4, 5, -6}
        };

        int result = service.calculate(triangle);

        Assertions.assertEquals(4, result);
    }
}