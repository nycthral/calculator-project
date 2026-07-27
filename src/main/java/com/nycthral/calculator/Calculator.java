package com.nycthral.calculator;

import java.util.HashMap;
import java.util.Map;
import com.nycthral.calculator.operations.*;

public class Calculator {
    private static final Map<String, Operation> operations = new HashMap<>();

    static {
        operations.put("+", new AddOperation());
        operations.put("-", new SubtractOperation());
        operations.put("*", new MultiplyOperation());
        operations.put("/", new DivideOperation());
    }

    public static double calculate(double firstNum, double secondNum, String operator) {
        Operation operation = operations.get(operator);
        if (operation == null) {
            throw new IllegalArgumentException("Unknown operation: " + operator);
        }
        return operation.execute(firstNum, secondNum);
    }
}