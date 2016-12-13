/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Hossam
 */
public class product {
    private int productID;
    private String productName;
    private int quantity;
    private String category;
    private int price;

    public product(int productID, String productName, int quantity, String category, int price) {
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.category = category;
        this.price = price;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }
    
    
}
