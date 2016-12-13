/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;

/**
 *
 * @author Hossam
 */
public class order {
    private int orderID;
    private int userID;
    private int productID;
    private int quantity;
    private int price;
    private Date date;

    public order(int orderID, int userID, int productID, int quantity, int price, Date date) {
        this.orderID = orderID;
        this.userID = userID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }

    public void setOrderID(int oredrID) {
        this.orderID = oredrID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getUserID() {
        return userID;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }
    
    
}
