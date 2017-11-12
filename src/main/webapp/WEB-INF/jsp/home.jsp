<%@ page import="ru.info.tech.models.User" %>
<%@ page import="ru.info.tech.models.InsurancePolicy" %><%--
  Created by IntelliJ IDEA.
  User: Sulaymon
  Date: 20.10.2017
  Time: 6:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Home</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/style_home.css">
</head>
<body>
<% User user = (User) request.getSession().getAttribute("user");%>
<% InsurancePolicy insurancePolicy = (InsurancePolicy) request.getSession().getAttribute("insurancePolicy");%>
<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner iner-carousel">
        <div class="carousel-item active">
            <img class="d-block w-100" src="image/img_home/bentleyfamilypano.jpg" alt="First slide">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="image/img_home/family-vonderlin.jpg" alt="Second slide">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<div class="ready-insurance_tariff-wrapper">
    <div class="container">
        <div class="row">
            <div class="col-sm info-container" >
                <img src="image/img_home/person_transparent.png" alt="" class="img-fluid" style="margin: auto 25% auto 25%; width: 50%;">
                <div>
                    Buy Individual Health Insurance
                </div>
                <div>
                    <h2>250p.</h2>
                </div>
                <div>
                    <%if (insurancePolicy != null){%>
                    <a type="submit" class="btn btn-primary btn-container" href="/viewPolicy">show now</a>
                    <%} else {%>
                    <a type="submit" class="btn btn-primary btn-container" href="/registerInsurance">Buy now</a>
                    <%}%>
                </div>
            </div>
            <div class="col-sm info-container" >
                <img src="image/img_home/famil_pic.png" alt="" class="img-fluid" style="margin: auto 25% auto 25%; width: 50%;">

                <div>
                    Buy Family Health Insurance Plans
                </div>
                <div>
                    <h2>200p. x2min</h2>
                </div>
                <div>
                    <a type="submit" class="btn btn-primary btn-container" href="#">Buy now</a>
                </div>
            </div>
            <div class="col-sm info-container" >
                <img src="image/img_home/company.png" alt="" class="img-fluid" style="margin: auto 25% auto 25%; width: 50%;">

                <div>
                    Group Health Insurance
                </div>
                <div>
                    <h2>0p.</h2>
                </div>
                <div>
                    <a type="submit" class="btn btn-primary btn-container" href="#">Buy</a>
                </div>
            </div>
        </div>
    </div>
</div>



<div class="card-footer bg-transparent border-success">
    <img src="image/img_home/logo_transparent.png" width="30" height="30" class="d-inline-block align-top" alt="">
    <span id="MIC">Medical Insurance Corporation</span>
</div>

</body>
</html>
