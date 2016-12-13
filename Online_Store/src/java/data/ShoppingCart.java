/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Amir
 */
public class ShoppingCart {
    private int shoppingCartID;
    private int userID;
    private int orderID;

    public ShoppingCart(int shoppingCartID, int userID, int orderID) {
        this.shoppingCartID = shoppingCartID;
        this.userID = userID;
        this.orderID = orderID;
    }

    public int getShoppingCartID() {
        return shoppingCartID;
    }

    public void setShoppingCartID(int shoppingCartID) {
        this.shoppingCartID = shoppingCartID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
}
