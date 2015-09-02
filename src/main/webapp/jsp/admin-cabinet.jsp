<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 10.08.2015
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="customtags" prefix="ctd"%>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
  <title><fmt:message key="page.admin-cabinet.title"/> </title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tabs/tabs.css" type="text/css">
</head>
<body>

<div class="tabs">
  <input id="tab1" type="radio" name="tabs" checked>
  <label for="tab1" title="Вкладка 1"><fmt:message key="page.cabinet.personal-info"/> </label>

  <input id="tab2" type="radio" name="tabs">
  <label for="tab2" title="Вкладка 2"><fmt:message key="page.admin-cabinet.users"/> </label>

  <input id="tab3" type="radio" name="tabs">
  <label for="tab3" title="Вкладка 3"><fmt:message key="page.admin-cabinet.apps"/> </label>



  <section id="content1">
    <p>
    <table>
      <tr>
        <td>
          <fmt:message key="page.cabinet.firstname"/>
        </td>
        <td>
          ${sessionScope.account.firstname}
        </td>
      </tr>
      <tr>
        <td>
          <fmt:message key="page.cabinet.lastname"/>
        </td>
        <td>
          ${sessionScope.account.lastname}
        </td>
      </tr>
      <tr>
        <td>
          <fmt:message key="page.cabinet.secondname"/>
        </td>
        <td>
          ${sessionScope.account.secondname}
        </td>
      </tr>

    </table>

    </p>
  </section>
  <section id="content2">
    <p>
    <table border="1">
      <tr>
        <td>ID</td>
        <td><fmt:message key="page.registration.login"/> </td>
        <td><fmt:message key="page.admin-cabinet.full-name"/> </td>
        <td><fmt:message key="page.admin-cabinet.role"/> </td>
        <td><fmt:message key="page.cabinet.city"/> </td>
      </tr>
      <ctd:user-table/>
    </table>
    </p>
  </section>
  <section id="content3">
    <p>
      Здесь размещаете любое содержание....
    </p>
  </section>
  <section id="content4">
    <p>
      Здесь размещаете любое содержание....
    </p>
  </section>
</div>

</body>
</html>
