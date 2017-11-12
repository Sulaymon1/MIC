<%--
  Created by IntelliJ IDEA.
  User: Sulaymon
  Date: 08.11.2017
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new account</title>
    <link rel="stylesheet" href="css/style_userRegister.css">
    <script type="text/javascript" src="jquery/bower_components/jquery-validation/dist/jquery.validate.min.js"></script>
</head>
<body>
<script type="text/javascript" src="js/regValidation.js"></script>
<div class="clearfix">
    <h1>Create your new account</h1>
    <%-- todo add new picture --%>
    <div id="left-content">
        <div class="img-content">
            <div class="flip-container" ontouchstart="this.classList.toggle('hover');">
                <h2>Take it all with you</h2>
                <div class="flipper">
                    <div class="front">
                        <img src="image/img_register/card2.jpg" class="img-fluid" alt="">
                        <!-- front content -->
                    </div>
                    <div class="back">
                        <img src="image/img_register/card1.jpg" class="img-fluid" alt="">

                        <!-- back content -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="right-content">
        <form method="POST" name="registerForm" action="<c:url value="/register"/>"  role="form" id="js_register_form">
            <div class="form-content">
                <div class="form-group">
                    <label >Name</label>
                    <input class="form-control form-control-sm" type="text" name="name" placeholder="Name">
                </div>
                <div class="form-group">
                    <label >Surname</label>
                    <input class="form-control form-control-sm" type="text" name="surname" placeholder="Surname">
                </div>
                <div class="form-group">
                    <label >Lastname</label>
                    <input class="form-control form-control-sm" type="text" name="lastname" placeholder="Lastname">
                </div>
                <div class="form-group">
                    <label >Email</label>
                    <input class="form-control form-control-sm" type="text" name="email" placeholder="Email">
                </div>
                <div class="form-group">
                    <label >Address</label>
                    <input class="form-control form-control-sm" type="text" name="address" placeholder="Address">
                </div>
                <label >Birthday</label>
                <div class="form-group form-row">
                    <div class="col">
                        <select class="custom-select mb-2 mr-sm-2 mb-sm-0 form-control-sm" name="month" id="inlineFormCustomSelect">
                            <option value="01" selected>January</option>
                            <option value="02">February</option>
                            <option value="03">March</option>
                            <option value="04">April</option>
                            <option value="05">May</option>
                            <option value="06">June</option>
                            <option value="07">July</option>
                            <option value="08">August</option>
                            <option value="09">September</option>
                            <option value="10">October</option>
                            <option value="11">November</option>
                            <option value="12">December</option>
                        </select>
                    </div>
                    <div class="col">
                        <input type="number" class="form-control form-control-sm" name="day" placeholder="day">
                    </div>
                    <div class="col">
                        <input type="number" class="form-control form-control-sm" name="year" placeholder="year">
                    </div>

                </div>
                <div class="form-group">
                    <label >Phone number</label>
                    <input type="text" class="form-control form-control-sm" name="telefon" placeholder="Phone number">
                </div>
                <div class="form-group">
                    <label >Username</label>
                    <input class="form-control form-control-sm" type="text" name="username" placeholder="Username">
                </div>
                <div class="form-group">
                    <label >Password</label>
                    <input class="form-control form-control-sm" type="password" name="password" placeholder="Password">
                </div>
                <div class="form-group">
                    <div id="btn_submit">
                        <input class="btn btn-primary" type="submit" value="Go to confirm" name="submit_btn">
                    </div>
                </div>
            </div>

        </form>
    </div>
</div>


</body>
</html>
