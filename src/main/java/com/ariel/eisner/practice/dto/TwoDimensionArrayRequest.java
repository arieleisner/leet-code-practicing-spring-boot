package com.ariel.eisner.practice.dto;

import java.util.List;

public record TwoDimensionArrayRequest(
        List<List<Integer>> data
) {
}
