package com.ariel.eisner.practice.domain.port.in;

import com.ariel.eisner.practice.domain.model.Rectangle;

import java.util.List;

public interface OverlappingRectanglesUseCase {
    boolean areOverlapping(List<Rectangle> rectangles);
}
