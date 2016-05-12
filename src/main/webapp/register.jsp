<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="WEB-INF/pages/import.jsp" %>
<head>
    <title>Register Client page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <%-- <script>function placeRegister(form) {

         form.submit();
     }</script>--%>
</head>
<body>
<%--
<%@include file="WEB-INF/mainLogoImport.jsp"%>
<link rel="stylesheet" href="stylesheet.css">--%>

<div id="tokar_container_header">
    <p class="headerRegister">
        <span id="registerClientForm">Регистрация клиента</span>
                <span><img src="images/serviceCenterLogo.jpg" class="img-thumbnail" alt="logo"
                           style="width: 85px; height: 85px;float:right"/></span>
    </p>
</div>
<br>
<br>
<br>

<div class="registerForm">

    <form class="form-horizontal" role="form" action="register" method="post">

        <div class="form-group">
            <label class="control-label col-sm-2">First Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="firstName" placeholder="Enter First Name" required>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2">Second Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="secondName" placeholder="Enter Second Name" required>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2">Phone Number:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="phoneNumber" required pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
                       placeholder="Enter Phone Number as example: 000-000-0000">
            </div>
        </div>

        <div class=" form-group">
            <label class="control-label col-sm-2">DL Number:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="driverLicenseNumber"
                       placeholder="Enter Driver License Number as example: AAA#000000" required pattern="^\w{3}#\d{6}">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2">Email:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" name="email"
                       placeholder="Enter Email as example: car@service.com" required
                       pattern="/^[\w\.-\+]+@[\w-]+(\.\w{2,4})+$/">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2">Password:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="pass"
                       placeholder="Enter password from 8 to 20 any symbols" required>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <%--<button onclick="placeRegister(this.form);">Subm</button>--%>
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>

    </form>
</div>


<%--
<div class="register form">
    <form action="register" method="post">
        FirstName : <input name="firstName" type="text"><br>
        SecondName : <input name="secondName" type="text"><br>
        PhoneNumber : <input name="phoneNumber" type="text"><br>
        Email : <input name="email" type="text"><br>
        DriverLicenseNumber : <input name="driverLicenseNumber" type="text"><br>
        Pass : <input name="pass" type="text"><br>
        <input type="submit">

    </form>
</div>--%>

</body>

</html>
