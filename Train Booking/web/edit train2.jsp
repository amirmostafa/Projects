<%-- 
    Document   : edit train2
    Created on : Dec 26, 2015, Dec 26, 2015 4:07:30 PM
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
        <%
            int ID = Integer.parseInt(request.getParameter("id")) ;
            int adminID = Integer.parseInt(session.getAttribute("a_ID").toString());
            String type=request.getParameter("type");
            String name=request.getParameter("name");
            String speed=request.getParameter("speed");
            String color=request.getParameter("color");
            String status=request.getParameter("status");
            String url = "jdbc:mysql://localhost:3306/train";
            String user = "root"; //write your username
            String password = "1234"; // write your password
            System.out.println(ID+" "+adminID + " "+ color);
            Connection Con = null;
            Statement Stmt = null;
            ResultSet RS1 = null ;

            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                int rows = Stmt.executeUpdate("update train  set Train_ID="+ID+","
                        + "admin_ID="+adminID+",Type='"+type+"',Maxspeed="+speed+",Color='"+color+"',"
                        + "Status='"+status+"',TrainName='"+name+"' "
                        + "where Train_ID='"+ID+"';");
                response.sendRedirect("trains.jsp");
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            } 
                       
        %>
    </body>
</html>
