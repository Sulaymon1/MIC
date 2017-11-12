<%--
  Created by IntelliJ IDEA.
  User: Sulaymon
  Date: 15.10.2017
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<ul>
    <li>
    Thank you for registration, <%= request.getParameter("name")%>
    </li>
    <li>
        Confirm with e-mail <%=request.getParameter("email")%>
    </li>
</ul>
</body>
</html>
