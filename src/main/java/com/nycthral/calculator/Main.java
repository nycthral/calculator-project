package com.nycthral.calculator;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // --- Ручные тесты ---
        System.out.println("--- Tests ---");
        System.out.println("5 + 3 = " + Calculator.calculate(5, 3, "+")); //expected: 8
        System.out.println("6 * 2 = " + Calculator.calculate(6, 2, "*")); // expected: 12
        System.out.println("10 / 4 = " + Calculator.calculate(10, 4, "/")); // expected: 2.5
        System.out.println("3 - 1 = " + Calculator.calculate(3, 1, "-")); // expected: 2
        System.out.println("--- End of tests ---\n");
        Scanner scanner = new Scanner(System.in);
        HistoryManager historyManager = new HistoryManager();
        while (true) {
            System.out.print("> ");
            String expression = scanner.nextLine();
            if (expression.equals("history")) {
                List<String> list = historyManager.getAll();
                if (list.isEmpty()) {
                System.out.println("History is empty");
            } else {
                System.out.println(list);
                }
                continue;
            }
            if (expression.equals("last")) {
                String lastEntry = historyManager.getLast();
                if (lastEntry == null) {
                    System.out.println("History is empty");
                } else  {
                    System.out.println("Last operation: " + lastEntry);
                }
                continue;
            }
            if (expression.equals("clear")) {
                historyManager.clear();
                System.out.println("History cleared");
                continue;
            }
            if (expression.equals("help")) {
                System.out.println("Available commands:");
                System.out.println("<number> <operator> <number> - calculation");
                System.out.println("Operators: + addition");
                System.out.println("           - subtraction");
                System.out.println("           * multiplication");
                System.out.println("           / division");
                System.out.println("Additional commands:");
                System.out.println("history -- show history");
                System.out.println("last    -- repeat last operation");
                System.out.println("clear   -- clear history");
                System.out.println("exit    -- exit");
                continue;
            }
            if (expression.equals("exit")) {
                break;
            }
            String[] parts = expression.split(" ");
            if (parts.length != 3) {
                System.out.println("Error: Invalid format. Use: number, operator, number");
                continue;
            }
            String firstNumber = parts[0];
            String operator = parts[1];
            String secondNumber = parts[2];
            try {
                double firstNum = Double.parseDouble(firstNumber);
                double secondNum = Double.parseDouble(secondNumber);
                double result = Calculator.calculate(firstNum, secondNum, operator);
                System.out.println(firstNum + " " + operator + " " + secondNum + " = " + result);
                historyManager.add(firstNum + " " + operator + " " + secondNum + " = " + result);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid format. Use: number, operator, number");
                continue;
            } catch (ArithmeticException e) {
                System.out.println("Error: division by zero");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Invalid operator");
                continue;
            }
        }
    }
}