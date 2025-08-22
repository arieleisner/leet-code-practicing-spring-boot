package com.ariel.eisner.practice;

import com.ariel.eisner.practice.dto.GroupAnagramsRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PracticeControllerTest {

    @Test
    void fibonacciTest() {
        PracticeController practiceController = new PracticeController();
        assertEquals(0, practiceController.fibonacci(0));
        assertEquals(1, practiceController.fibonacci(1));
    }

    @Test
    void isPalindrome() {
        PracticeController practiceController = new PracticeController();
        assertTrue(practiceController.isPalindrome("oro"));
        assertFalse(practiceController.isPalindrome("not-a-palindrome"));
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


    @Test
    public void testGroupAnagrams() {
        PracticeController practiceController = new PracticeController();
        equalsIgnoringOrder(List.of(), practiceController.groupAnagrams(new GroupAnagramsRequest(List.of())));
        equalsIgnoringOrder(List.of(List.of("a")), practiceController.groupAnagrams(new GroupAnagramsRequest(List.of("a"))));
        equalsIgnoringOrder(List.of(List.of("a"), List.of("b")), practiceController.groupAnagrams(new GroupAnagramsRequest(List.of("a", "b"))));
        equalsIgnoringOrder(List.of(List.of("ab", "ba"), List.of("b")), practiceController.groupAnagrams(new GroupAnagramsRequest(List.of("ab", "b", "ba"))));
        equalsIgnoringOrder(List.of(List.of("ate", "eat", "tea"), List.of("nat", "tan"), List.of("bat")), practiceController.groupAnagrams(new GroupAnagramsRequest(List.of("eat", "tea", "tan", "ate", "nat", "bat"))));
    }

    private void equalsIgnoringOrder(List<List<String>> expected, List<List<String>> actual) {
        Assertions.assertThat(actual)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expected);
    }
}