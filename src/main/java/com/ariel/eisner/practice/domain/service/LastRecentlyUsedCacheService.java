package com.ariel.eisner.practice.domain.service;

import com.ariel.eisner.practice.domain.port.in.LastRecentlyUsedCacheUseCase;

import java.util.LinkedHashMap;
import java.util.Map;

public class LastRecentlyUsedCacheService extends LinkedHashMap<String, String> implements LastRecentlyUsedCacheUseCase {

    private final int capacity;

    public LastRecentlyUsedCacheService(int capacity) {
        super(capacity, 1.0f, true);
        this.capacity = capacity;
    }


    @Override
    public String get(String key) {
        return super.get(key);
    }

    @Override
    public String put(String key, String value) {
        return super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return size() > capacity;
    }
}
