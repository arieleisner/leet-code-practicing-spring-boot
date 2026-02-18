package com.ariel.eisner.practice.application.usecase;

import com.ariel.eisner.practice.domain.port.in.TwoDimensionIteratorUseCase;

public class TwoDimensionIteratorService<T> implements TwoDimensionIteratorUseCase<T> {
    @Override
    public T next() {
        return null;
    }

    @Override
    public Boolean hasNext() {
        return Boolean.FALSE;
    }
}
