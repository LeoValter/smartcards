<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <h1>Users</h1>

    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Login</th>
            <th>Password</th>
            <th>Email</th>
        </tr>
        </thead>
        <c:forEach items="${users}" var="user">
        <jsp:useBean id="users" scope="page"
                     class="ru.leovalter.smartcards.model.User" type="ru.leovalter.smartcards.model.User"/>
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
