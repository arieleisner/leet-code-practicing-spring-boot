package com.ariel.eisner.practice.application.usecase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoDimensionIteratorServiceTest {

    private TwoDimensionIteratorService<Integer> service;
    private Integer[][] matrix;

    @Test
    public void objectCreationTest() {
        matrix = new Integer[0][];
        service = new TwoDimensionIteratorService<>(matrix);

        assertNotNull(service);
    }

    @Test
    public void nextIsNullTest() {
        matrix = new Integer[0][];
        service = new TwoDimensionIteratorService<>(matrix);

        assertNull(service.next());
    }

    @Test
    public void hasNextIsFalseWhenNoElementsTest() {
        matrix = new Integer[0][];
        service = new TwoDimensionIteratorService<>(matrix);

        assertFalse(service.hasNext());
    }

    @Test
    public void hasNextIsTrueWithOneElementTest() {
        matrix = new Integer[][] { { 0 } };
        service = new TwoDimensionIteratorService<>(matrix);

        assertTrue(service.hasNext());
        assertEquals(0, service.next());
        assertFalse(service.hasNext());
        assertNull(service.next());
    }

    @Test
    public void hasNextIsTrueWithTwoElementsAndOneRowTest() {
        matrix = new Integer[][] { { 0, 1 } };
        service = new TwoDimensionIteratorService<>(matrix);

        assertTrue(service.hasNext());
        assertEquals(0, service.next());
        assertTrue(service.hasNext());
        assertEquals(1, service.next());
        assertFalse(service.hasNext());
        assertNull(service.next());
    }

    @Test
    public void hasNextIsTrueWithTwoElementsAndOneColTest() {
        matrix = new Integer[][] { { 0 }, { 1 } };
        service = new TwoDimensionIteratorService<>(matrix);

        assertTrue(service.hasNext());
        assertEquals(0, service.next());
        assertTrue(service.hasNext());
        assertEquals(1, service.next());
        assertFalse(service.hasNext());
        assertNull(service.next());
    }

    @Test
    public void hasNextIsTrueWithTwoElementsAndOneColAndOneEmptyTest() {
        matrix = new Integer[][] { { }, { 1 } };
        service = new TwoDimensionIteratorService<>(matrix);

        assertTrue(service.hasNext());
        assertEquals(1, service.next());
        assertFalse(service.hasNext());
        assertNull(service.next());
    }

    @Test
    public void hasNextIsTrueWithThreeRowsAndOneColAndTwoElementsTest() {
        matrix = new Integer[][] { { 2 }, {  }, { 3 } };
        service = new TwoDimensionIteratorService<>(matrix);

        assertTrue(service.hasNext());
        assertEquals(2, service.next());
        assertTrue(service.hasNext());
        assertEquals(3, service.next());
        assertFalse(service.hasNext());
        assertNull(service.next());
    }
}