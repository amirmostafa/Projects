<%-- 
    Document   : Save_information
    Created on : Dec 26, 2015, 5:20:15 PM
    Author     : MEDO
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
            
            
            Connection Con = null , Con2= null;
            Statement Stmt = null, Stmt2= null;;
            Statement st = null,st2 = null;
            ResultSet RS = null, RS2= null;;
            int ID=Integer.parseInt(session.getAttribute("C_ID").toString());
            String age= request.getParameter("age");
            String Password=session.getAttribute("session_password").toString();
            String address= request.getParameter("address");
            String creditcard= request.getParameter("creditcard");
            String firstname= request.getParameter("firstname");
            String lastname= request.getParameter("lastname");
            String email= request.getParameter("email");
            System.out.println(age+firstname+email);
            try {
                System.out.println("11111111111");
            Con2 = DriverManager.getConnection(url, user, password);
            st2 = Con2.createStatement();
            st2.executeUpdate("Update customer set  Password="+Password+",Age="+age+",Address='"+address+"',CreditCard="+creditcard+",FirstName='"+firstname+"',LastName='"+lastname+"',Email='"+email+"' where customer_ID="+ID);
            System.out.println("222222222222");
            response.sendRedirect("User home page.html");       
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            } 
        %>
</html>
