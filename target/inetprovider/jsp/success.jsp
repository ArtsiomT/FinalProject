<%--
  Created by IntelliJ IDEA.
  User: aterehovich
  Date: 16.7.15
  Time: 6.15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Login success</title>
</head>
<body>
  <table border="2">
    <tr>
      <td>${user.id}</td>
      <td>${user.login}</td>
      <td>${user.firstname}</td>
      <td>${user.lastname}</td>
      <td>${user.address}</td>
      <td>${user.city}</td>
    </tr>
  </table>
<a href="../index.jsp">to main</a>
</body>
</html>
