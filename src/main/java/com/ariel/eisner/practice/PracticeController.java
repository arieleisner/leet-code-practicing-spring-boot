package com.ariel.eisner.practice;

import com.ariel.eisner.practice.dto.GroupAnagramsRequest;
import com.ariel.eisner.practice.dto.TwoSumRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * LeetCode Problem 3: Longest Substring Without Repeating Characters
     * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">...</a>
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

    /**
     * Anagrams Grouping
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     * https://leetcode.com/problems/group-anagrams/
     *
     * Example 1:
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * Explanation:
     * There is no string in strs that can be rearranged to form "bat".
     * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
     * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
     *
     * Example 2:
     * Input: strs = [""]
     * Output: [[""]]
     *
     * Example 3:
     * Input: strs = ["a"]
     * Output: [["a"]]
     *
     * Constraints:
     * 1 <= strs.length <= 104
     * 0 <= strs[i].length <= 100
     * strs[i] consists of lowercase English letters.
     */
    @PostMapping("/groupAnagrams")
    public List<List<String>> groupAnagrams(@RequestBody GroupAnagramsRequest request) {
        Map<String, List<String>> collect = request.words().stream()
                .collect(Collectors.groupingBy(word -> word.chars()
                        .mapToObj(c -> (char) c)
                        .sorted((c1, c2) -> c2 - c1)
                        .map(String::valueOf)
                        .collect(Collectors.joining())));
        return new ArrayList<>(collect.values());
    }
}