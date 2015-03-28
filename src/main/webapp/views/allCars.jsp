<%--
  Created by IntelliJ IDEA.
  User: maks
  Date: 25.01.2015
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<%@include file="../elements/header.jsp"%>
<body>

<%@include file="../elements/maib_menu.jsp"%>

<h1>Try ty see all cars!!</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th>#</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>Mark</td>
        <td>Otto</td>
        <td>@mdo</td>
    </tr>
    <tr>
        <td>2</td>
        <td>Jacob</td>
        <td>Thornton</td>
        <td>@fat</td>
    </tr>
    <tr>
        <td>3</td>
        <td>Larry</td>
        <td>the Bird</td>
        <td>@twitter</td>
    </tr>
    </tbody>



</table>
<c:forEach items="${cars}" var = "carentCar">
    <c:out value="${carentCar.name}"/><br/>
</c:forEach>
<br/>
<a href="views/login.jsp">Login</a>
</body>
</html>
