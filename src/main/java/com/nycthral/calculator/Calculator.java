package com.nycthral.calculator;

public class Calculator {
    public static int calculate(int firstNum, int secondNum, String operator) {
        switch (operator) {
            case "+":
                return firstNum + secondNum;
            case "-":
                return firstNum - secondNum;
            case "*":
                return firstNum * secondNum;
            case "/":
                if (secondNum == 0) {
                    throw new ArithmeticException("Не определено");
                }
                return firstNum / secondNum;
            default:
                throw new IllegalArgumentException("Неизвестный оператор: " + operator);
        }
    }
}
