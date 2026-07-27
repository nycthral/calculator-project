package com.nycthral.calculator.operations;

public class MultiplyOperation implements Operation {
    @Override
    public double execute(double a, double b) {
        return a * b;
    }
}
