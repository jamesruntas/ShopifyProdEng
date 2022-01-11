package com.shopify.shop.theshop;
import java.util.ArrayList;
import java.util.List;
import com.shopify.shop.product.Inventory;
import com.shopify.shop.product.Product;
import com.shopify.shop.product.ProductStockPair;


/**
 * @author      James Runtas 
 *
 *
 */
public class StoreManager {
    private Inventory storeInventory = new Inventory();
    private List<ShoppingCart> shoppingCarts = new ArrayList<>();
    private int shoppingCartCounter = 0;



    /**
     * create and assign a new id
     */
    public int assignNewCartID() {

        int id = shoppingCartCounter++;
        shoppingCarts.add(new ShoppingCart(id) {
            @Override
            public int getProductQuantity(Product p) {
                return 0;
            }

            @Override
            public void addProductQuantity(Product p, int n) {

            }

            @Override
            public boolean removeProductQuantity(Product p, int n) {
                return false;
            }

            @Override
            public int getNumOfProducts() {
                return 0;
            }
        });
        assert shoppingCarts != null;
        return id;
    }

    /**
     * @param p Product object
     * @param amount amount of product to add
     * @param cartID users cart ID
     * adds new product to cart
     */
    public boolean addToCart(int cartID, Product p, int amount) {
        if (storeInventory.removeProductQuantity(p, amount)) {
            for (ShoppingCart cart : shoppingCarts) {
                if (cart.getCartID() == cartID) {
                    cart.add(p, amount);
                    return true;
                }
            }
            // put items back
            storeInventory.addProductQuantity(p, amount);
        }
        return false;
    }

    /**
     * @param p Product object
     * @param amount amount of product to add
     * @param cartID users cart ID
     * removes product from cart
     */
    public boolean removeFromCart(int cartID, Product p, int amount) {
        for (ShoppingCart cart : shoppingCarts) {
            if (cart.getCartID() == cartID) {
                if (cart.remove(p, amount)) {
                    storeInventory.addProductQuantity(p, amount);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /**
     * get all products in inventory
     */
    public List<ProductStockPair> getAvailableProducts() {
        return storeInventory.getProductCatalog();
    }

    /**
     * @param cartID users cart ID
     * get all products in users cart
     */
    public List<ProductStockPair> getCartContents(int cartID) {
        for (ShoppingCart cart : shoppingCarts) {
            if (cart.getCartID() == cartID) {
                return cart.getContents();
            }
        }
        return new ArrayList<>(); // just give an empty ArrayList if not found
    }

    /**
     * @param cartID users cart ID
     * clear all products in users cart
     */
    public void clearCartContents(int cartID) {
        for (ShoppingCart cart : shoppingCarts) {
            if (cart.getCartID() == cartID) {
                List<ProductStockPair> stuffToPutBack = cart.getContents();
                for (ProductStockPair pair : stuffToPutBack) {
                    storeInventory.addProductQuantity(pair.product, pair.stock);
                }
                // delete cart from shoppingCarts
                shoppingCarts.remove(cart);
                return;
            }
        }
    }

    /**
     * @param cartID users cart ID
     * get all product prices in users cart
     */
    public double getCartTotal(int cartID) {
        for (ShoppingCart cart : shoppingCarts) {
            if (cart.getCartID() == cartID) {
                return cart.getTotal();
            }
        }
        return -1.0;
    }
}