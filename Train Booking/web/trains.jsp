<%-- 
    Document   : trains
    Created on : Dec 26, 2015, Dec 26, 2015 1:18:27 PM
    Author     : Amir
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8" />
    <title>Trains</title>
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
       max-width: 280px;
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
        <div id="fullscreen_bg" class="fullscreen_bg"/>
 <form class="form-signin" action="Edit train.jsp">
<div class="container">
    <div class="row">
        <div class="col-md-5 col-md-offset-3">
        <div class="panel panel-default">
        <div class="panel panel-primary">
        
            <h3 class="text-center">
                        Trains</h3>
        
        <div class="panel-body">    
 
 
 <table class="table table-striped table-condensed">
                  <thead>
                  <tr>
                      <th align="center">Name</th>
                      <th align="center">Type</th>
                      <th align="center">MaxSpeed</th>
                      <th align="center">Color</th>
                      <th align="center">Status</th>
                      <th align="center">Edit</th>
                      <th align="center">Delete</th>    
                  </tr>
              </thead>   
              <tbody>
                 <% 
                  String url = "jdbc:mysql://localhost:3306/train";
            String user = "root"; //write your username
            String password = "1234"; // write your password
          
            Connection Con = null;
            Statement Stmt = null;
            ResultSet RS1 = null ;
            
            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                RS1 = Stmt.executeQuery("SELECT * FROM train;"); 
                
                while (RS1.next()) {
                String name = RS1.getString("TrainName");
                String type = RS1.getString("Type");
                String status = RS1.getString("Status");
                String speed = RS1.getString("Maxspeed"); 
                String color = RS1.getString("Color");%>
                <tr>
                    <td align="center"><%= name %></td>
                    <td align="center"><%= type %></td>
                    <td align="center"><%= speed %></td>
                    <td align="center"><%= color %></td>
                    <td><span class="label label-success"><%= status %></span></td>
              <form action="Edit train.jsp">
                  <input type="hidden" name="id" value="<%= RS1.getString("Train_ID")%>" />
                  <td><input type="submit" class="btn btn-sm btn-primary btn-block" value="Edit" /></td>
              </form>
                   
                 <form action="delete train.jsp">
                  <input type="hidden" name="id" value="<%= RS1.getString("Train_ID")%>" /> 
                  <td><input type="submit" class="btn btn-sm btn-primary btn-block" value="Delete" /></td>
              </form>
              </tr>
              
                    <%
                }
            } catch (Exception cnfe) {
                 System.err.println("Exception: " + cnfe);
            } 
                %>
                <tr>
              </tbody>
              </table>
                  <a href="New train.html" class="btn btn-sm btn-primary btn-block" role="button">Add new train</a>
                       <a href="Admin home page.html" class="btn btn-sm btn-primary btn-block" role="button">Home</a> 
        </div>           
       </div>
        </div>
    </div>
</div>


              
            

    </form>
</body>
</html>
