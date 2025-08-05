package com.ariel.eisner.practice.dto;

public record TwoSumRequest(
    int[] nums,
    int target
) {

    @Override
    public String toString() {
        return "TwoSumRequest{" +
                "nums=" + java.util.Arrays.toString(nums) +
                ", target=" + target +
                '}';
    }}
