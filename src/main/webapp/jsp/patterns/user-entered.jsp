<%--
  Created by IntelliJ IDEA.
  User: aterehovich
  Date: 18.7.15
  Time: 22.15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setBundle basename="localization"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user-entered.css" type="text/css">
<form name="logout" action="/control" method="post">
  <table>
    <input name="command" type="hidden" value="logout">
    <tr>
      <td>

          <fmt:message key="label.antered_as"/> <p class="user">${sessionScope.user}</p>

      </td>
    </tr>
    <tr>
      <td>
        <input name="submit" type="submit" value="<fmt:message key="button.logout"/> ">
      </td>
    </tr>
  </table>
</form>
