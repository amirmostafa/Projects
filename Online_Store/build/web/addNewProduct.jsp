<%-- 
    Document   : addNewProduct
    Created on : Aug 20, 2016, Aug 20, 2016 12:19:25 PM
    Author     : Hossam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add New Product</h1>
        <form action="addProduct">
            <strong> Name : </strong> <input type="text" name="name"/></br>
        <strong> Category : </strong> <input type="text" name="category" /></br>
        <strong> quantity : </strong> <input type="text" name="quantity" /></br>
        <strong> Unit price : </strong> <input type="text" name="price"/></br>
        <input type="submit" value="add" name="add" />
        </form>
    </body>
</html>
