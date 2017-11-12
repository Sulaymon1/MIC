<%--
  Created by IntelliJ IDEA.
  User: Sulaymon
  Date: 09.11.2017
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/login.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script type="text/javascript" src="jquery/bower_components/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="jquery/bower_components/jquery-validation/dist/jquery.validate.min.js"></script>
    <script type="text/javascript" src="js/login.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

</head>
<body>


<!-- Where all the magic happens -->
<!-- LOGIN FORM -->
<div class="text-center" style="padding:50px 0">
    <div class="logo">login</div>
    <!-- Main Form -->
    <div class="login-form-1">
        <form id="login-form" class="text-left" action="/login" method="post" >
            <div class="login-form-main-message"></div>
            <div class="main-login-form">
                <div class="login-group">
                    <div class="form-group">
                        <label for="lg_username" class="sr-only">Username</label>
                        <input type="text" class="form-control" id="lg_username" name="username" placeholder="username">
                    </div>
                    <div class="form-group">
                        <label for="lg_password" class="sr-only">Password</label>
                        <input type="password" class="form-control" id="lg_password" name="password" placeholder="password">
                    </div>
                    <div class="form-group login-group-checkbox">
                        <input type="checkbox" id="lg_remember" name="lg_remember">
                        <label for="lg_remember">remember</label>
                    </div>
                    <% if(request.getAttribute("errorMessage")!=null){%>
                    <div class="form-group alert alert-danger" role="alert">
                        <small id="emailHelp" class="form-text"><%= request.getAttribute("errorMessage")%>.</small>
                    </div>
                    <%}%>
                </div>
                <button type="submit" class="login-button">
                    <i class="fa fa-chevron-right">
                    </i>
                </button>
            </div>
            <div class="etc-login-form">
                <p>forgot your password? <a href="#">click here</a></p>
                <p>new user? <a href="#">create new account</a></p>
            </div>
        </form>
    </div>
    <!-- end:Main Form -->
</div>



</body>
</html>
