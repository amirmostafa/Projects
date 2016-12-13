<%-- 
    Document   : delete trip
    Created on : Dec 26, 2015, Dec 26, 2015 3:28:26 PM
    Author     : Eddy Pooh
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
        <%
           int id = Integer.parseInt( request.getParameter("tripId"));
           String url = "jdbc:mysql://localhost:3306/train";
           String user = "root"; //write your username
           String password = "1234"; // write your password
           Connection Con = null;
           Statement Stmt = null;
            ResultSet RS = null;
            try{
                Con = DriverManager.getConnection(url, user,password);
                Stmt = Con.createStatement();
                    int row = Stmt.executeUpdate("delete from trip where Trip_ID = "+id+";");
               response.sendRedirect("Trips.jsp");}catch(Exception cnfe)
          {
          System.err.println("Exception: " + cnfe);}
        %>
    </body>
</html>
