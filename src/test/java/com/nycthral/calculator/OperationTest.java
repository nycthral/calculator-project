package com.nycthral.calculator;

import com.nycthral.calculator.operations.DivideOperation;
import com.nycthral.calculator.operations.MultiplyOperation;
import com.nycthral.calculator.operations.SubtractOperation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.nycthral.calculator.operations.AddOperation;

class OperationTest {
    @Test
    void AddOperation() {
        AddOperation addOperation = new AddOperation();
        assertEquals(8.0, addOperation.execute(5, 3), 0.001);
    }
    @Test
    void SubtractOperation() {
        SubtractOperation subtractOperation = new SubtractOperation();
        assertEquals(12.0, subtractOperation.execute(14, 2), 0.001);
    }
    @Test
    void MultiplicationOperation() {
        MultiplyOperation multiplyoperation = new MultiplyOperation();
        assertEquals(24.0, multiplyoperation.execute(3, 8), 0.001);
    }
    @Test
    void DivideOperation() {
        DivideOperation divideoperation = new DivideOperation();
        assertEquals(7.0, divideoperation.execute(49, 7), 0.001);
    }
    @Test
    void DivideByZeroOperation() {
        DivideOperation divideByZeroOperation = new DivideOperation();
        assertThrows(ArithmeticException.class, () -> divideByZeroOperation.execute(9, 0));
    }
}
