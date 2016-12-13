<%-- 
    Document   : delete train
    Created on : Dec 26, 2015, Dec 26, 2015 3:25:34 PM
    Author     : Amir
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% int ID = Integer.parseInt(request.getParameter("id"));
          
            String url = "jdbc:mysql://localhost:3306/train";
            String user = "root"; //write your username
            String password = "1234"; // write your password
          
            Connection Con = null;
            Statement Stmt = null;
            ResultSet RS1 = null ;

            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                int rows = Stmt.executeUpdate("delete from train where Train_ID="+ID+";");
                response.sendRedirect("trains.jsp");
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            } 
                       
        %>
    </body>
</html>
