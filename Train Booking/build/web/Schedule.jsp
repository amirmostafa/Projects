<%-- 
    Document   : My Trips
    Created on : Dec 26, 2015, 6:16:22 PM
    Author     : Hossam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
    <title>Schedule </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
            <style>
            body
    {
        background-color: #1b1b1b;
        padding-top: 40px;
    }
    .form-signin {
       max-width: 600px;
        padding: 15px;
        margin:10px;
        margin-top:200px;
      }
    .panel-default {
    opacity: 0.7;
    /*margin-top:30px;*/
    }
    .input-group-addon
    {
        background-color: rgb(50, 118, 177);
        border-color: rgb(40, 94, 142);
        color: rgb(255, 255, 255);
    }

    .form-signup input[type="text"],.form-signup input[type="password"] { border: 1px solid rgb(50, 118, 177); }
    .fullscreen_bg {
        position: fixed;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        background-size: cover;
        background-position: 50% 50%;
        background-image: url('http://blog.transfer-iphone-recovery.com/images/photo-with-blur-background.jpg');
        background-repeat:repeat;
      }
        </style>
    </head>
    <body>
        
        <%
            
            String url = "jdbc:mysql://localhost:3306/train";
            String user = "root"; //write your username
            String password = "1234"; // write your password
            
            
            Connection Con = null ;
            Statement Stmt = null;
            Statement st = null;
            ResultSet RS = null;
            int ID=Integer.parseInt(session.getAttribute("C_ID").toString());
            
            try {
               Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                RS = Stmt.executeQuery("select * from trip ;");
                
                
            %>
        
        <div id="fullscreen_bg" class="fullscreen_bg"/>
 <form class="form-signin" action="buy.jsp">
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
        <div class="panel panel-default">
        <div class="panel panel-primary">
        
            <h3 class="text-center">
                        Schedule</h3>
        
        <div class="panel-body">    
 
 
 <table class="table table-striped table-condensed">
                  <thead>
                  <tr>
                      <th>From</th>
                      <th>To </th>
                      <th>Date</th>
                      <th>Time From</th>
                      <th>Time to</th>
                      <th>Available Seats</th>
                      <th>#OfTickets</th>
                      <th>buy</th>
                     
                  </tr>
              </thead>   
              <tbody>
                  
                <% while(RS.next()){%>
                <%  if(Integer.parseInt(RS.getString("numberOfSeats"))>0){
                    
                %>
                <tr>
                    <td align="center"><%=RS.getString("source")%></td>
                    <td align="center"><%=RS.getString("destination")%></td>
                    <td align="center"><%=RS.getString("tripdate")%></td>
                    <td align="center"><%=RS.getString("timefrom")%></td>
                    <td align="center"><%=RS.getString("timeto")%></td>
                    <td align="center"><%=RS.getString("numberOfSeats")%></td>
                     <form action="buy.jsp">
                    <td align="center"><input type="text" name ="numofT"  class="form-control" placeholder="#ofTickets" /></td>
                    
                        <input type="hidden" name="tripId" value="<%=RS.getString("Trip_ID")%>">
                        <input type="hidden" name="numberOfSeats2" value="<%=RS.getString("numberOfSeats")%>">
                <%   System.out.println("TIDhos:"+RS.getString("Trip_ID"));
                    System.out.println("NUMhos:"+RS.getString("numberOfSeats")); %>
                        <td><input type="submit" value="Buy" class="btn btn-sm btn-primary btn-block"/></td>                             
                     </form>
                     </tr>
                
                <%
                    }
                   }  
                 %>
        
              </tbody>
              </table>
                  <a href="User home page.html" class="btn btn-link" id="login_register_btn">Home Page</a>
                <%
                 } catch (Exception cnfe) {
                            System.err.println("Exception: " + cnfe);
                        } 
                %>
  </div>
       </div>
        </div>
    </div>
</div>
</form>
              
            

    </body>
</html>
