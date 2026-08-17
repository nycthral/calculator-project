package com.nycthral.calculator;

import com.nycthral.calculator.history.HistoryManager;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        HistoryManager historyManager = new HistoryManager();
        CommandHandler handler = new CommandHandler(calculator, historyManager);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String result = handler.handle(input);
            if (result == null) {
                break;
            }
            System.out.println(result);
        }
    }
}