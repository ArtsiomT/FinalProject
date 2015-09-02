<%@page contentType="text/html; charset = utf-8" pageEncoding="UTF-8" session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="customtags" prefix="ctd"%>

<fmt:setLocale value="${sessionScope.lang}" scope="session"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title><fmt:message key="page.main.title"/> </title>
    <link rel="stylesheet" href="css/loginstyle.css" type="text/css">
</head>
<body>
    <form name="localeForm" a n="/control" method="post">
        <input name="command" type="hidden" value="locale">
        <select name="locale" onselect="submit()">
            <option value="EN" ${lang != 'ru_RU' ? 'selected' : ''}>EN</option>
            <option value="RU" ${lang == 'ru_RU' ? 'selected' : ''}>RU</option>
        </select>
        <input name="submit" type="submit" value="<fmt:message key="button.changelocale"/> ">
    </form>
    <c:choose>
        <c:when test="${sessionScope.user==null}">
            <c:import url="jsp/patterns/login-form.jsp"/>
        </c:when>
        <c:otherwise>
            <c:import url="jsp/patterns/user-entered.jsp"/>
        </c:otherwise>
    </c:choose>

    <ctd:info-time/>
    ${update}
</body>
</html>
