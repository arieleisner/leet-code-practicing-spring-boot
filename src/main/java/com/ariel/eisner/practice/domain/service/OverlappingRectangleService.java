package com.ariel.eisner.practice.domain.service;

import com.ariel.eisner.practice.domain.model.Rectangle;
import com.ariel.eisner.practice.domain.port.in.OverlappingRectanglesUseCase;

import java.util.List;

public class OverlappingRectangleService implements OverlappingRectanglesUseCase {

    @Override
    public boolean areOverlapping(List<Rectangle> rectangles) {
        for (int i = 0; i < rectangles.size() - 1; ++i) {
            for (int j = i+1; j < rectangles.size(); ++j) {
                if (areOverlapping(rectangles.get(i), rectangles.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int intersectionArea(List<Rectangle> rectangles) {
        if (areOverlapping(rectangles)) {
            Rectangle r1 = rectangles.get(0);
            Rectangle r2 = rectangles.get(1);
            int top = Math.min(r1.y(), r2.y());
            int bottom = Math.max(r1.y() - r1.height(), r2.y() - r2.height());
            int left = Math.max(r1.x(), r2.x());
            int right = Math.min(r1.x() + r1.width(), r2.x() + r2.width());
            int height = top - bottom;
            int width = right - left;
            return height * width;
        }
        return 0;
    }

    private boolean areOverlapping(Rectangle r1, Rectangle r2) {
        boolean r1AboveR2 = isAbove(r1, r2);
        boolean r1BelowR2 = isAbove(r2, r1);
        boolean r1LeftR2 = isLeft(r1, r2);
        boolean r1RightR2 = isLeft(r2, r1);

        return !(r1AboveR2 || r1BelowR2 || r1LeftR2 || r1RightR2);
    }

    private boolean isAbove(Rectangle r1, Rectangle r2) {
        return r1.y() + r1.height() <= r2.y();
    }

    private boolean isLeft(Rectangle r1, Rectangle r2) {
        return r1.x() + r1.width() <= r2.x();
    }
}
