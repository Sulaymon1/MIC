<%@ page import="ru.info.tech.models.User" %><%--
  Created by IntelliJ IDEA.
  User: Sulaymon
  Date: 21.10.2017
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register new insurance</title>

    <link rel="stylesheet" href="css/style_registerIns.css">
    <script type="text/javascript" src="jquery/bower_components/jquery-validation/dist/jquery.validate.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-migrate-3.0.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <script src="js/login.js"></script>
</head>
<body>

<% User user = (User) request.getSession().getAttribute("user"); %>

<div class="clearfix">
    <h1>Create your new insurance policy</h1>
    <div id="left-content">
        <div class="img-content">
            <div class="flip-container" ontouchstart="this.classList.toggle('hover');">
                <h2>Take it all with you</h2>
                <div class="flipper">
                    <div class="front">
                        <img src="image/img_register/card1.jpg" class="img-fluid" alt="">
                        <!-- front content -->
                    </div>
                    <div class="back">
                        <img src="image/img_register/card2.jpg" class="img-fluid" alt="">
                        <!-- back content -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="right-content">
        <form action="/registerInsurance" method="post" id="register_form">
        <div class="form-content">
                <div class="form-group">
                    <label >Name</label>
                    <input class="form-control form-control-sm" type="text" value="<%= user.getName()%>" disabled>
                </div>
                <div class="form-group">
                    <label for="">Surname</label>
                    <input class="form-control form-control-sm" type="text" value="<%= user.getSurname()%>"  disabled>
                </div>
                <div class="form-group">
                    <label for="">Email</label>
                    <input class="form-control form-control-sm" type="text" value="<%= user.getEmail()%>"  disabled>
                </div>
                <div class="form-group">
                    <label for="">Phone number</label>
                    <input type="text" class="form-control form-control-sm" value="<%= user.getTel()%>"  disabled>
                </div>
                <div class="form-group">
                    <label for="">Passport series</label>
                    <input class="form-control form-control-sm" type="text" name="passport_series" placeholder="Passport series">
                </div>
                <div class="form-group form-row">
                    <div class="col">
                        <label for="">Insurance policy for</label>
                    </div>
                    <div class="col">
                        <select class="custom-select mb-2 mr-sm-2 mb-sm-0 form-control-sm" name="expiration_year" id="">
                          <option selected value="1">1 year</option>
                          <option value="2">2 year</option>
                          <option value="3">3 years</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div id="btn_submit">
                        <button type="submit" class="btn btn-primary" href="">Next step</button>
                    </div>
                </div>
                </div>
            </form>
        </div>
        </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>