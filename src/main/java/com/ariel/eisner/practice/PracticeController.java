package com.ariel.eisner.practice;

import com.ariel.eisner.practice.dto.TwoSumRequest;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class PracticeController {

    @GetMapping("/fibonacci/{n}")
    public int fibonacci(@PathVariable int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    @GetMapping("/isPalindrome/{word}")
    public boolean isPalindrome(@PathVariable String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        return word.equalsIgnoreCase(reversed);
    }

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     */
    @PostMapping("/twoSum")
    public int[] twoSum(@RequestBody TwoSumRequest request) {
        int [] nums = request.nums();
        int target = request.target();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j}; // Return the sum of indices
                }
            }
        }
        return new int[0]; // Return an empty array if no solution is found
    }
}