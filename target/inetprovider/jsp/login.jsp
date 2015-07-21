<%--
  Created by IntelliJ IDEA.
  User: aterehovich
  Date: 18.7.15
  Time: 17.07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${pageContext.request.locale}" scope="session"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title><fmt:message key="page.login.title"/> </title>
</head>
<body>
  <c:import url="patterns/login-form.jsp"/>
  <p class="error">
  <br/>
  ${errorLoginPassMessage}
  <br/>
  ${wrongAction}
  <br/>
  ${nullPage}
  <br/>
  </p>

</body>
</html>
