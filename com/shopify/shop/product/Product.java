package com.shopify.shop.product;
import java.util.ArrayList;
import java.util.List;

/**
 * @author      James Runtas 
 *
 */
public class Product {
    public final String name;
    public final int id;
    public final int price;


    /**
     *@param id Product object's id (integer)
     * @param name product name
     * @param price product price
     * Product constructor to create product object with name, price, id
     */
    public Product(String name, int id, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    /**
     *Return product object name
     */
    public String getName() {
        return this.name;
    }

    /**
     *Return product object id
     */
    public int getID() {
        return this.id;
    }

    /**
     *Return product object price
     */
    public int getPrice() {
        return this.price;
    }

}

/**
 *Products class is needed to handle functionality of product lists.
 */
class Products {
    public List<Product> products = new ArrayList<Product>();


    /**
     *Products constructor calls initialize Products to create a list of all products
     */
    public Products () {
        this.initProducts();
    }

    /**
     *getProducts returns a list of all product objects
     */
    public List<Product> getProducts() {

        return products;
    }

    /**
     *Initialize a list of products with names, price, and id
     */
    public void initProducts(){
        String [] songNames = {"Kanye West  'Graduation'","The Weeknd  'After Hours'","Maggot Brain  'Funkadelic'","Young Thug  'JEFFERY'","KISS  'Love Gun'","Mac Demarco  'This Old Dog'","The Avalanches  'Wildflower'","Mac Miller  'Circles'","Bob Marley  'Exodus'","The Rolling Stones  'Sticky Fingers (Super Deluxe)'",};
        int [] songPrice = {9,14,4,9,3,11,6,15,9,10};
        for (int i=0; i <songNames.length; i++){
            this.products.add(new Product(songNames[i], i, songPrice[i]));
        }
    }



}

