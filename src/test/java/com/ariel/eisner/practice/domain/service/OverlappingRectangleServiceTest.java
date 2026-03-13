package com.ariel.eisner.practice.domain.service;

import com.ariel.eisner.practice.domain.model.Coordinates;
import com.ariel.eisner.practice.domain.model.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OverlappingRectangleServiceTest {

    /**
     * {
     *     "top_left": (1, 4),
     *     "dimensions": (3, 3) # width, height
     * },
     * {
     *     "top_left": (-1, 3),
     *     "dimensions": (2, 1)
     * },
     * {
     *     "top_left": (0, 5),
     *     "dimensions": (4, 3)
     * }
     */
    @Test
    void areOverlapping() {
        OverlappingRectangleService service = new OverlappingRectangleService();
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(new Coordinates(1, 4), new Coordinates(3, 3)));
        rectangles.add(new Rectangle(new Coordinates(0, 5), new Coordinates(4, 3)));

        boolean areOverlapping = service.areOverlapping(rectangles);

        Assertions.assertTrue(areOverlapping);
    }

    @Test
    void areOverlapping2() {
        OverlappingRectangleService service = new OverlappingRectangleService();
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(new Coordinates(0, 0), new Coordinates(1, 1)));
        rectangles.add(new Rectangle(new Coordinates(0, 0), new Coordinates(1, 1)));

        boolean areOverlapping = service.areOverlapping(rectangles);

        Assertions.assertTrue(areOverlapping);
    }

    @Test
    void areNotOverlapping() {
        OverlappingRectangleService service = new OverlappingRectangleService();
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(new Coordinates(0, 0), new Coordinates(2, 1)));
        rectangles.add(new Rectangle(new Coordinates(10, 10), new Coordinates(3, 3)));

        boolean areOverlapping = service.areOverlapping(rectangles);

        Assertions.assertFalse(areOverlapping);
    }

    @Test
    void areNotOverlapping2() {
        OverlappingRectangleService service = new OverlappingRectangleService();
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(new Coordinates(-1, 3), new Coordinates(2, 1)));
        rectangles.add(new Rectangle(new Coordinates(0, 5), new Coordinates(4, 3)));

        boolean areOverlapping = service.areOverlapping(rectangles);

        Assertions.assertFalse(areOverlapping);
    }

    /**
     * Given two rectangles on a 2D graph, return the area of their intersection.
     * If the rectangles don't intersect, return 0.
     *
     * For example, given the following rectangles:
     *
     * {
     *     "top_left": (1, 4),
     *     "dimensions": (3, 3) # width, height
     * }
     * and
     *
     * {
     *     "top_left": (0, 5),
     *     "dimensions": (4, 3) # width, height
     * }
     * return 6.
     */
    @Test
    void area0IfNoIntersection() {
        OverlappingRectangleService service = new OverlappingRectangleService();
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(new Coordinates(-1, 3), new Coordinates(2, 1)));
        rectangles.add(new Rectangle(new Coordinates(0, 5), new Coordinates(4, 3)));

        int area = service.intersectionArea(rectangles);

        Assertions.assertEquals(0, area);
    }

    @Test
    void areaIfIntersection() {
        OverlappingRectangleService service = new OverlappingRectangleService();
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(new Coordinates(1, 4), new Coordinates(3, 3)));
        rectangles.add(new Rectangle(new Coordinates(0, 5), new Coordinates(4, 3)));

        int area = service.intersectionArea(rectangles);

        Assertions.assertEquals(6, area);
    }

    @Test
    void areaIfIntersectionAndEqualSquare() {
        OverlappingRectangleService service = new OverlappingRectangleService();
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(new Coordinates(0, 0), new Coordinates(1, 1)));
        rectangles.add(new Rectangle(new Coordinates(0, 0), new Coordinates(1, 1)));

        int area = service.intersectionArea(rectangles);

        Assertions.assertEquals(1, area);
    }

    @Test
    void areaIfIntersectionAndZeroArea() {
        OverlappingRectangleService service = new OverlappingRectangleService();
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(new Coordinates(0, 0), new Coordinates(0, 0)));
        rectangles.add(new Rectangle(new Coordinates(0, 0), new Coordinates(0, 0)));

        int area = service.intersectionArea(rectangles);

        Assertions.assertEquals(0, area);
    }
}