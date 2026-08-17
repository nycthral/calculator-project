package com.nycthral.calculator;

import com.nycthral.calculator.history.HistoryManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HistoryManagerTest {

    @Test
    void testAdd() {
        HistoryManager history = new HistoryManager();
        history.add("5.0 + 3.0 = 8.0");
        assertEquals(1, history.size());
    }
    @Test
    void testClear() {
        HistoryManager history = new HistoryManager();
        history.clear();
        assertEquals(0, history.size());
    }
    @Test
    void testGetLastEmpty() {
        HistoryManager history = new HistoryManager();
        assertNull(history.getLast());
    }
    @Test
    void testMaxTen() {
        HistoryManager history = new HistoryManager();
        for (int i = 0; i < 11; i++) {
            history.add("Entry " + i);
        }
        assertEquals(10, history.size());
    }
}