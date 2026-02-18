package com.ariel.eisner.practice.application.usecase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoDimensionIteratorServiceTest {

    @Test
    public void objectCreationTest() {
        TwoDimensionIteratorService<Integer> service = new TwoDimensionIteratorService<>();

        assertNotNull(service);
    }

    @Test
    public void nextIsNullTest() {
        TwoDimensionIteratorService<Integer> service = new TwoDimensionIteratorService<>();

        assertNull(service.next());
    }

    @Test
    public void hasNextIsFalseTest() {
        TwoDimensionIteratorService<Integer> service = new TwoDimensionIteratorService<>();

        assertFalse(service.hasNext());
    }

}