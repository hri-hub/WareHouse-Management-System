package com.examly.springapp.service;

import com.examly.springapp.model.Warehouse;
import com.examly.springapp.repository.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    
    @Autowired
    private WarehouseRepo warehouseRepo;
    
    @Override
    public Warehouse saveWarehouse(Warehouse warehouse) {
        return warehouseRepo.save(warehouse);
    }
    
    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepo.findAll();
    }
    
    @Override
    public Warehouse getWarehouseById(Long id) {
        return warehouseRepo.findById(id).orElse(null);
    }
    
    @Override
    public Warehouse updateWarehouse(Long id, Warehouse warehouse) {
        warehouse.setWarehouseId(id);
        return warehouseRepo.save(warehouse);
    }
    
    @Override
    public void deleteWarehouse(Long id) {
        warehouseRepo.deleteById(id);
    }
    
    @Override
    public List<Warehouse> getWarehousesByLocation(String location) {
        return warehouseRepo.findByLocation(location);
    }
    
    @Override
    public List<Warehouse> getWarehousesByLocationAndName(String location, String name) {
        return warehouseRepo.findByLocationAndName(location, name);
    }
}