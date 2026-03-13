package com.ariel.eisner.practice.infrastructure.adapter.in.rest.dto;

import java.util.List;

public record TwoDimensionArrayRequest(
        List<List<Integer>> data
) {
}
