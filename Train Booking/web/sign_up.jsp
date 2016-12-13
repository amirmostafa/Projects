<%-- 
    Document   : CheckUser
    Created on : Dec 26, 2015, Dec 26, 2015 1:54:02 PM
    Author     : Amir
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
        <%
            
            String url = "jdbc:mysql://localhost:3306/train";
            String user = "root"; //write your username
            String password = "1234"; // write your password
            String Line;
            String username= request.getParameter("username");
            String Password= request.getParameter("password");
            String type= request.getParameter("type");
            Connection Con = null , Con2= null;
            Statement Stmt = null, Stmt2= null;;
            Statement st = null,st2 = null;
            ResultSet RS = null, RS2= null;;
            out.println(type);
            out.println(username);
            try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                RS = Stmt.executeQuery("SELECT * FROM admin where UserName='"+username+"'");
                
                if (RS.next()){
                    response.sendRedirect("Sign up.html");
                }else{
                    
                    Con2 = DriverManager.getConnection(url, user, password);
                    Stmt2 = Con2.createStatement();
                    RS2 = Stmt2.executeQuery("SELECT * FROM customer where UserName='"+username+"'");
                    if (RS2.next()){
                        
                    response.sendRedirect("Sign up.html");
                    }
                }
                
                if (type.equals("admin")){
                    
                    Con = DriverManager.getConnection(url, user, password);
                    st = Con.createStatement();
                    st.executeUpdate(" Insert into admin Values ('"+username+"','"+Password+"',"+0+");");
               
                    //st.executeUpdate("Insert into registered Values ('"+SSN+"','"+crs[i]+"' , 'Fall' ,'2015');");
                }else{
                    String age= request.getParameter("age");
                    String address= request.getParameter("address");
                    String creditcard= request.getParameter("creditcard");
                    String firstname= request.getParameter("firstname");
                    String lastname= request.getParameter("lastname");
                    String email= request.getParameter("email");
                    Con2 = DriverManager.getConnection(url, user, password);
                    st2 = Con2.createStatement();
                    st2.executeUpdate("Insert into customer Values ('"+Password+"','"+username+"',"+age+",'"+address+"',"+0+","+creditcard+",'"+firstname+"','"+lastname+"','"+email+"');");
                   
                }
                response.sendRedirect("index.html");
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            } 
        %>
    </body>
</html>
