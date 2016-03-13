<%--
  Created by IntelliJ IDEA.
  User: tokarandrii
  Date: 01.03.16
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Worker page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>


<div id="tokar_container_header">
    <p class="headerRegister">
        <span id="registerClientForm">Регистрация сотрудника</span>
                <span><img src="images/serviceCenterLogo.jpg" class="img-thumbnail" alt="logo"
                           style="width: 85px; height: 85px;float:right"/></span>
    </p>
</div>
<br>
<br>

<div class="registerForm">

    <form class="form-horizontal" role="form" action="register" method="post">

        <div class="form-group">
            <label class="control-label col-sm-2">First Name:</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" name="firstName" placeholder="Enter First Name">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2">Second Name:</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" name="secondName" placeholder="Enter Second Name">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2">Salary</label>

                <div class="col-sm-10">
                    <input type="number" class="form-control" name="salary" min="1000" max="50000">
                </div>

        </div>

        <div class="form-group">
            <form role="form">
                <label class="control-label col-sm-2">Type of Worker</label>

                <div class="col-sm-10">
                    <div class="radio">
                        <label><input type="radio" name="WorkerTypes" value="MASTER_OF_REPAIR_1_KATEGORY">MASTER_OF_REPAIR_1_KATEGORY</label>
                    </div>
                    <div class="radio">
                        <label><input type="radio" name="WorkerTypes"  value="MASTER_OF_REPAIR_2_KATEGORY">MASTER_OF_REPAIR_2_KATEGORY</label>
                    </div>
                    <div class="radio">
                        <label><input type="radio" name="WorkerTypes"  value="MASTER_OF_REPAIR_3_KATEGORY">MASTER_OF_REPAIR_3_KATEGORY</label>
                    </div>
                    <div class="radio">
                        <label><input type="radio" name="WorkerTypes" value="WASHER_WORKER">WASHER_WORKER</label>
                    </div>
                    <div class="radio">
                        <label><input type="radio" name="WorkerTypes" value="SECRETARY">SECRETARY</label>
                    </div>
                    <div class="radio">
                        <label><input type="radio" name="WorkerTypes" value="ADMINISTRATOR">ADMINISTRATOR</label>
                    </div>
                </div>
            </form>


        </div>

        <div class="form-group">
            <label class="control-label col-sm-2">Login:</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" name="login" placeholder="Enter login">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2">Password:</label>

            <div class="col-sm-10">
                <input type="password" class="form-control" name="pass" placeholder="Enter password">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>

    </form>
</div>


</body>
</html>
