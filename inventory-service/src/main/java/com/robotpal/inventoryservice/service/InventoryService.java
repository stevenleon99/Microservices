package com.robotpal.inventoryservice.service;

import com.robotpal.inventoryservice.dto.InventoryResponse;
import com.robotpal.inventoryservice.model.Inventory;
import com.robotpal.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInInventory(List<String> skuCode){

        List<InventoryResponse> inventoryResponseList = new ArrayList<>();
        InventoryResponse inventoryResponse = new InventoryResponse();
        // check stock
        for (String tempSkuCode : skuCode) {
            inventoryResponse.setSkuCode(tempSkuCode);
            Inventory tempInventory = inventoryRepository.findBySkuCode(tempSkuCode);
            if (tempInventory != null){
                inventoryResponse.setIsInStock(tempInventory.getQuantity() > 0);
            }else {
                inventoryResponse.setIsInStock(false);
            }
            inventoryResponseList.add(inventoryResponse);
        }

        return inventoryResponseList;
    }

}
