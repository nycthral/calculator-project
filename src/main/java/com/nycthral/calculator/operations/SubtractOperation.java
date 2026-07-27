package com.nycthral.calculator.operations;

public class SubtractOperation implements Operation {
    @Override
    public double execute(double a, double b) {
        return a - b;
    }
}
