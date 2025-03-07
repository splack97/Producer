package co.com.juand.inventorymanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.juand.inventorymanagement.Inventory;
import co.com.juand.inventorymanagement.repository.InventoryRepository;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> allInventory(){
        //Inventory inventory = new Inventory();
        List<Inventory> inventoryList = new ArrayList<Inventory>();
        inventoryRepository.findAll().forEach(inventoryList::add);
        return inventoryList;
    }

    public Inventory getInventory(int id_product){
        //Inventory inventory = new Inventory();
        Optional<Inventory> optionalInventory = inventoryRepository.findById(id_product);
        Inventory inventory = optionalInventory.orElse(null);
        return inventory;
    }

    public void addInventory(Inventory inventory){
        inventoryRepository.save(inventory);
    }

    public void updateInventory(Inventory inventory){
        inventoryRepository.save(inventory);
    }

    public void deleteInventory(Inventory inventory){

        inventoryRepository.delete(inventory);
    }
}
