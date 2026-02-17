package com.examly.springapp.service;

import com.examly.springapp.model.StockMovement;
import com.examly.springapp.repository.StockMovementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockMovementServiceImpl implements StockMovementService {
    
    @Autowired
    private StockMovementRepo stockMovementRepo;
    
    @Override
    public StockMovement saveStockMovement(StockMovement stockMovement) {
        return stockMovementRepo.save(stockMovement);
    }
    
    @Override
    public List<StockMovement> getAllStockMovements() {
        return stockMovementRepo.findAll();
    }
    
    @Override
    public StockMovement getStockMovementById(Long id) {
        return stockMovementRepo.findById(id).orElse(null);
    }
    
    @Override
    public StockMovement updateStockMovement(Long id, StockMovement stockMovement) {
        stockMovement.setMovementId(id);
        return stockMovementRepo.save(stockMovement);
    }
    
    @Override
    public void deleteStockMovement(Long id) {
        stockMovementRepo.deleteById(id);
    }
}