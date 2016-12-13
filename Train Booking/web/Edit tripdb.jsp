<%-- 
    Document   : Edit tripdb
    Created on : Dec 26, 2015, Dec 26, 2015 5:06:14 PM
    Author     : Eddy Pooh
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
        <% int id =Integer.parseInt(request.getParameter("idd")); 
        out.println(id);
           int adminID = Integer.parseInt(session.getAttribute("a_ID").toString());
           out.print(adminID);
           String Tripsrc = request.getParameter("source"); 
           String Tripdest = request.getParameter("destination"); 
           String TripSeats = request.getParameter("numberOfSeats"); 
           String Tripstarttime = request.getParameter("timefrom"); 
           String Tripendtime = request.getParameter("timeto"); 
           String Tripdate = request.getParameter("tripdate"); 
           String Tripprice = request.getParameter("price"); 
           out.println(Tripsrc);
           out.println(Tripdest);
           out.println(TripSeats);
           out.println(Tripstarttime);
           out.println(Tripendtime);
           out.println(Tripdate);
           out.println(Tripprice);
           String url = "jdbc:mysql://localhost:3306/train";
            String user = "root"; //write your username
            String password = "1234"; // write your password
            Connection Con = null;
            Statement Stmt = null;
            ResultSet RS1 = null ;

            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                int rows = Stmt.executeUpdate("update trip  set tripdate='"+Tripdate+"',"
                        + "timefrom='"+Tripstarttime+"',timeto='"+Tripendtime+"',"
                        + "source='"+Tripsrc+"',destination='"+Tripdest+"',numberOfSeats="+TripSeats+",price="+Tripprice
                        + " where Trip_ID="+id+";");
                response.sendRedirect("Trips.jsp");
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            } 
        %>
    </body>
</html>
