package com.shopify.shop.product;
import java.util.ArrayList;
import java.util.List;

/**
 * @author      James Runtas
 *
 *
 */


public class Inventory implements ProductStockContainer{


        //set up
        private final List<ProductStockPair> products = new ArrayList<>();
        private int numOfProducts = 0;
        public Inventory() {
            initInventory();
        }


    /**
     * @param p Product object
     * Retrieve the stock of a product p in the store inventory
     */
        @Override
        public int getProductQuantity(Product p) {
            for (ProductStockPair pair : products) {
                if (pair.product.id == p.id) {
                    return pair.stock;
                }
            }
            return -1;
        }


    /**
     * @param p Product object
     * @param q amount of product to add
     * adds amount q to product p in store inventory
     */
        @Override
        public void addProductQuantity(Product p, int q) {
            // no negative ids please
            if (p.id < 0) return;

            for (int i = 0; i < products.size(); i++) {
                ProductStockPair pair = products.get(i);
                if (pair.product.id == p.id) {
                    products.set(i, new ProductStockPair(p, pair.stock + q));
                    return;
                }
            }
            products.add(new ProductStockPair(p, q));
            numOfProducts++;
        }

    /**
     * @param p Product object
     * @param q amount of product to remove
     * removes q amount of product p from the store inventory
     */
        @Override
        public boolean removeProductQuantity(Product p, int q) {
            for (int i = 0; i < products.size(); i++) {
                ProductStockPair pair = products.get(i);
                if (pair.product.id == p.id) {
                    if (pair.stock >= q) {
                        products.set(i, new ProductStockPair(pair.product, pair.stock - q));
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }


    /**
     * Retrieve number of products in store
     */
        @Override
        public int getNumOfProducts() {
            return numOfProducts;
        }


    /**
     * Retrieve all products in the store as a list of productstockpair
     */
        public List<ProductStockPair> getProductCatalog() {
            return products;
        }

        /**
         *Initialize the inventory by adding the product stock to the corresponding product id (i)
         */
        public void initInventory() {
            products.add(new ProductStockPair(new Product("Kanye West - The Life of Pablo", 1, 10), 76));
            products.add(new ProductStockPair(new Product("Gorillaz - Song Machine Vol.1", 2, 20), 0));
            products.add(new ProductStockPair(new Product("Mac Miller - Swimming", 3, 30), 32));
            products.add(new ProductStockPair(new Product("Mac Demarco - Salad Days", 4, 40), 3));
            products.add(new ProductStockPair(new Product("BROCKHAMPTON - Saturation", 5, 30), 12));
            products.add(new ProductStockPair(new Product("Travis Scott - Astroworld", 6, 20), 132));
            products.add(new ProductStockPair(new Product("Pink Floyd - The Wall", 7, 10), 322));
            products.add(new ProductStockPair(new Product("Playboi Carti - Die Lit", 8, 10), 45));
            products.add(new ProductStockPair(new Product("The Weeknd - After Hours", 9, 20), 13));

        }

       // public String InventorytoString(List<ProductStockPair> products) {
         //   final StringBuilder sbFull = new StringBuilder("Album{");
           // for (int i = 0; i < products.size(); i++) {
             //   for (ProductStockPair pair : products) {
               //     final StringBuilder sb = new StringBuilder("Album{");
                 //   sb.append("name=").append(pair.product.name);
                   // sb.append(", id='").append(pair.product.id).append('\'');
                    //sb.append(", price=").append(pair.product.price);
                   // sb.append(", Stock=").append(pair.stock);
                   // sb.append('}');
                //    sbFull.append(sb);
               // }
           // }
           // return sbFull.toString();
       // }


}
