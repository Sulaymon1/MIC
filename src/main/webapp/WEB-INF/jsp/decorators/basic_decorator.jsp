<%@ page import="ru.info.tech.models.User" %><%--
  Created by IntelliJ IDEA.
  User: Sulaymon
  Date: 04.11.2017
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><sitemesh:write property='title'/></title>
    <sitemesh:write property='head'/>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css" >
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-migrate-3.0.1.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<% User user = (User) request.getSession().getAttribute("user"); %>
<nav class="navbar navbar-expand-lg navbar-light bg-light ">
    <a class="navbar-brand" href="#">
        <img src="image/img_home/logo_transparent.png" width="30" height="30" class="d-inline-block align-top" alt="">
        <span>MIC</span>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Features</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Pricing</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
            </li>
            <li><div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropdown button
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </div></li>
        </ul>
        <% if (user == null){ %>
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" id="modaltrigger" onclick="location.href='/login'">Sing in</button>
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" id="btn_signup" onclick="location.href='/register'">Sign up</button>
        <% }else{ %>
        <a href="/userAccount" id="signed_in">Welcome, <%= user.getName()%></a>
        <button class="btn btn-outline-success my-2 my-sm-0 " type="submit" id="" onclick="location.href='/logout'">Log out</button>
        <% }%>
    </div>
</nav>
<div class='mainBody'>
    <sitemesh:write property='body'/>
</div>


</body>
</html>
