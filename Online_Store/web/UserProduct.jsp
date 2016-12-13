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
        <script>
            function check(quantity){
                if (quantity==0){
                    alert("out of stock");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("productID"));
            String name = request.getParameter("productName");
            String category = request.getParameter("productCategory");
            int price = Integer.parseInt(request.getParameter("productPrice"));
            int quantity = Integer.parseInt(request.getParameter("productQuantity"));
        %>
        <h1 style="position:absolute;left:500px;top:10px">Product Information</h1>
        <form action="order.jsp" >
            <table border="1" style="position:absolute;left:480px;top:150px">
                <input type="hidden" name="id" value="<%=id%>" />
                <input type="hidden" name="quantity" value="<%=quantity%>" />
                <tr>
                    <td width="150" height="50"><b>Product ID</b></td>
                    <td width="150"><%=id%></td>
                </tr>
                <tr>
                    <td width="150" height="50"><b>Product Name</b></td>
                    <td width="150"><%= name%></td>
                </tr>
                <tr>
                    <td width="150" height="25"><b>Product Category</b></td>
                    <td width="150"><%= category%></td>
                </tr>
                <tr>
                    <td width="150" height="25"><b>Available Quantity</b></td>
                    <td width="150"><%=quantity%></td>
                </tr>
                <tr>
                    <td width="150" height="25"><b>Product Price</b></td>
                    <td width="150"><div id="total"><%= price%></div></td>
                </tr>
            </table>
                <input type="submit" value="Buy" name="Buy" style="position:absolute;left:530px;top:400px;width:100px" onclick="return check(<%=quantity%>)"/>
        </form>
        <form action="products.jsp">
               <input type="submit" value="Back" name="Back" style="position:absolute;left:640px;top:400px;width:100px"/>
        </form>
    </body>
</html>
