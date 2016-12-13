/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import data.order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class orderDB {
    public void addOrder(order o) {
        ConnectionPoolManager cpm = new ConnectionPoolManager();
        Connection c = cpm.getConnectionFromPool();
        try {
                DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
                Statement Stmt = c.createStatement();
                String paramQuery = "insert into store.`order` values (?,?,?,?,?,?);";
                PreparedStatement insertOrder = c.prepareStatement(paramQuery);
                insertOrder.setInt(1, o.getOrderID());
                insertOrder.setInt(2, o.getUserID());
                insertOrder.setInt(3, o.getProductID());
                insertOrder.setInt(4, o.getQuantity());
                insertOrder.setInt(5, o.getPrice());
                insertOrder.setString(6, dateFormat.format(o.getDate()));
                int rows = insertOrder.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    public static void Deleteorder(int orderID) {
         ConnectionPoolManager cpm = new ConnectionPoolManager();
        Connection c = cpm.getConnectionFromPool();
        try {
            String paramQuery = "delete from store.`order` where orderID = ?";
            PreparedStatement deleteUser = c.prepareStatement(paramQuery);
            deleteUser.setInt(1, orderID);
            deleteUser.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }
    public ArrayList<order> getOrders(int userID) {
        ConnectionPoolManager cpm = new ConnectionPoolManager();
        Connection c = cpm.getConnectionFromPool();
        ResultSet RS = null;
        order o = null;
        ArrayList<order>orders=new ArrayList<>();
        try {
          
            Statement Stmt = c.createStatement();
            RS = Stmt.executeQuery("SELECT * FROM store.`order` where userID = "+userID+";");
            while(RS.next()){
                o = new order(RS.getInt("orderID"),userID,RS.getInt("productID"),RS.getInt("quntity"),
                RS.getInt("price"),RS.getDate("date"));
                orders.add(o);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return orders;
    }
    public static order getOrder(int orderID) {
        ConnectionPoolManager cpm = new ConnectionPoolManager();
        Connection c = cpm.getConnectionFromPool();
        ResultSet RS = null;
        order o = null;
        ArrayList<order>orders=new ArrayList<>();
        try {
          
            Statement Stmt = c.createStatement();
            RS = Stmt.executeQuery("SELECT * FROM store.`order` where orderID = "+orderID+";");
            while(RS.next()){
                o = new order(RS.getInt("orderID"),RS.getInt("userID"),RS.getInt("productID"),RS.getInt("quntity"),
                RS.getInt("price"),RS.getDate("date"));
                orders.add(o);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return o;
    }
}
