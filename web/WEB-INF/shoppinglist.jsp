<%-- 
    Document   : shoppinglist
    Created on : 25-Oct-2020, 1:41:07 PM
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${username}
        <a href="ShoppingList?action=logout">Logout</a><br>
        <h1>List</h1>
        <form action = "" method="post">
        Add item:<input type="text" value="${item}" name="item">
        <input type="hidden" value="add" name="action">
        <input type="submit" value="add"><br>
        </form>
        
        <form action =" " method="post">
            <ul>
                <c:forEach items="${items}" var="items">
                    <li><input type="radio" name="itemsList" value="${items}"</li>${items}
                </c:forEach>
            </ul>
        <input type="hidden" value="delete" name="action">
        <input type="submit" value="Delete"><br>
        </form>
        
    </body>
</html>
