<%--
  Created by IntelliJ IDEA.
  User: aterehovich
  Date: 18.7.15
  Time: 22.27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${sessionScope.lang}" scope="session"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title><fmt:message key="page.registration.title"/> </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/registrationstyle.css" type="text/css"/>
</head>
<body>
  <form name="registration" action="${pageContext.request.contextPath}/control" method="post">
    <input name="command" type="hidden" value="registration">
  <table>
    <tr>
      <td>
        <label for="login"><fmt:message key="page.registration.login"/> </label>
      </td>
      <td>
          <input name="login" type="text" size="15" id="login">
      </td>
    </tr>
    <tr>
      <td>
        <label for="password"><fmt:message key="page.registration.password"/></label>
      </td>
      <td>
        <input name="password" type="password" size="15" id="password">
      </td>
    </tr>
    <tr>
      <td>
        <label for="email"><fmt:message key="page.registration.email"/></label>
      </td>
      <td>
        <input name="email" type="email" size="15" id="email">
      </td>
    </tr>
    <tr>
      <td>
        <label for="password-again"> <fmt:message key="page.registration.password_again"/></label>
      </td>
      <td>
        <input name="password_again" type="password" size="15" id="password-again">
      </td>
    </tr>
    <tr>
      <td>
        <label for="firstname"><fmt:message key="page.registration.firstname"/></label>
      </td>
      <td>
        <input name="firstname" type="text" size="15" id="firstname">
      </td>
    </tr>
    <tr>
      <td>
        <label for="lastname"><fmt:message key="page.registration.lastname"/></label>
      </td>
      <td>
        <input name="lastname" type="text" size="15" id="lastname">
      </td>
    </tr>
    <tr>
      <td>
        <label for="secondname"><fmt:message key="page.registration.secondname"/>
        </label>
      </td>
      <td>
        <input name="secondname" type="text" size="15" id="secondname">
      </td>
    </tr>
    <tr>
      <td>
        <label for="address"><fmt:message key="page.registration.address"/></label>
      </td>
      <td>
        <input name="address" type="text" size="15" id="address">
      </td>
    </tr>
    <tr>
      <td>
        <label for="city"><fmt:message key="page.registration.city"/></label>
      </td>
      <td>
        <input name="city" type="text" size="15" id="city">
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <input name="submit" type="submit" value="<fmt:message key="button.registration"/> ">
      </td>
    </tr>
  </table>
    </form>
</body>
</html>
