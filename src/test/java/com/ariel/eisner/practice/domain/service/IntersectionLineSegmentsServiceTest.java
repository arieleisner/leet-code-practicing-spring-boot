package com.ariel.eisner.practice.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class IntersectionLineSegmentsServiceTest {

    @Test
    public void test() {
        IntersectionLineSegmentsService service = new IntersectionLineSegmentsService();

        int result = service.calculate(List.of(), List.of());

        Assertions.assertEquals(0, result);
    }

}