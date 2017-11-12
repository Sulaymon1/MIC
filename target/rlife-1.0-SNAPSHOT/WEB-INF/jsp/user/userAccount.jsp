<%@ page import="ru.info.tech.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Account info</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href='http://fonts.googleapis.com/css?family=Merienda+One' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/style_account.css">
    <link rel="stylesheet" href="css/navbar.css">
    <link rel="stylesheet" href="css/style_login.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-migrate-3.0.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="css/style_view_card.css">
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<% User user = (User) request.getSession().getAttribute("user"); %>

<%--Modal card--%>

<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Your card</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-6">
                            <div id="card-front">
                                <label class="card-title">Medical Insurance Corporation</label>
                                <hr>
                                <label class="info-client">Insurant:</label><span> <%= user.getName()%> <%= user.getSurname()%></span>
                                <label class="info-client">Date of birth:</label><span>  <%= user.getAge()%></span>
                                <label class="info-client">Term insurance: from </label>
                                <span>  xx:xx:xxxx</span>
                                <span id="date_until"> until xx:xx:xxxx</span>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div id="card-back">
                                <img src="image/view_card/logo_transparent.png" id="image_logo" alt="" >
                                <label id="logo-name">MIC</label>
                                <label id="info-card">Tel. 89674645004</label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<%--End of modal card--%>

<div class="block-container">
    <div></div>
    <div class="jumbotron jumbotron-fluid jumbotron-custom">
        <div class="container">
            <h2 class="settings-label">Настройки аккаунта</h2>
            <form>
                <div class="form-group">
                    <label for="">Адрес эл. почты</label>
                    <input type="email" class="form-control"  value="<%= user.getEmail()%>" disabled>
                </div>
                <div class="form-group">
                    <label for="">Адрес</label>
                    <input type="text" class="form-control"  value=" <%= user.getAddress()%>">
                </div>
                <div class="form-group">
                    <label for="">Телефон</label>
                    <input type="text" class="form-control"  value=" <%= user.getTel()%>">
                </div>
                <div class="form-group">
                    <div class="form-check form-check-inline">
                        <label for="">Пол</label>
                        <label class="form-check-label">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> Мужчина
                        </label>
                    </div>
                    <div class="form-check form-check-inline">
                        <label class="form-check-label">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> Женщина
                        </label>
                    </div>
                </div>
                <h2 class="settings-label">Профиль</h2>
                <div class="form-group row">
                    <div class="form-group col-md-4">
                        <label for="">Имя</label>
                        <input type="text" class="form-control" id="name" name="name" value=" <%= user.getName()%>" disabled>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="">Фамилия</label>
                        <input type="text" class="form-control" id="surname" name="surname" value=" <%= user.getSurname()%>" disabled>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="">Отчество</label>
                        <input type="text" class="form-control" id="lastname" name="lastname" value=" <%= user.getLastname()%>"disabled>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="" class="col-sm-2 col-form-label">Возраст</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="age" name="lastname" value=" <%= user.getAge()%>"disabled>
                    </div>
                    </div>
                <div class="form-group">
                    <label for="">Имя пользователя</label>
                    <input type="text" class="form-control"  value="<%= user.getUsername()%>"disabled>
                </div>
                <h2 class="settings-label">Безопасность</h2>
                <div class="form-group">
                    <label for="">Старый пароль</label>
                    <input type="password" class="form-control"  placeholder="Пароль">
                </div>
                <div class="form-group">
                    <label for="">Новый пароль</label>
                    <input type="password" class="form-control" id="" placeholder="Новый пароль">
                </div>
                <button type="button" class="btn btn-primary" id="btn_save">Update</button>
        </form>
    </div>
</div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

</body>
</html>