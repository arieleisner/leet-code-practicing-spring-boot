package com.ariel.eisner.practice.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class IntersectionLineSegmentsServiceTest {

    @Test
    public void testEmptyValues() {
        IntersectionLineSegmentsService service = new IntersectionLineSegmentsService();

        int result = service.calculate(List.of(), List.of());

        Assertions.assertEquals(0, result);
    }

    @Test
    public void testAllCrossing() {
        IntersectionLineSegmentsService service = new IntersectionLineSegmentsService();

        int result = service.calculate(List.of(1, 2, 3, 4), List.of(4, 3, 2, 1));

        Assertions.assertEquals(6, result);
    }

    @Test
    public void testNoneCrossing() {
        IntersectionLineSegmentsService service = new IntersectionLineSegmentsService();

        int result = service.calculate(List.of(1, 2, 3, 4), List.of(1, 2, 3, 4));

        Assertions.assertEquals(0, result);
    }

    @Test
    public void testSomeCrossing() {
        IntersectionLineSegmentsService service = new IntersectionLineSegmentsService();

        int result = service.calculate(List.of(1, 2, 3, 4, 5), List.of(2, 1, 5, 3, 4));

        Assertions.assertEquals(3, result);
    }

    @Test
    public void testSomeCrossingRandomOrder() {
        IntersectionLineSegmentsService service = new IntersectionLineSegmentsService();

        int result = service.calculate(List.of(1, 2, 3, 4, 5, 6), List.of(3, 6, 1, 5, 2, 4));

        Assertions.assertEquals(8, result);
    }

}