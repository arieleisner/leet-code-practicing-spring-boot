package com.ariel.eisner.practice;

import com.ariel.eisner.practice.dto.TwoSumRequest;
import org.springframework.web.bind.annotation.*;

import java.util.stream.IntStream;
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

    /**
     * LeetCode Problem 3: Longest Substring Without Repeating Characters
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/
     * Given a string s, find the length of the longest substring without duplicate characters.
     * Example 1:
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    @GetMapping("/longestSubstring/{s}")
    public int longestSubstringWithoutRepeatingCharacters(@PathVariable String s) {
        int maxLength = 1;
        int substringLength;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                substringLength = (j - i + 1);
                long countOfDifferentChars = IntStream.range(i, j + 1).mapToObj(s::charAt).distinct().count();
                if (substringLength > maxLength && countOfDifferentChars == substringLength) {
                    maxLength = substringLength;
                }
            }
        }
        return maxLength;
    }
}