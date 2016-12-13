<%-- 
    Document   : order
    Created on : Aug 20, 2016, 9:27:06 PM
    Author     : Amir
--%>

<%@page import="data.product"%>
<%@page import="Util.productDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function getPrice(value,price){
                document.getElementById("total").innerHTML=value*price;
                document.getElementById("price").value=value*price;
            }
            function check(qty){
                var quantity=document.getElementById("quantity").value;
                
                if (qty<quantity){
                    alert("there is onle "+qty+ " items available in the stock");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <h1 style="position:absolute;left:560px">Your Order</h1>
        <% productDB pdb=new productDB();
          int productID=Integer.parseInt(request.getParameter("id"));
          int qty=Integer.parseInt(request.getParameter("quantity"));
          product p=pdb.getProduct(productID);
        %>
        <form action="newOrder" >
            <table border="1" style="position:absolute;left:480px;top:150px">
                <input type="hidden" name="productID" value="<%=productID%>" />
                <tr>
                    <td width="150" height="50"><b>Product Name</b></td>
                    <td width="150"><%= p.getProductName()%></td>
                </tr>
                <tr>
                    <td width="150" height="25"><b>Product Category</b></td>
                    <td width="150"><%= p.getCategory()%></td>
                </tr>
                <tr>
                    <td width="150" height="25"><b>Quantity</b></td>
                    <td width="150"><input type="number" id="quantity" name="quantity" value="1" onchange="getPrice(this.value,<%= p.getPrice()%>)"/></td>
                </tr>
                <tr>
                    <td width="150" height="25"><b>Total Price</b></td>
                    <td width="150"><div id="total"><%= p.getPrice()%></div></td>
                </tr>

            </table>
                <input type="hidden" id="price" name="price" value="<%= p.getPrice()%>" />
                <input type="submit" value="Add To Cart" name="add" style="position:absolute;left:540px;top:350px" onclick="return check(<%=qty%>)"/>
        </form>
        <form action="products.jsp" style="position:absolute;left:670px;top:350px;">
                <input type="submit" value="Back" name="add"  style="width:90px"/>
        </form>
    </body>
</html>
