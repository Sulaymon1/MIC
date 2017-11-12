<%@ page import="ru.info.tech.models.InsurancePolicy" %><%--
  Created by IntelliJ IDEA.
  User: Sulaymon
  Date: 22.10.2017
  Time: 4:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your insurance</title>
</head>
<body>
<% InsurancePolicy policy = (InsurancePolicy) request.getSession().getAttribute("insurancePolicy");%>
<h4> About your policy</h4>
<ul>
    <li>passport series <%= policy.getPassport_series()%></li>
    <li>price <%= policy.getPrice()%></li>
    <li>expiration date: <%= policy.getExpiration_date()%></li>
</ul>
</body>
</html>
