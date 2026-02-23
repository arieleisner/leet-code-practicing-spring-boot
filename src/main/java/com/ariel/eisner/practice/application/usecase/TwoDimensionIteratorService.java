package com.ariel.eisner.practice.application.usecase;

import com.ariel.eisner.practice.domain.port.in.TwoDimensionIteratorUseCase;

public class TwoDimensionIteratorService<T> implements TwoDimensionIteratorUseCase<T> {

    private final T[][] data;
    private int row;
    private int col;

    public TwoDimensionIteratorService(T[][] data) {
        this.data = data;
        row = 0;
        col = 0;
        advanceToNextValid();
    }

    private void advanceToNextValid() {
        boolean hasNextValid = false;
        int firstCol = col;
        for (int i = row; i < data.length; ++i) {
            for (int j = firstCol; j < data[i].length; ++j) {
                if (data[i][j] != null) {
                    hasNextValid = true;
                    row = i;
                    col = j;
                    break;
                }
            }
            if (hasNextValid) {
                break;
            } else {
                firstCol = 0;
            }
        }
        if (!hasNextValid) {
            row = data.length;
        }
    }

    @Override
    public T next() {
        T toReturn = null;
        if (hasNext()) {
            toReturn = data[row][col];
            ++col;
            advanceToNextValid();
        }
        return toReturn;
    }

    @Override
    public Boolean hasNext() {
        return row < data.length;
    }
}
