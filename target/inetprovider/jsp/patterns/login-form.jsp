<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setBundle basename="localization"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginstyle.css" type="text/css">
<form name="login" action="${pageContext.request.contextPath}/control" method="post">
  <input name="command" type="hidden" value="login">
  <table>
    <tr>
      <td>
        <fmt:message key="label.login"/>
      </td>
      <td>
        <input name="login" type="text" size="15" value="${login}" >
      </td>
    </tr>
    <tr>
      <td>
        <fmt:message key="label.password"/>
      </td>
      <td>
        <input name="password" type="password" size="15">
      </td>
    </tr>
    <tr>
      <td>
        <input name="submit" type="submit" value=<fmt:message key="button.login"/>>
      </td>
      <td>
        <a href="${pageContext.request.contextPath}/jsp/authenticate/registration.jsp"><fmt:message key="page.registration.title"/> </a>
      </td>
    </tr>
  </table>
  <br>

</form>
