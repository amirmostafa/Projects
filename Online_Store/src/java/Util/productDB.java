/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import data.product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class productDB {
    private ArrayList <product>products = new ArrayList();
    public product getProduct(int productID) {
        ConnectionPoolManager cpm = new ConnectionPoolManager();
        Connection c = cpm.getConnectionFromPool();
        ResultSet RS = null;
        product p = null;
        try {
          
            Statement Stmt = c.createStatement();
            RS = Stmt.executeQuery("SELECT * FROM product where productID = "+productID+";");
            while(RS.next()){
                p = new product(RS.getInt("productID"),RS.getString("productName"),RS.getInt("quantity"),
                RS.getString("category"),RS.getInt("price"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return p;
    }
    public void setProducts(ArrayList<product> products) {
        this.products = products;
    }
    public ArrayList getProducts() {
        ConnectionPoolManager cpm = new ConnectionPoolManager();
        Connection c = cpm.getConnectionFromPool();
        ResultSet RS = null;
        ArrayList products = new ArrayList();
        try {
          
            Statement Stmt = c.createStatement();
            RS = Stmt.executeQuery("SELECT * FROM product;");
            while(RS.next()){
                product p = new product(RS.getInt("productID"),RS.getString("productName"),RS.getInt("quantity"),
                RS.getString("category"),RS.getInt("price"));
                products.add(p);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return products;
    }

    public void addProduct(product p) {
        ConnectionPoolManager cpm = new ConnectionPoolManager();
        Connection c = cpm.getConnectionFromPool();
        try {
                Statement Stmt = c.createStatement();
                String paramQuery = "insert into product (productID,productName,quantity,category,price) Values (?,?,?,?,?)";
                PreparedStatement insertUser = c.prepareStatement(paramQuery);
                insertUser.setInt(1, p.getProductID());
                insertUser.setString(2, p.getProductName());
                insertUser.setInt(3, p.getQuantity());
                insertUser.setString(4, p.getCategory());
                insertUser.setInt(5, p.getPrice());
                int rows = insertUser.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    public void updateProductQuantity(int productID, int quantity){
        ConnectionPoolManager cpm = new ConnectionPoolManager();
        Connection c = cpm.getConnectionFromPool();
        String paramQuery = "update product set quantity=? where productID= ?";
        PreparedStatement updateUser;
        try {
            updateUser = c.prepareStatement(paramQuery);
            updateUser.setInt(1, quantity);
            updateUser.setInt(2, productID);
            int rows = updateUser.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(productDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void DeleteProduct(int productID) {
         ConnectionPoolManager cpm = new ConnectionPoolManager();
        Connection c = cpm.getConnectionFromPool();
        try {
            String paramQuery = "delete from product where productID = ?";
            PreparedStatement deleteUser = c.prepareStatement(paramQuery);
            deleteUser.setInt(1, productID); 
            deleteUser.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }
     
     public void updateProduct(product p){
        ConnectionPoolManager cpm = new ConnectionPoolManager();
        Connection c = cpm.getConnectionFromPool();
        
        String paramQuery = "update product set productName=?, quantity=?, category=?, price=? where productID= ?";
        PreparedStatement updateUser;
        try {
            updateUser = c.prepareStatement(paramQuery);
            updateUser.setString(1, p.getProductName());
            updateUser.setInt(2, p.getQuantity());
            updateUser.setString(3, p.getCategory());            
            updateUser.setInt(4, p.getPrice());
            updateUser.setInt(5, p.getProductID());
            int rows = updateUser.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(productDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
