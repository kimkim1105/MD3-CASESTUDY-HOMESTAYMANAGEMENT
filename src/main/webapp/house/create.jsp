<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/15/2022
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="houses?action=houses">List All Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New House</h2>
            </caption>
            <%--            <tr>--%>
            <%--                <th>Customer ID:</th>--%>
            <%--                <td>--%>
            <%--                    <input type="text" name="id" id="id" size="45"/>--%>
            <%--                </td>--%>
            <%--            </tr>--%>
            <tr>
            <tr>
                <th> Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th> TypeId:</th>
                <td>
                    <input type="number" name="typeId" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>DesignStyle:</th>
                <td>
                    <input name="designStyle" id="address" size="15"/>
                </td>
            </tr>
            <tr>
                <th>address:</th>
                <td>
                    <input type="text" name="address"  size="15"/>
                </td>
            </tr>
            <tr>
                <th>maxPeople:</th>
                <td>
                    <input type="number" name="maxPeople"  size="15"/>
                </td>
            </tr>
            <tr>
                <th>basicUtility:</th>
                <td>
                    <input type="text" name="basicUtility"  size="15"/>
                </td>
            </tr>
            <tr>
                <th>standardId:</th>
                <td>
                    <input type="number" name="standardId" id="standardId" size="15"/>
                </td>
            </tr>
            <tr>
                <th>status:</th>
                <td>
                    <input type="text" name="status"  size="15"/>
                </td>
            </tr>
            <tr>
                <th>image:</th>
                <td>
                    <input type="text" name="image" id="image" size="15"/>
                </td>
            </tr>
            <tr>
                <th>price:</th>
                <td>
                    <input type="number" name="price" id="price" size="15"/>
                </td>
            </tr>
            <tr>
                <th>description:</th>
                <td>
                    <input name="description" id="description" size="15"/>
                </td>
            </tr>
            <tr>
                <th>extraUtility:</th>
                <td>
                    <input  name="extraUtility" id="extraUtility" size="15"/>
                </td>
            </tr>
            <tr>
                <th>evalue:</th>
                <td>
                    <input name="evalue" id="evalue" size="15"/>
                </td>
            </tr>
            <tr>
                <th>countsOfOder:</th>
                <td>
                    <input  name="countsOfOder" id="countsOfOder" size="15"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>