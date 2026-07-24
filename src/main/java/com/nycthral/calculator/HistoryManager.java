package com.nycthral.calculator;

import java.util.ArrayList;

public class HistoryManager {
    private ArrayList<String> historyList = new ArrayList<>();
    public void add(String entry) {
        if (historyList.size() >= 10) {
            historyList.remove(0);
        }
        historyList.add(entry);
    }
        public ArrayList<String> getAll() {
            return historyList;
        }
        public String getLast() {
        if (historyList.isEmpty()) {
            return null;
        }
        return historyList.get(historyList.size() -1);
        }
        public void clear() {
        historyList.clear();
        }
        public int size() {
        return historyList.size();
        }
    }

