<%-- 
    Document   : Edit personal information
    Created on : Dec 26, 2015, 4:21:40 PM
    Author     : MEDO
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
    <title>Sign up </title>
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
        margin:-70px;
        margin-top:60px;
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
            String Line;
            Connection Con = null , Con2= null;
            Statement Stmt = null, Stmt2= null;;
            ResultSet RS = null, RS2= null;;
            int ID=Integer.parseInt(session.getAttribute("C_ID").toString());
         
            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+ID);
                RS = Stmt.executeQuery("SELECT * FROM customer where customer_ID="+ID+";");
                System.out.println("Done!");
                RS.next();
                System.out.println(RS.getString("Password"));
                
        %>
        <div id="fullscreen_bg" class="fullscreen_bg"/>
    <form class="form-signin" action="Save_information.jsp">
   <div class="container">
       <div class="row">
           <div class="col-md-4 col-md-offset-4">
               <div class="panel panel-default">
                   <div class="panel-body">
                       <h3 class="text-center">
                           Update information</h3>
                       <form class="form form-signup" role="form" >

                       <div class="form-group">
                           <div class="input-group">
                               <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                               <input type="text" name="password" class="form-control" value="<%=RS.getString("Password")%>" />
                           </div>
                       </div>

                           <div class="form-group">
                           <div class="input-group">
                               <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span>
                               </span>
                               <input type="text" name="firstname" class="form-control" value="<%=RS.getString("FirstName")%>" />
                           </div>
                       </div>

                       <div class="form-group">
                           <div class="input-group">
                               <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                               <input type="text" name="lastname" class="form-control" value="<%=RS.getString("LastName")%>" />
                           </div>
                       </div>

                          <div class="form-group">
                           <div class="input-group">
                               <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
                               <input type="text" name="email" class="form-control" value="<%=RS.getString("Email")%>" />
                           </div>
                       </div> 


                       <div class="form-group">
                           <div class="input-group">
                               <span class="input-group-addon"><span class="glyphicon glyphicon-home"></span></span>
                               <input type="text" name="address" class="form-control" value="<%=RS.getString("Address")%>" />
                           </div>
                       </div>

                       <div class="form-group">
                           <div class="input-group">
                               <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                               <input type="text" name="age" class="form-control" value="<%=RS.getString("Age")%>" />
                           </div>
                       </div>

                       <div class="form-group">
                           <div class="input-group">
                               <span class="input-group-addon"><span class="glyphicon glyphicon-credit-card"></span></span>
                               <input type="text" name="creditcard" class="form-control" value="<%=RS.getString("CreditCard")%>" />
                           </div>
                       </div>
                   </div>
                    <%
                    } catch (Exception cnfe) {
                        System.err.println("Exception: " + cnfe);
                    } 
                    %>
                   <input type="SUBMIT" value="Save" class="btn btn-sm btn-primary btn-block" > 
               </div>
           </div>
       </div>
   </div>
   </form>


</div> 
             
    </body>
</html>
