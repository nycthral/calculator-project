# Calculator Project

Консольный калькулятор на Java с историей вычислений

## Возможности

- Базовые вычисления: +, -, *, /
- Поддержка чисел с плавающей точкой
- История последних 10 операций
- Поддерживающие команды: help, history, last, clear, exit
- Архитектура: каждая операция - отдельный класс (паттерн Strategy)

## Технологии

- Java 25
- Maven
- JUnit 5

## Запуск

git clone https://github.com/nycthral/calculator-project.git
cd calculator-project
mvn exec:java

## Тесты

mvn test