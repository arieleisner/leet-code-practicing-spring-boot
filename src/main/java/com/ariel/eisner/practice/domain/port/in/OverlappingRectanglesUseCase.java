package com.ariel.eisner.practice.domain.port.in;

import com.ariel.eisner.practice.domain.model.Rectangle;

import java.util.List;

/**
 *  * Visualization:
 *          y
 *          ^
 *       y1 |      --------
 *          |      |      |
 *       y2 |      |   --------
 *          |      |   |  |   |
 *       h1 |      ----|---   |
 *          |          |      |
 *       h2 |          --------
 *         -|-----------------------------------> x
 *          |     x1  x2  w1  w2
 */
public interface OverlappingRectanglesUseCase {
    boolean areOverlapping(List<Rectangle> rectangles);

    int intersectionArea(List<Rectangle> rectangles);
}
