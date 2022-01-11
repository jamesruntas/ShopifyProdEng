package com.shopify.shop.product;

/**
 * @author      James Runtas 
 *
 *
 */
/**
 *The store view class manages the user interface.
 *The user ia able to browse a simple text store with 4 main options
 * Browse, view cart, checkout(not implemented in milestone 2) and quit.
 *
 */

public class ProductStockPair {

    public final Product product;
    public final int stock;

    public ProductStockPair(Product product, int stock) {
        this.product = product;
        this.stock = stock;
    }
}
