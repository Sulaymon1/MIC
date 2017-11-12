<%@ page import="ru.info.tech.models.User" %><%--
  Created by IntelliJ IDEA.
  User: Sulaymon
  Date: 28.10.2017
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% User user = (User) request.getSession().getAttribute("user");%>
<html>
<head>
    <title> Dynamically create input fields- jQuery </title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>       
<script type="text/javascript">
    var i =1;
    $(function() {
        var addDiv = $('#addinput');
        i = i + 1;
        var id =0;
        $('#addNew').live('click', function() {
            $('<div id="frame' + ++id + '"> '+
                '<li>name<input type="text" id="p_new" size="40" name="name' + i +'" value=""  /></li>' +
                ' <li>surname<input type="text" id="p_new1" size="40" name="surname' + i +'" value=<%= user.getSurname()%>  disabled/></li>' +
                '<li>age<input type="text" id="p_new2" size="40" name="age' + i +'" value=""  /></li>' +
                '<li>passport series<input type="text" id="p_new3" size="40" name="passport_series' + i +'" value="" /><a href="#" id="remNew">Remove</a> </li>' +
                '<li>for<select id="date" name="expiration_year' + i+ '"> ' +
                '<option value="1">1 year</option> ' +
                '<option value="2">2 year</option> ' +
                '<option value="3">3 year</option> ' +
                '</select> ' +
                '</li></div>').appendTo(addDiv);
            i++;
            return false;
        });

        $('#remNew').live('click', function() {
            if( i > 2 ) {
                $("#frame"+ id).remove();
                --id;
                i--;
            }
            return false;
        });
    });

    </script>
    <link rel="stylesheet" type="text/css" href="css/style1.css">
</head>
<body>
<h2>Register new insurance policies</h2>
<form action="/purchasePolicies" method="post">
<div id="addinput" class="container">
    <p>
    <li>name<input type="text" id="p_new" size="20" name="name1" value="" placeholder="Input Value" /></li>
    <li>surname<input type="text" id="p_new1" size="20" name="surname1" value="<%= user.getSurname()%>" disabled/></li>
    <li>age<input type="text" id="p_new2" size="20" name="age1" value="" placeholder="Input Value" /></li>
    <li>passport series<input type="text" id="p_new3" size="20" name="passport_series1" value="" placeholder="Input Value" /></li>
    <li>for<select id="date" name="expiration_year1">
        <option value="1">1 year</option>
        <option value="2">2 year</option>
        <option value="3">3 year</option>
    </select>
    </li>
    </p>
</div>
    <a href="#" id="addNew">Add new</a>
    <input type="submit" value="submit">
</form>

</body>
</html>