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