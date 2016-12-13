<%-- 
    Document   : SaveTripChanges
    Created on : Dec 26, 2015, 11:10:18 PM
    Author     : Hossam
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
            Connection Con = null ;
            Statement Stmt = null;
            Connection Con2 = null ;
            Statement Stmt2 = null;
            Connection Con3 = null ;
            Statement Stmt3 = null;
            String id=request.getParameter("tripId");
            int numberOfSeats=0;
            int ID=Integer.parseInt(request.getParameter("tripId"));
            Cookie clientCookies[] = request.getCookies();       
      for( int i = 0; i < clientCookies.length; i++)     
      {
          if (clientCookies[i].getName().equals(id))
               numberOfSeats=(Integer.parseInt(request.getParameter("numberOfSeats")))+Integer.parseInt(clientCookies[i].getValue());
      }
     
            
            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                Stmt.executeUpdate("delete from ticket where Trip_ID="+ID+";");
                
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                Stmt.executeUpdate("update trip set numberOfSeats="+numberOfSeats+" where Trip_ID="+ID+";");
            
            }catch (Exception cnfe) {
                            System.err.println("Exception: " + cnfe);
                        }
            try {
                int c_ID = Integer.parseInt(session.getAttribute("C_ID").toString());
                ResultSet RS = null ;
                Con2= DriverManager.getConnection(url, user, password);
                Stmt2 = Con2.createStatement();
                RS = Stmt2.executeQuery("select * from trip where Trip_ID="+ID+";");
                RS.next();
                String cancilationMail = "this is a cancelation email for trip  "+RS.getString("source")+"/"+RS.getString("destination");
                Con3 = DriverManager.getConnection(url, user, password);
                Stmt3 = Con3.createStatement();
                Stmt3.executeUpdate("insert into mail values ('"+cancilationMail+"',"+0+","+Integer.parseInt(RS.getString("admin_ID"))+","+c_ID+")");


            }catch (Exception cnfe) {
                            System.err.println("Exception: " + cnfe);
                        }
            response.sendRedirect("My Trips.jsp");
            %>
        <h1>Hello World!</h1>
    </body>
</html>
