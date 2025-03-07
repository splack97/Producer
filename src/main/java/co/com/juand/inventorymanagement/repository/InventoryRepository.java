package co.com.juand.inventorymanagement.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.juand.inventorymanagement.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory,Integer> {

}
