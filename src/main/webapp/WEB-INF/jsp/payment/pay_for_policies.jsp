<%--
  Created by IntelliJ IDEA.
  User: Sulaymon
  Date: 30.10.2017
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payment </title>
    <link rel="stylesheet" href="css/style_payment.css">
</head>
<body>
<div id="header">

</div>
<div class="container">
    <div id="content">
        <h1>Pay Invoice</h1>
        <div class="card-row">
            <span class="visa"></span>
            <span class="mastercard"></span>
            <span class="amex"></span>
            <span class="discover"></span>
        </div>
        <form action="">
            <div class="form-group">
                <label>Payment amount</label>
                <div class="amount-placeholder"></div>
                <span>$</span>
                <span>500</span>
            </div>
            <div class="form-group">
                <label >Name on card</label>
                <input type="text" id="NameOnCard" class="form-control">
            </div>
            <div class="form-group">
                <label >Card number</label>
                <input type="text" class="null car-image form-control">
            </div>
            <div class="expiry-date-group form-group" >
                <label >Expiry date</label>
                <input type="text" class="form-control" placeholder="MM / YY">
            </div>
            <div class="security-code-group form-group">
                <label >Security code</label>
                <div class="input-container">
                    <input type="text" class="form-control">
                    <i class="fa fa-question-circle"></i>
                </div>
            </div>
            <div class="form-group" >
                <label >ZIP/Postal code</label>
                <input type="text" class="form-control" placeholder="">
            </div>
            <button class="btn btn-block btn-success submit-button" id="PayButton" type="submit">
                <span class="submit-button-lock"></span>
                <span class="align-middle"> Pay $500</span>
            </button>
        </form>
    </div>
</div>
<div id="footer">

</div>
</body>
</html>
