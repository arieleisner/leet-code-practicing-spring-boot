package com.ariel.eisner.practice.domain.service;

import com.ariel.eisner.practice.domain.port.in.LastRecentlyUsedCacheUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LastRecentlyUsedCacheServiceTest {

    @Test
    public void putTest() {
        LastRecentlyUsedCacheUseCase lruCache = new LastRecentlyUsedCacheService(2);
        lruCache.put("1", "1"); // cache is {1=1}
        lruCache.put("2", "2"); // cache is {1=1, 2=2}
        assertEquals("1", lruCache.get("1"));    // return 1
        lruCache.put("3", "3"); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        assertNull(lruCache.get("2"));    // returns -1 (not found)
        lruCache.put("4", "4"); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        assertNull(lruCache.get("1"));    // return -1 (not found)
        assertEquals("3", lruCache.get("3"));    // return 3
        assertEquals("4", lruCache.get("4"));    // return 4
    }

}