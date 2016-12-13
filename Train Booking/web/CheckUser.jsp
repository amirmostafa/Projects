<%-- 
    Document   : CheckUser
    Created on : Dec 26, 2015, Dec 26, 2015 1:54:02 PM
    Author     : Amir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            String url = "jdbc:mysql://localhost:3306/train";
            String user = "root"; //write your username
            String password = "1234"; // write your password
            String Line;
            Connection Con = null , Con2= null;
            Statement Stmt = null, Stmt2= null;;
            ResultSet RS = null, RS2= null;;
            String username=session.getAttribute("session_SSN").toString();
            String Password=session.getAttribute("session_password").toString();
            
            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                RS = Stmt.executeQuery("SELECT * FROM admin where UserName='"+username+"' and "
                        + "Password='"+Password+"'");
                
                if (RS.next()){
                    session.setAttribute("a_ID", RS.getString("admin_ID"));
                    response.sendRedirect("Admin home page.html");
                }
                else {
                    Con2 = DriverManager.getConnection(url, user, password);
                    Stmt2 = Con2.createStatement();
                    RS2 = Stmt2.executeQuery("SELECT * FROM customer where UserName='"+username+"' and "
                           + "Password='"+Password+"'"); 
                    if (RS2.next()){
                        session.setAttribute("C_ID", RS2.getString("customer_ID"));
                        response.sendRedirect("User home page.html");
                    }
                    else {
                            response.sendRedirect("index.html");
                    }
                }
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            } 
        %>
    </body>
</html>
