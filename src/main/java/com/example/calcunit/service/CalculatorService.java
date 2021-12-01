package com.example.calcunit.service;

public class CalculatorService {

    public int sum(int num1, int num2) {
        if (num1 > 1000 || num2 > 1000) {
            throw new IllegalArgumentException();
        }
        return num1 + num2;
    }
}
