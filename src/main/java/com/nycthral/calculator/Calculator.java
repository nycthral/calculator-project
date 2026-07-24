package com.nycthral.calculator;

public class Calculator {
    public static double calculate(double firstNum, double secondNum, String operator) {
        switch (operator) {
            case "+":
                return firstNum + secondNum;
            case "-":
                return firstNum - secondNum;
            case "*":
                return firstNum * secondNum;
            case "/":
                if (secondNum == 0) {
                    throw new ArithmeticException("Not defined");
                }
                return firstNum / secondNum;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
