package com.examly.springapp.controller;

import com.examly.springapp.model.StockMovement;
import com.examly.springapp.service.StockMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stockmovements")
public class StockMovController {
    
    @Autowired
    private StockMovementService stockMovementService;
    
    @PostMapping
    public ResponseEntity<StockMovement> createStockMovement(@RequestBody StockMovement stockMovement) {
        StockMovement savedStockMovement = stockMovementService.saveStockMovement(stockMovement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStockMovement);
    }
    
    @GetMapping
    public ResponseEntity<List<StockMovement>> getAllStockMovements() {
        List<StockMovement> stockMovements = stockMovementService.getAllStockMovements();
        return ResponseEntity.ok(stockMovements);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<StockMovement> getStockMovementById(@PathVariable Long id) {
        StockMovement stockMovement = stockMovementService.getStockMovementById(id);
        if (stockMovement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stockMovement);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<StockMovement> updateStockMovement(@PathVariable Long id, @RequestBody StockMovement stockMovement) {
        StockMovement updatedStockMovement = stockMovementService.updateStockMovement(id, stockMovement);
        return ResponseEntity.ok(updatedStockMovement);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockMovement(@PathVariable Long id) {
        stockMovementService.deleteStockMovement(id);
        return ResponseEntity.noContent().build();
    }
}