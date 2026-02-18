package com.ariel.eisner.practice.application.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoDimensionIteratorServiceTest {

    private TwoDimensionIteratorService<Integer> service;

    @BeforeEach
    void setUp() {
        service = new TwoDimensionIteratorService<>();
    }

    @Test
    public void objectCreationTest() {
        assertNotNull(service);
    }

    @Test
    public void nextIsNullTest() {
        assertNull(service.next());
    }

    @Test
    public void hasNextIsFalseTest() {
        assertFalse(service.hasNext());
    }
}