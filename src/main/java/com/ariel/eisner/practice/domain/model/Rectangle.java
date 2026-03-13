package com.ariel.eisner.practice.domain.model;

public record Rectangle(
        Coordinates topLeft,
        Coordinates dimensions
) {
    public int x() {
        return topLeft.x();
    }

    public int y() {
        return topLeft.y();
    }

    public int width() {
        return dimensions.x();
    }

    public int height() {
        return dimensions.y();
    }
}
