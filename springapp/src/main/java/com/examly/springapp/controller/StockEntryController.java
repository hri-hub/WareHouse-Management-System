package com.examly.springapp.controller;

import com.examly.springapp.model.StockEntry;
import com.examly.springapp.service.StockEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stockentries")
public class StockEntryController {
    
    @Autowired
    private StockEntryService stockEntryService;
    
    @PostMapping
    public ResponseEntity<StockEntry> createStockEntry(@RequestBody StockEntry stockEntry) {
        StockEntry savedStockEntry = stockEntryService.saveStockEntry(stockEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStockEntry);
    }
    
    @GetMapping
    public ResponseEntity<List<StockEntry>> getAllStockEntries() {
        List<StockEntry> stockEntries = stockEntryService.getAllStockEntries();
        return ResponseEntity.ok(stockEntries);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<StockEntry> getStockEntryById(@PathVariable Long id) {
        StockEntry stockEntry = stockEntryService.getStockEntryById(id);
        if (stockEntry == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stockEntry);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<StockEntry> updateStockEntry(@PathVariable Long id, @RequestBody StockEntry stockEntry) {
        StockEntry updatedStockEntry = stockEntryService.updateStockEntry(id, stockEntry);
        return ResponseEntity.ok(updatedStockEntry);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockEntry(@PathVariable Long id) {
        stockEntryService.deleteStockEntry(id);
        return ResponseEntity.noContent().build();
    }
}