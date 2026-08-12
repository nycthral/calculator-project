package com.nycthral.calculator;
import java.util.List;

public class CommandHandler {
    private final Calculator calculator;
    private final HistoryManager history;

    public CommandHandler(Calculator calculator, HistoryManager history) {
        this.calculator = calculator;
        this.history = history;
    }

    public String handle(String input) {
        if (input.equals("help")) {
            return """
                    Available commands:
                    <number> <operator> <number> - calculation
                    Operators: + addition
                               - subtraction
                               * multiplication
                               / division
                    Additional commands:
                    history -- show history
                    last    -- repeat last operation
                    clear   -- clear history
                    exit    -- exit
                    """;
        }
        if (input.equals("clear")) {
            history.clear();
            return "History cleared";
        }
        if (input.equals("history")) {
            List<String> list = history.getAll();
            if (list.isEmpty()) {
                return "History is empty";
            }
            return list.toString();
        }
        if (input.equals("exit")) {
            return "exit";
        }
        if (input.equals("last")) {
            String lastEntry = history.getLast();
            if (lastEntry == null) {
                return "History is empty";
            }
            return "Last operation: " + lastEntry;
        }
        try {
            String[] parts = input.split(" ");
            if (parts.length != 3) {
                return "Error: Invalid format. Use: number, operator, number";
            }
            String firstNumber = parts[0];
            String operator = parts[1];
            String secondNumber = parts[2];
            double firstNumberDouble = Double.parseDouble(firstNumber);
            double secondNumberDouble = Double.parseDouble(secondNumber);
            double result = calculator.calculate(firstNumberDouble, secondNumberDouble, operator);
            String entry = firstNumber + " " + operator + " " + secondNumber + " = " + result;
            history.add(entry);
            return entry;
        } catch (NumberFormatException e) {
            return "Error: invalid format. Use: number, operator, number";
        } catch (ArithmeticException e) {
            return "Error: division by zero";
        } catch (IllegalArgumentException e) {
            return "Error: invalid operator";
        }
    }
}