<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<!DOCTYPE html>
<html>
    <head>
       <meta charset="utf-8" />
    <title>Edit trip </title>
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
        margin-top:100px;
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
           int id = Integer.parseInt(request.getParameter("tripId"));
           String url = "jdbc:mysql://localhost:3306/train";
           String user = "root"; //write your username
           String password = "1234"; // write your password
           Connection Con = null;
           Statement Stmt = null;
            ResultSet RS = null;
            try{
                Con = DriverManager.getConnection(url, user,password);
                Stmt = Con.createStatement();
               RS = Stmt.executeQuery("select * from trip where Trip_ID = "+id+";");
               while(RS.next()){
        %>
        <div id="fullscreen_bg" class="fullscreen_bg"/>
 <form class="form-signin" action="Edit tripdb.jsp">
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <h3 class="text-center">
                        Edit a trip</h3>
                    <form class="form form-signup" role="form">
                        <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-home"></span>
                            </span>
                            <input name="source" type="text" class="form-control" value="<%=RS.getString("source")%>" />
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-home"></span></span>
                            <input name ="destination" type="Text" class="form-control" value="<%=RS.getString("destination")%>" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                            <input name="numberOfSeats" type="Text" class="form-control" value="<%=RS.getString("numberOfSeats")%>" />
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
                            <input name="timefrom" type="Text" class="form-control" value="<%=RS.getString("timefrom")%>" />
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
                            <input name="timeto" type="Text" class="form-control" value="<%=RS.getString("timeto")%>" />
                        </div>
                    </div>    
                     
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            <input name="tripdate" type="text" class="form-control" value="<%=RS.getString("tripdate")%>" />
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-usd"></span></span>
                            <input name="price" type="Text" class="form-control" value="<%=RS.getString("price")%>" />
                        </div>
                    </div>
                    
               
                            <%  }}catch(Exception cnfe)
          {
          System.err.println("Exception: " + cnfe);}
                %>
                </div>
                <input name="idd" type="hidden" value="<%=id%>">
                <input type="submit" class="btn btn-sm btn-primary btn-block" value="Save">
                 </form>
            </div>
        </div>
    </div>
</div>
</form>


</div> 
    </body>
</html>
