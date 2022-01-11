package com.shopify.shop;

import com.shopify.shop.theshop.StoreManager;
import com.shopify.shop.theshop.StoreView;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		StoreManager sm = new StoreManager();
        StoreView sv1 = new StoreView(sm, sm.assignNewCartID());
        sv1.displayGUI();
		SpringApplication.run(ShopApplication.class, args);
		
	}

}
