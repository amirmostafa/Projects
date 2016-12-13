<%-- 
    Document   : productPage
    Created on : Aug 20, 2016, Aug 20, 2016 12:09:41 PM
    Author     : Hossam
--%>

<%@page import="data.product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("productID"));
            String name = request.getParameter("productName");
            String category = request.getParameter("productCategory");
            int price = Integer.parseInt(request.getParameter("productPrice"));
            int quantity = Integer.parseInt(request.getParameter("productQuantity"));
        %>
        <h1>Update Product</h1>
        <form action="updateProduct">
        <strong> Name : </strong> <input type="text" name="name" value="<%=name%>"/></br>
        <strong> Category : </strong> <input type="text" name="category" value="<%=category%>"/></br>
        <strong> Available quantity : </strong> <input type="text" name="quantity" value="<%=quantity%>"/></br>
        <strong> Unit price : </strong> <input type="text" name="price" value="<%=price%>"/></br>
        <input type="hidden" name="id" value="<%=id%>">
        <input type="submit" value="Update">
        </form>
        <form action="deleteProduct">
            <input type="hidden" name="id" value="<%=id%>">
            <input type="submit" value="Delete">
        </form>
    </body>
</html>
