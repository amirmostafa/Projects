<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
    <title>Trips </title>
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
 <form class="form-signin" action="Edit trip.jsp">
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
        <div class="panel panel-default">
        <div class="panel panel-primary">
        
            <h3 class="text-center">
                        Emails</h3>
        
        <div class="panel-body">    
 
         <%
            String url = "jdbc:mysql://localhost:3306/train";
            String user = "root"; //write your username
            String password = "1234"; // write your password
            Connection Con = null;
            Statement Stmt = null;
            ResultSet RS = null;

            try {
                int c_ID = Integer.parseInt(session.getAttribute("C_ID").toString());
                Con = DriverManager.getConnection(url, user,password);
                Stmt = Con.createStatement();
                RS = Stmt.executeQuery("SELECT * FROM mail where customer_ID = "+c_ID+";");
                if(RS != null){ %>
                <table class="table table-striped table-condensed">
                  <thead>
                  <tr>
                      <th>Mail  </th>
                       
                  </tr>
              </thead>
            <tbody>
            <%    
                while (RS.next()) { 
            
            %>
                  <tr>   
                    <td><%=RS.getString("Message")%></td>
                    
               </tr>        
              
            <%
                }%>
        </tbody>
        </table>
            <%
                }else{%>
                    <%="YOU HAVE No MAILS !"%>
            <%    }
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            }
            %>
    
              
                </table>
      <a href="User home page.html" class="btn btn-sm btn-primary btn-block" role="button">Home</a> 
  </div>
       </div>
        </div>
    </div>
</div>
 </form>
          
      
    </body>
</html>
