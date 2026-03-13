package com.ariel.eisner.practice.infrastructure.adapter.in.rest.dto;

import java.util.List;

public record GroupAnagramsRequest(
   List<String> words
) {}
