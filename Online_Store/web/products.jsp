<%-- 
    Document   : products
    Created on : Aug 20, 2016, 8:07:14 PM
    Author     : Amir
--%>

<%@page import="Util.productDB"%>
<%@page import="data.product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          productDB pdb =new productDB();
          ArrayList<product> products = pdb.getProducts();
          pdb.setProducts(products);
          request.getSession().setAttribute("products", pdb);
        %>
        <h1 style="position:absolute;left:600px">Products</h1>
        <table border="1" style="position:absolute;left:350px;top:120px">
            <thead>
                <th width="150">Product Name</th>
                <th width="150">Product Category</th>
                <th width="150">Product Price</th>
                <th width="150">Quantity</th>
            </thead>
            <tbody>
            <c:forEach items="${products.products}" var="product">    
              <tr>
                <td width="150" align="center"><a href="productPageController?id=${product.productID}" style="text-decoration: none;" class="button">${product.productName}</a></td>
                <td width="150" align="center"><c:out value="${product.category}"/></td>
                <td width="150" align="center"><c:out value="${product.price}"/></td>
                <td width="150" align="center"><c:out value="${product.quantity}"/></td>     
              </tr>
            </c:forEach>
            </tbody>
        </table>
        <form action="index.html">
            <input type="submit" value="logout" style="position:absolute;left:1250px;width:100px" name="logout" />
        </form>
    </body>
</html>
