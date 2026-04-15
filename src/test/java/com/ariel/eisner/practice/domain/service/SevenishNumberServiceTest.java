package com.ariel.eisner.practice.domain.service;

import com.ariel.eisner.practice.domain.port.in.SevenishNumberUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SevenishNumberServiceTest {

    @Test
    void calculate() {
        SevenishNumberUseCase service = new SevenishNumberService();

        assertEquals(1, service.calculate(1));
        assertEquals(7, service.calculate(2));
        assertEquals(8, service.calculate(3));
        assertEquals(49, service.calculate(4));
        assertEquals(50, service.calculate(5));
        assertEquals(56, service.calculate(6));
        assertEquals(57, service.calculate(7));
        assertEquals(343, service.calculate(8));
    }
}