<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/15/2022
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>House Management</h1>
    <h2>
        <a href="/houses?action=create">Add New Customer</a>
    </h2>
    <form action="/houses">
        <input type="text" name="name" placeholder="name">
        <input type="submit" value="Search">
    </form>

<%--    <div style="width: 20%; float:left">--%>
<%--    <table>--%>

<%--    </table>--%>
<%--</div>--%>

<%--    <div style="width: 80%; float:right">--%>

<%--    </div>--%>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Customer</h2></caption>
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Status</th>
            <th>Image</th>
            <th>Price</th>
        </tr>
                <c:forEach items="${houses}" var="houses" >
            <tr>
                <td>${houses.name}</td>
                <td>${houses.address}</td>
                <td>${houses.status}</td>
                <td><img width="100px" height="100px" src="${houses.image}"></td>
                <td>${houses.price}</td>
                <td>
                    <a href="/houses?action=delete&id=${houses.id}">Delete</a>
                </td>
                <td>
                    <a href="/houses?action=edit&id=${houses.id}">Edit</a>
                </td>


            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
