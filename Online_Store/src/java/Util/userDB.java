/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import data.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.tomcat.jdbc.pool.ConnectionPool;

/**
 *
 * @author Amir
 */
public class userDB {
     public void addUser(user u) {
        ConnectionPoolManager connectionPoolManager = new ConnectionPoolManager();
        Connection c=connectionPoolManager.getConnectionFromPool();
        try {

            Statement Stmt = null;
            Stmt = c.createStatement();
            Stmt.executeUpdate("insert into user values ("+0+",'"+u.getName()+"','"+u.getPassword()+"',"
                    +u.getMobileNumber()+",'"+u.getAddress()+"');");

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
     
     public int checkUser(String name,String password) {
        ConnectionPoolManager connectionPoolManager = new ConnectionPoolManager();
        Connection c=connectionPoolManager.getConnectionFromPool();
        ResultSet RS = null;

        try {

            Statement Stmt = null;
            Stmt = c.createStatement();
            RS = Stmt.executeQuery("SELECT * FROM user;");
            while(RS.next()){
                if (RS.getString("userName").equals(name) && RS.getString("password").equals(password)){
                    return RS.getInt("userID");
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return 0;
    }
     public String checkUser2(String name) {
        ConnectionPoolManager connectionPoolManager = new ConnectionPoolManager();
        Connection c=connectionPoolManager.getConnectionFromPool();
        ResultSet RS = null;

        try {

            Statement Stmt = null;
            Stmt = c.createStatement();
            RS = Stmt.executeQuery("SELECT * FROM user;");
            while(RS.next()){
                if (RS.getString("userName").equals(name)){
                    return "existing";
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return "";
    }
}
