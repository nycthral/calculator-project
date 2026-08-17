package com.nycthral.calculator;

import com.nycthral.calculator.history.HistoryManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommandHandlerTest {

    @Test
    void testHelp() {
        CommandHandler handler = new CommandHandler(new Calculator(), new HistoryManager());
        String result = handler.handle("help");
        assertTrue(result.contains("Available commands:"));
    }

    @Test
    void testCalculateExpression() {
        CommandHandler handler = new CommandHandler(new Calculator(), new HistoryManager());
        String result = handler.handle("5 + 3");
        assertEquals("5 + 3 = 8.0", result);
    }

    @Test
    void testClear() {
        CommandHandler handler = new CommandHandler(new Calculator(), new HistoryManager());
        String result = handler.handle("clear");
        assertEquals("History cleared", result);
    }

    @Test
    void testHistoryEmpty() {
        CommandHandler handler = new CommandHandler(new Calculator(), new HistoryManager());
        String result = handler.handle("history");
        assertEquals("History is empty", result);
    }

    @Test
    void testExit() {
        CommandHandler handler = new CommandHandler(new Calculator(), new HistoryManager());
        String result = handler.handle("exit");
        assertEquals("exit", result);
    }

    @Test
    void testInvalidFormat() {
        CommandHandler handler = new CommandHandler(new Calculator(), new HistoryManager());
        String result = handler.handle("5 +");
        assertTrue(result.contains("Invalid format"));
    }
}
