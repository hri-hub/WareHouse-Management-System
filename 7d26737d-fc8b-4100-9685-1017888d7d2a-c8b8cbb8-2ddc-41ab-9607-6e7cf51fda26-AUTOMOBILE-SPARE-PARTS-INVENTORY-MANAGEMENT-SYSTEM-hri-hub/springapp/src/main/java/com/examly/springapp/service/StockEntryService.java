package com.examly.springapp.service;

import com.examly.springapp.model.StockEntry;
import java.util.List;

public interface StockEntryService {
    StockEntry saveStockEntry(StockEntry stockEntry);
    List<StockEntry> getAllStockEntries();
    StockEntry getStockEntryById(Long id);
    StockEntry updateStockEntry(Long id, StockEntry stockEntry);
    void deleteStockEntry(Long id);
}