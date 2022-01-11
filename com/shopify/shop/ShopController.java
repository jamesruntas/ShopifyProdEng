package com.shopify.shop;


import com.shopify.shop.product.Inventory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    @GetMapping("/shop")
    public Inventory getInventory() {
        return new Inventory();
    }

    
}
