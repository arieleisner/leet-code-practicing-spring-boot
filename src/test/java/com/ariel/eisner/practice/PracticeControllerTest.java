package com.ariel.eisner.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PracticeControllerTest {

    @Test
    void fibonacci() {
    }

    @Test
    void isPalindrome() {
    }

    @Test
    void twoSum() {
    }

    @Test
    void longestSubstringWithoutRepeatingCharacters() {
        PracticeController practiceController = new PracticeController();
        assertEquals(1, practiceController.longestSubstringWithoutRepeatingCharacters("a"));
        assertEquals(1, practiceController.longestSubstringWithoutRepeatingCharacters("aa"));
        assertEquals(1, practiceController.longestSubstringWithoutRepeatingCharacters("aaaa"));
        assertEquals(2, practiceController.longestSubstringWithoutRepeatingCharacters("ab"));
        assertEquals(2, practiceController.longestSubstringWithoutRepeatingCharacters("abbb"));
        assertEquals(2, practiceController.longestSubstringWithoutRepeatingCharacters("cdcdcdcd"));
        assertEquals(3, practiceController.longestSubstringWithoutRepeatingCharacters("cdcdecdcd"));
        assertEquals(4, practiceController.longestSubstringWithoutRepeatingCharacters("cdcdecdcdef"));
    }
}