package com.examly.springapp.service;

import com.examly.springapp.model.StockEntry;
import com.examly.springapp.repository.StockEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockEntryServiceImpl implements StockEntryService {
    
    @Autowired
    private StockEntryRepo stockEntryRepo;
    
    @Override
    public StockEntry saveStockEntry(StockEntry stockEntry) {
        return stockEntryRepo.save(stockEntry);
    }
    
    @Override
    public List<StockEntry> getAllStockEntries() {
        return stockEntryRepo.findAll();
    }
    
    @Override
    public StockEntry getStockEntryById(Long id) {
        return stockEntryRepo.findById(id).orElse(null);
    }
    
    @Override
    public StockEntry updateStockEntry(Long id, StockEntry stockEntry) {
        stockEntry.setStockEntryId(id);
        return stockEntryRepo.save(stockEntry);
    }
    
    @Override
    public void deleteStockEntry(Long id) {
        stockEntryRepo.deleteById(id);
    }
}