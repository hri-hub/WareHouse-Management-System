package com.examly.springapp.repository;

import com.examly.springapp.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepo extends JpaRepository<Warehouse, Long> {
    
    @Query("SELECT w FROM Warehouse w WHERE w.location = :location")
    List<Warehouse> findByLocation(@Param("location") String location);
    
    @Query("SELECT w FROM Warehouse w WHERE w.location = :location AND w.name = :name")
    List<Warehouse> findByLocationAndName(@Param("location") String location, @Param("name") String name);
}