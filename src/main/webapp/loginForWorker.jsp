<%--
  Created by IntelliJ IDEA.
  User: tokarandrii
  Date: 02.03.16
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход в личный кабинет</title>
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


    <style type="text/css">
        #loginInput,#passInput{
            max-width: 400px;
        }
        #containerForm{
            width: 1000px;
            padding: 5px;
        }
        #loginLabel, #passLabel{
            width:120px;
            padding: 10px;
        }

        .form-group{
            width: 1000px;
        }

        #loginClientForm{
            padding-left: 20px;

            font-weight: bold;
        }

        #tokar_container_header{
            padding: 10px;
        }


    </style>


</head>


<div id="tokar_container_header">
    <p class="headerLogin">

        <span id="loginClientForm">Вход в личный кабинет клиента</span>
                <span><a href="index.html"> <img src="images/serviceCenterLogo.jpg" class="img-thumbnail" alt="logo"
                                                 style="width: 85px; height: 85px;float:right"/></a></span>
    </p>

</div>
<br>
<br>
<br>

<div class="login form" id="containerForm">

    <form class="form-horizontal" action="loginForWorker" method="post">
        <div class="form-group">
            <label id="loginLabel" class="control-label col-sm-2">Login:</label>

            <div class="col-sm-10">
                <input id="loginInput" class="form-control" name="login" type="text" placeholder="Enter Login" required>

            </div>
        </div>


        <div class="form-group">
            <label id="passLabel" class="control-label col-sm-2">Pass:</label>

            <div class="col-sm-10">
                <input id="passInput" class="form-control" name="pass" type="password" placeholder="Enter password" required>
            </div>
        </div>

        <div id="submitButton" class="form-group">
            <div id="divSubmit" class="col-sm-offset-2 col-sm-10">
                <button id="buttonSbM" type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>

    </form>
</div>


</body>
</html>
