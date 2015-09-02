<%--
  Created by IntelliJ IDEA.
  User: aterehovich
  Date: 22.7.15
  Time: 8.51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title><fmt:message key="page.cabinet.title"/> </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/modal.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style/style.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tabs/tabs.css" type="text/css">
</head>
<body>
<div class="tabs">
  <input id="tab1" type="radio" name="tabs" checked>
  <label for="tab1" title="Tab1"><fmt:message key="page.cabinet.personal-info"/> </label>

  <input id="tab2" type="radio" name="tabs">
  <label for="tab2" title="Tab2"><fmt:message key="page.cabinet.account-info"/> </label>

  <input id="tab3" type="radio" name="tabs">
  <label for="tab3" title="Tab3"><fmt:message key="page.cabinet.operations"/> </label>

  <section id="content1">
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
          <fmt:message key="page.cabinet.city"/>
        </td>
        <td>
          ${sessionScope.account.city}
        </td>
      </tr>
      <tr>
        <td>
          <fmt:message key="page.cabinet.address"/>
        </td>
        <td>
          ${sessionScope.account.address}
        </td>
      </tr>

    </table>
    <a href="#changepassword" class="openModal">Change Password</a>
    <aside id="changepassword" class="modal">
      <div>
        <form action="${pageContext.request.contextPath}/control" method="post" name="change-password" class="form-registration">
          <input name="command" type="hidden" value="changepass">
          <table>
            <tr>
              <td>Oldpass</td>
              <td><input type="password" name="oldpass" size="15" maxlength="15"> </td>
            </tr>
            <tr>
              <td>Newpass</td>
              <td><input type="password" name="newpass" size="15" maxlength="15"></td>
            </tr>
            <tr>
              <td>Newpass2</td>
              <td><input type="password" name="newpass2" size="15" maxlength="15"></td>
            </tr>
            <tr>
              <td colspan="2"><input type="submit" name="submit" value="Change"> </td>
            </tr>
          </table>
        </form>
        <a href="#close" title="Закрыть">Закрыть</a>
      </div>
    </aside>
    ${result}
  </section>
  <section id="content2">
    <c:choose>
      <c:when test="${sessionScope.account.cabinet==null}">
        <fmt:message key="page.cabinet.message.null-account"/>
      </c:when>
      <c:otherwise>

      </c:otherwise>
    </c:choose>
  </section>
  <section id="content3">
    <c:choose>
      <c:when test="${sessionScope.account.cabinet==null}">

      </c:when>
    </c:choose>
</div>
  </section>
</div>


</body>
</html>
