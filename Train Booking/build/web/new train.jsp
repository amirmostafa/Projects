<%-- 
    Document   : new train
    Created on : Dec 26, 2015, Dec 26, 2015 12:14:27 PM
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
        <h1>Hello World!</h1>
        <%
            int ID=Integer.parseInt(session.getAttribute("a_ID").toString());
            out.println(ID);
            String name=request.getParameter("name");
            String type=request.getParameter("type");
            int speed=Integer.parseInt(request.getParameter("speed"));
            String seats=request.getParameter("numOfseats");
            String color=request.getParameter("color");
            String status=request.getParameter("status");

            String url = "jdbc:mysql://localhost:3306/train";
            String user = "root"; //write your username
            String password = "1234"; // write your password
          
            Connection Con = null;
            Statement Stmt = null;
            ResultSet RS1 = null ;

            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                int rows = Stmt.executeUpdate("Insert Into train values "
                            + " ('"+0+"','"+ID+"','"+type+"','"+speed+"','"+color+"','"+status+"','"+name+"');");
               
                response.sendRedirect("trains.jsp");
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            } 
        %>
    </body>
</html>
