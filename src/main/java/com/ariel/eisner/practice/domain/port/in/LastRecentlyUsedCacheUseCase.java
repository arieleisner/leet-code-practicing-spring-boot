package com.ariel.eisner.practice.domain.port.in;

public interface LastRecentlyUsedCacheUseCase {

    String put(String key, String value);

    String get(String key);
}
