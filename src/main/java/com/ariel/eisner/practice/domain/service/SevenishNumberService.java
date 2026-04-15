package com.ariel.eisner.practice.domain.service;

import com.ariel.eisner.practice.domain.port.in.SevenishNumberUseCase;

public class SevenishNumberService implements SevenishNumberUseCase {
    @Override
    public int calculate(int n) {
        int result = 0;
        int power = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                result += (int) Math.pow(7, power);
            }
            n /= 2;
            ++power;
        }
        return result;
    }
}
