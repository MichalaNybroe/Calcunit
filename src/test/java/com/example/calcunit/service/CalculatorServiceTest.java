package com.example.calcunit.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    // Valid tests

    //Samling af flere test i en.
    @ParameterizedTest
    @CsvSource(value = {"10:20:30", "10:0:10", "10:-5:5", "10:-20:-10", "999:1000:1999"}, delimiter = ':')
    public void testSumValidTests(int num1, int num2, int expected) {
        int actual = calculatorService.sum(num1, num2);
        assertEquals(expected, actual);
    }

    // De enkelte test som er samlet i en ovenforS
    @Test
    public void testSum() {
        assertEquals(30, calculatorService.sum(10, 20));
    }

    @Test
    public void testSumWithZero() {
        assertEquals(10, calculatorService.sum(10, 0));
    }

    @Test
    public void testSumWithNegativeNumber() {
        assertEquals(5, calculatorService.sum(10, -5));
    }

    @Test
    public void testSumNegative() {
        assertEquals(-10, calculatorService.sum(10, -20));
    }

    // Invalid tests

    @Test
    public void testSumInvalidArgumentSize() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.sum(1001, 10));
    }
}