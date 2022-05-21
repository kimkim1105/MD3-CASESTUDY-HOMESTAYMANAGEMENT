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
    <form action="/houses?action=sort" method="post">
        <select name="select" onchange="this.form.submit()">
            <option value="">Search By Price</option>
            <option value="one">Under 1000$</option>
            <option value="two">1000$ - 2000$</option>
            <option value="three"> Over 2000$</option>
        </select>
    </form>
<div>
    <div style="width: 50%; float:left">
    <h2>Standard</h2>
<c:forEach items="${standards}" var="standards" >
        <a href="/standards?id=${standards.id}">${standards.name} </a><br>
</c:forEach>
        <a>a</a>
</div>

    <div style="width: 50%; float:right">
        <h2>Type</h2>
        <c:forEach items="${types}" var="types" >
            <a href="/types?id=${types.id}">${types.name} </a><br>
        </c:forEach>
    </div>
</div>
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
            <th>Type</th>
            <th>Standard</th>
        </tr>
<%--                <c:forEach items="${houses}" var="houses" >--%>
                    <c:forEach var="i" begin="0" end="${houses.size()-1}" >
            <tr>
                <td>${houses.get(i).name}</td>
                <td>${houses.get(i).address}</td>
                <td>${houses.get(i).status}</td>
                <td><img width="100px" height="100px" src="${houses.get(i).image}"></td>
                <td>${houses.get(i).price}</td>
                <td>${types1.get(i).name}</td>
                <td>${standard1.get(i).name}</td>
                <td>
                    <a href="/houses?action=delete&id=${houses.get(i).id}">Delete</a>
                </td>
                <td>
                    <a href="/houses?action=edit&id=${houses.get(i).id}">Edit</a>
                </td>


            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
