package com.robotpal.inventoryservice.repository;

import com.robotpal.inventoryservice.dto.InventoryResponse;
import com.robotpal.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findBySkuCodeIn(List<String> skuCode);
    Boolean existsBySkuCode(String skuCode);
    Inventory findBySkuCode(String skuCode);

}
