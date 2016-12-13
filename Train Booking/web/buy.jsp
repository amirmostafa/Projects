<%-- 
    Document   : buy
    Created on : Dec 30, 2015, 2:56:20 PM
    Author     : MEDO
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            Connection Con = null,Con2=null ,Con3=null;
            Statement Stmt = null,Stmt2=null,Stmt3=null;
            int C_ID=Integer.parseInt(session.getAttribute("C_ID").toString());
            System.out.println("Customer:"+C_ID);
            int Trip_ID=Integer.parseInt(request.getParameter("tripId"));
            int numofT=Integer.parseInt(request.getParameter("numofT"));
            System.out.println("Trip:"+Trip_ID);
            Cookie c1 = new Cookie(request.getParameter("tripId"),request.getParameter("numofT")); 
            c1.setMaxAge(60*60*24*365*1);
            response.addCookie(c1);
            int numberOfSeats=(Integer.parseInt(request.getParameter("numberOfSeats2")))-numofT;
            System.out.println("Trisp:"+numberOfSeats);
            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                Stmt.executeUpdate("insert into ticket values (0,"+Trip_ID+","+C_ID+");");
                
                
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                Stmt.executeUpdate("update trip set numberOfSeats="+numberOfSeats+" where Trip_ID="+Trip_ID+";");
            }catch (Exception cnfe) {
                            System.err.println("Exception: " + cnfe);
                        }

            try {
                int c_ID = Integer.parseInt(session.getAttribute("C_ID").toString());
                ResultSet RS = null ;
                Con2= DriverManager.getConnection(url, user, password);
                Stmt2 = Con2.createStatement();
                RS = Stmt2.executeQuery("select * from trip where Trip_ID="+Trip_ID+";");
                RS.next();
                String confnMail = "this is a confirmation email for trip  "+RS.getString("source")+"/"+RS.getString("destination");
                Con3 = DriverManager.getConnection(url, user, password);
                Stmt3 = Con3.createStatement();
                Stmt3.executeUpdate("insert into mail values ('"+confnMail+"',"+0+","+Integer.parseInt(RS.getString("admin_ID"))+","+c_ID+")");


            }catch (Exception cnfe) {
                            System.err.println("Exception: " + cnfe);
                        }
            response.sendRedirect("My Trips.jsp");
            %>
        
    </body>
</html>

