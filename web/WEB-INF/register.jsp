<%-- 
    Document   : register
    Created on : 25-Oct-2020, 1:41:18 PM
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>register</title>
    </head>
   <body>
        <h1>Shopping List</h1>
        <form action = "ShoppingList" method="post">
            <input type="text" name="username" value="${username}">
            <input type="hidden" value="register" name="action">
            <input type="submit" value="Register">
        </form>
    </body>
</html>
