<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/14/2022
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit House</title>
</head>
<body>
<h1>Edit House</h1>
<p>
    <a href="/houses">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>House information</legend>
        <table>
            <tr>
                <th> Name:</th>
                <td>
                    <input type="text" name="name" id="name" value="${requestScope["house"].getName()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th> TypeId:</th>
                <td>
                    <input type="number" name="typeId" value="${house.typeId}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>DesignStyle:</th>
                <td>
                    <input name="designStyle" value="${house.designStyle}" size="15"/>
                </td>
            </tr>
            <tr>
                <th>address:</th>
                <td>
                    <input type="text" name="address" value="${house.address}" size="15"/>
                </td>
            </tr>
            <tr>
                <th>maxPeople:</th>
                <td>
                    <input type="number" name="maxPeople" value="${house.maxPeople}" size="15"/>
                </td>
            </tr>
            <tr>
                <th>basicUtility:</th>
                <td>
                    <input type="text" name="basicUtility" value="${house.basicUtility}" size="15"/>
                </td>
            </tr>
            <tr>
                <th>standardId:</th>
                <td>
                    <input type="number" name="standardId" value="${house.standardId}" size="15"/>
                </td>
            </tr>
            <tr>
                <th>status:</th>
                <td>
                    <input type="text" name="status" value="${house.status}" size="15"/>
                </td>
            </tr>
            <tr>
                <th>image:</th>
                <td>
                    <input type="text" name="image" value="${house.image}" size="15"/>
                </td>
            </tr>
            <tr>
                <th>price:</th>
                <td>
                    <input type="number" name="price" value="${house.price}" size="15"/>
                </td>
            </tr>
            <tr>
                <th>description:</th>
                <td>
                    <input name="description" value="${house.description}" size="15"/>
                </td>
            </tr>
            <tr>
                <th>extraUtility:</th>
                <td>
                    <input  name="extraUtility" value="${house.extraUtility}" size="15"/>
                </td>
            </tr>
            <tr>
                <th>evalue:</th>
                <td>
                    <input name="evalue" value="${house.evalue}" size="15"/>
                </td>
            </tr>
            <tr>
                <th>countsOfOder:</th>
                <td>
                    <input  name="countsOfOder" value="${house.countsOfOder}" size="15"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>