package com.nycthral.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAddition() {
        assertEquals(8, Calculator.calculate(5, 3, "+"));
    }

    @Test
    void testSubtraction() {
        assertEquals(14, Calculator.calculate(19, 5, "-"));
    }

    @Test
    void testMultiplication() {
        assertEquals(24, Calculator.calculate(8, 3, "*"));
    }

    @Test
    void testDivision() {
        assertEquals(7, Calculator.calculate(21, 3, "/"));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class,
                () -> Calculator.calculate(5, 0, "/"));
    }
}