package com.shopify.shop.product;

/**
 * @author      James Runtas 
 *
 */


public interface ProductStockContainer {

    int getProductQuantity(Product p);
    void addProductQuantity(Product p, int n);
    boolean removeProductQuantity(Product p, int n);
    int getNumOfProducts();


}
