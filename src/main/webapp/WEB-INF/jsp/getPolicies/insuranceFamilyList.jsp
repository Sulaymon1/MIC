<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sulaymon
  Date: 30.10.2017
  Time: 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your family insurance</title>
</head>
<body>
<div>
    <c:forEach items="${users}" var="user">
    ${user.name}
    </c:forEach>
</div>
</body>
</html>
