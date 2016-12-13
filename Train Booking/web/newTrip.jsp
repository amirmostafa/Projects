<%-- 
    Document   : newTrip
    Created on : Dec 26, 2015, Dec 26, 2015 11:59:34 AM
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
        <%  int adminID = 1;
            String Tripsrc = request.getParameter("src"); 
           String Tripdest = request.getParameter("Destination"); 
           String TripSeats = request.getParameter("numberOfSeats"); 
           String Tripstarttime = request.getParameter("Starting Time"); 
           String Tripendtime = request.getParameter("Ending Time"); 
           String Tripdate = request.getParameter("Date"); 
           String Tripprice = request.getParameter("Price"); 
           String url = "jdbc:mysql://localhost:3306/train";
           String user = "root"; //write your username
           String password = "1234"; // write your password
            Connection Con = null;
            Statement Stmt = null;
            ResultSet RS = null;

                Con = DriverManager.getConnection(url, user,password);
                Stmt = Con.createStatement();
                    int row = Stmt.executeUpdate("Insert Into trip values"
                    + " ("+0+","+1+",'"+Tripdate+"','"+Tripstarttime+"','"+Tripendtime+"','"+Tripsrc+"','"+Tripdest+"',"+TripSeats+","+Tripprice+");");           
                response.sendRedirect("Trips.jsp");
        %>
    </body>
</html>
