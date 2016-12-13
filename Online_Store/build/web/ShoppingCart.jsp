<%-- 
    Document   : ShoppingCart
    Created on : Aug 20, 2016, 9:54:19 PM
    Author     : Amir
--%>

<%@page import="Util.productDB"%>
<%@page import="data.product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.order"%>
<%@page import="Util.orderDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="position:absolute;left:580px">Shopping Cart </h1>
        <%
          orderDB odb=new orderDB();
          session =request.getSession(true);
          int userID=Integer.parseInt(session.getAttribute("userID").toString());
          ArrayList<order>orders=odb.getOrders(userID);

        %>
        <form action="Checkout">
            <table border="1" style="position:relative;left:200px;top:120px">
                <thead>
                    <th width="150">Date</th>
                    <th width="150">Product Name</th>
                    <th width="150">Quantity</th>
                    <th width="150">Total Price</th>
                    <th width="150">Delete</th>
                    <th width="150"></th>
                </thead>
                <tbody>
                  <% for (int i=0;i<orders.size();i++){ 
                        productDB pdb=new productDB();
                        product p=pdb.getProduct(orders.get(i).getProductID());
                        String ProductName=p.getProductName();
                  %>
                  <tr>
                    <td width="150" align="center"><%= orders.get(i).getDate() %></td>
                    <td width="150" align="center"><%= ProductName%></td>
                    <td width="150" align="center"><%= orders.get(i).getQuantity()%></td>
                    <td width="150" align="center"><%= orders.get(i).getPrice()%></td>
                    <td width="150" align="center"><a href="DeleteOrder?id=<%= orders.get(i).getOrderID() %>" style="text-decoration: none;">Delete</a></td>
                    <td width="150" align="center"><input type="checkbox" name="order" value="<%= orders.get(i).getOrderID() %>" /></td>     
                  </tr>
                  <%}%>
                </tbody>
            </table>
                <input type="submit" style="position:relative;left:580px;margin-top:150px" value="Checkout" name="Checkout" />
        </form>
        <form action="products.jsp">
                <input type="submit" style="position:relative;left:700px;top:-21px" value="Back To Products" name="Products" />
        </form>
    </body>
</html>
