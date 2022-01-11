package com.shopify.shop.theshop;
import java.util.List;
import javax.swing.*;

import com.shopify.shop.product.ProductStockPair;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author      James Runtas 
 *
 *
 */


/**
 *The store view class manages the user interface.
 *The user is able to browse a simple Graphic interface store
 */
public class StoreView {

    public StoreManager sm;
    private int cartID;

    public StoreView(StoreManager sm, int cartID) {
        this.sm = sm;
        this.cartID = cartID;
    }

    /**
     * Method to create the Cart Java Swing application
     * Allows user to view cart including all product details
     */
    private void cartGUI() {
        StringBuilder sb = new StringBuilder("");
        for (ProductStockPair item : sm.getCartContents(cartID)) {
            sb.append(item.product.name).append(" , $").append(item.product.price).append("| \n");
        }

        JFrame cartFrame = new JFrame();

        cartFrame.setTitle("Your Shopping Cart");
        //cartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel bodyLabel = new JLabel(sb.toString());
        JPanel mainPanel = new JPanel();
        JPanel bodyPanel = new JPanel();

        bodyPanel.add(bodyLabel);

        bodyPanel.setPreferredSize(new Dimension(500, 100));
        mainPanel.add(bodyPanel);
        cartFrame.add(mainPanel);
        cartFrame.pack();
        cartFrame.setVisible(true);

    }

    /**
     *@param prodID Product object's id (integer)
     * Method that adds functionality to add (+) button
     * takes the id of corresponding button and song and adds to cart
     */
    private void addPage(int prodID) {

        List<ProductStockPair> products = sm.getAvailableProducts();

        try{
            sm.addToCart(cartID, products.get(prodID-1).product, 1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * Method to create the checkout Java Swing application
     * upon closing this app, the whole program ends.
     */
    private void getCheckoutGUI() {

        StringBuilder sb = new StringBuilder(" \n");
        sb.append("Your total is: $ ").append(sm.getCartTotal(cartID)).append("\nThank you have a great day!\n");
        sb.toString();

        JFrame checkoutFrame = new JFrame();

        checkoutFrame.setTitle("Your Shopping Cart");
        checkoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel bodyLabel = new JLabel(sb.toString());
        JPanel mainPanel = new JPanel();
        JPanel bodyPanel = new JPanel();

        bodyPanel.add(bodyLabel);

        bodyPanel.setPreferredSize(new Dimension(500, 100));
        mainPanel.add(bodyPanel);
        checkoutFrame.add(mainPanel);
        checkoutFrame.pack();
        checkoutFrame.setVisible(true);

    }


    /**
     * Method to create the Java Swing application.
     * Allows user to browse the store, view cart and check out
     */
    public void displayGUI() {

        JFrame frame = new JFrame();

        frame.setTitle("Music Store");
        JLabel headerLabel = new JLabel("Music Store: Home Page");
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel headerPanel = new JPanel();
        JPanel bodyPanel = new JPanel();
        JPanel innerProduct1 = new JPanel();
        JPanel innerProduct2 = new JPanel();
        JPanel innerProduct3 = new JPanel();
        JPanel innerProduct4 = new JPanel();
        JPanel innerProduct5 = new JPanel();
        JPanel innerProduct6 = new JPanel();
        JPanel innerProduct7 = new JPanel();
        JPanel innerProduct8 = new JPanel();
        JPanel innerProduct9 = new JPanel();
        JPanel footerPanel = new JPanel();




        //Header Graphics
        headerPanel.add(headerLabel);
        headerPanel.setPreferredSize(new Dimension(250, 200));
        headerPanel.setBackground(Color.darkGray);


        innerProduct1.add(productPanel(1));
        innerProduct1.add(addtoCartButton(1));
        innerProduct1.add(removeFromCartButton(1));
        innerProduct1.setPreferredSize(new Dimension(220, 180));
        innerProduct1.setBackground(Color.pink);


        innerProduct2.add(productPanel(2));
        innerProduct2.add(addtoCartButton(2));
        innerProduct2.add(removeFromCartButton(2));
        innerProduct2.setPreferredSize(new Dimension(220, 180));
        innerProduct2.setBackground(Color.pink);


        innerProduct3.add(productPanel(3));
        innerProduct3.add(addtoCartButton(3));
        innerProduct3.add(removeFromCartButton(3));
        innerProduct3.setPreferredSize(new Dimension(220, 180));
        innerProduct3.setBackground(Color.pink);


        innerProduct4.add(productPanel(4));
        innerProduct4.add(addtoCartButton(4));
        innerProduct4.add(removeFromCartButton(4));
        innerProduct4.setPreferredSize(new Dimension(220, 180));
        innerProduct4.setBackground(Color.pink);


        innerProduct5.add(productPanel(5));
        innerProduct5.add(addtoCartButton(5));
        innerProduct5.add(removeFromCartButton(5));
        innerProduct5.setPreferredSize(new Dimension(220, 180));
        innerProduct5.setBackground(Color.pink);



        innerProduct6.add(productPanel(6));
        innerProduct6.add(addtoCartButton(6));
        innerProduct6.add(removeFromCartButton(6));
        innerProduct6.setPreferredSize(new Dimension(220, 180));
        innerProduct6.setBackground(Color.pink);

        innerProduct7.add(productPanel(7));
        innerProduct7.add(addtoCartButton(7));
        innerProduct7.add(removeFromCartButton(7));
        innerProduct7.setPreferredSize(new Dimension(220, 180));
        innerProduct7.setBackground(Color.pink);

        innerProduct8.add(productPanel(8));
        innerProduct8.add(addtoCartButton(8));
        innerProduct8.add(removeFromCartButton(8));
        innerProduct8.setPreferredSize(new Dimension(220, 180));
        innerProduct8.setBackground(Color.pink);

        innerProduct9.add(productPanel(9));
        innerProduct9.add(addtoCartButton(9));
        innerProduct9.add(removeFromCartButton(9));
        innerProduct9.setPreferredSize(new Dimension(220, 180));
        innerProduct9.setBackground(Color.pink);

        bodyPanel.setPreferredSize(new Dimension(864, 700));
        bodyPanel.setBackground(Color.darkGray);

        bodyPanel.add(innerProduct1);
        bodyPanel.add(innerProduct2);
        bodyPanel.add(innerProduct3);
        bodyPanel.add(innerProduct4);
        bodyPanel.add(innerProduct5);
        bodyPanel.add(innerProduct6);
        bodyPanel.add(innerProduct7);
        bodyPanel.add(innerProduct8);
        bodyPanel.add(innerProduct9);

        footerPanel.setPreferredSize(new Dimension(250, 100));
        footerPanel.setBackground(Color.darkGray);
        footerPanel.add(checkoutButton());
        footerPanel.add(cartButton());

        mainPanel.add(headerPanel, BorderLayout.PAGE_START);
        mainPanel.add(bodyPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.PAGE_END);


        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Create new cart button that calls
     * getCartGUI upon click
     */
    private JButton cartButton() {
        JButton button1 = new JButton("View Cart");
        button1.setPreferredSize(new Dimension(100, 50));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    cartGUI();

            }});return button1;
    }

    /**
     *@param prodID Product object's id (integer)
     *creates a new add (+) button that calls addPage and add product to cart
     */
    private JButton addtoCartButton(int prodID) {
        JButton button4 = new JButton("+");
        button4.setPreferredSize(new Dimension(50, 20));

        List<ProductStockPair> products = sm.getAvailableProducts();
        for (ProductStockPair item : products) {
            if (item.product.id == prodID) {
                if (item.stock != 0) {
                    button4.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ae) {
                            addPage(prodID);
                            //System.out.println("($" + item.product.price + ")" + " - Stock: " + sm.getProductStock(prodID));
                        }});
                }
            }
        }

        return button4;
    }

    /**
     *@param prodID Product object's id (integer)
     *creates a new remove (-) button that calls removePage and remove product to cart
     */
    private JButton removeFromCartButton(int prodID) {
        JButton button5 = new JButton("-");
        button5.setPreferredSize(new Dimension(50, 20));
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                List<ProductStockPair> products = sm.getAvailableProducts();
                for (ProductStockPair item : products) {
                    if (item.product.id == prodID) {
                        if (sm.removeFromCart(cartID, item.product, 1)) {
                            //System.out.println("($" + item.product.price + ")" + " - Stock: " + sm.getProductStock(prodID));
                        }
                    }
                }

            }});return button5;
    }

    /**
     * Create new checkout button that calls
     * getCheckoutGUI upon click
     */
    private JButton checkoutButton() {
        JButton button6 = new JButton("Checkout");
        button6.setPreferredSize(new Dimension(100, 50));
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                getCheckoutGUI();

            }});return button6;
    }

    /**
     *@param prodID Product object's id (integer)
     *creates a new panel that displays information of a product of id prodID
     */
    private JPanel productPanel(int prodID) {
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(200, 120));

        List<ProductStockPair> products = sm.getAvailableProducts();
        for (ProductStockPair item : products) {
            if (item.product.id == prodID){
                JLabel pLabel1 = new JLabel("#" + String.valueOf(item.stock));
                JLabel pLabel2 = new JLabel(item.product.name);
                JLabel pLabel3 = new JLabel("$" + item.product.price);
                p.add(pLabel1);p.add(pLabel2);p.add(pLabel3);
            }
        }
        return p;
    }

}







