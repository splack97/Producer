package co.com.juand.inventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.juand.inventorymanagement.Inventory;
import co.com.juand.inventorymanagement.service.InventoryService;

@RestController
public class inventoryController {

    @Autowired
    private InventoryService inventoryService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public List<Inventory> allInventory(){
        return inventoryService.allInventory();
    }

    @RequestMapping(value="/{product_id}", method = RequestMethod.GET)
    public Inventory getInventory(@PathVariable("product_id") int product_id){
        return inventoryService.getInventory(product_id);
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public void postInventory(@RequestBody Inventory inventory){
        System.out.println(inventory.getProduct_Name());
        inventoryService.addInventory(inventory);
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public void updateInventory(@RequestBody Inventory inventory){
        inventoryService.updateInventory(inventory);
    }

    @RequestMapping(value="/delete/{product_Id}", method = RequestMethod.DELETE)
    public void deleteInventory(@PathVariable("product_Id") int producto_id){
        inventoryService.deleteInventory(inventoryService.getInventory(producto_id));
    }


    
}
