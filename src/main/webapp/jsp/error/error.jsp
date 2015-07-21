<%--
  Created by IntelliJ IDEA.
  User: aterehovich
  Date: 16.7.15
  Time: 6.15
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
 <h2>ERROR</h2>
 Request from ${pageContext.errorData.requestURI} is failed
 <br/>
 Servlet name or type ${pageContext.errorData.servletName}
 <br/>
 Status code: ${pageContext.errorData.statusCode}
 <br/>
 Exception: ${pageContext.errorData.throwable}
 <br/>
  <a href="../../index.jsp">to main</a>
</body>
</html>
