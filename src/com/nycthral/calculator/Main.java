package com.nycthral.calculator;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // --- Ручные тесты ---
        System.out.println("--- Тесты ---");
        System.out.println("5 + 3 = " + calculate(5, 3, "+")); //Ожидается: 8
        System.out.println("6 * 2 = " + calculate(6, 2, "*")); // Ожидается: 12
        System.out.println("27 / 9 = " + calculate(27, 9, "/")); // Ожидается: 3
        System.out.println("3 - 1 = " + calculate(3, 1, "-")); // Ожидается: 2
        System.out.println("--- Конец тестов ---\n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String expression = scanner.nextLine();
            if (expression.equals("exit")) {
                break;
            }
            String[] parts = expression.split(" ");
            if (parts.length != 3) {
                System.out.println("Ошибка: неверный формат. Используйте: число, оператор, число");
                continue;
            }
            String firstNumber = parts[0];
            String operator = parts[1];
            String secondNumber = parts[2];
            try {
                int firstNum = Integer.parseInt(firstNumber);
                int secondNum = Integer.parseInt(secondNumber);
                int result = calculate(firstNum, secondNum, operator);
                System.out.println(firstNum + " " + operator + " " + secondNum + " = " + result);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: неверный формат. Используйте: число, оператор, число");
                continue;
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: деление на ноль");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: неверный оператор");
                continue;
            }
        }
    }

    private static int calculate(int firstNum, int secondNum, String operator) {
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