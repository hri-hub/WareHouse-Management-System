package com.examly.springapp.service;

import com.examly.springapp.model.StockMovement;
import java.util.List;

public interface StockMovementService {
    StockMovement saveStockMovement(StockMovement stockMovement);
    List<StockMovement> getAllStockMovements();
    StockMovement getStockMovementById(Long id);
    StockMovement updateStockMovement(Long id, StockMovement stockMovement);
    void deleteStockMovement(Long id);
}