package com.nycthral.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAddition() {
        assertEquals(8.0, Calculator.calculate(5, 3, "+"),0.001);
    }
    @Test
    void testSubtraction() {
        assertEquals(14.0, Calculator.calculate(19, 5, "-"),0.001);
    }
    @Test
    void testMultiplication() {
        assertEquals(24.0, Calculator.calculate(8, 3, "*"),0.001);
    }
    @Test
    void testDivision() {
        assertEquals(2.5, Calculator.calculate(10, 4, "/"),0.001);
    }
    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class,
                () -> Calculator.calculate(5, 0, "/"));
    }
}