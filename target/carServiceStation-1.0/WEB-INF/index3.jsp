
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Menu of Client</title>

    <style type="text/css">
        #container {
            height: 450px;
            width: 650px;
            margin: 20px auto;
            position: relative;
        }

        #img {
            height: 450px;
            width: 650px;
            position: absolute;
        }

        #leftHolder {
            height: 450px;
            width: 100px;
            top: 0px;
            position: absolute;
            left: 0px;
        }

        #rightHolder {
            height: 450px;
            width: 100px;
            top: 0px;
            position: absolute;
            right: 0px;
        }

        .left {
            height: 50px;
            width: 50px;
            position: absolute;
            top: 40%;
            left: 0px;

        }

        .right {
            height: 50px;
            width: 50px;
            position: absolute;
            top: 40%;
            right: 0px;
        }


    </style>
    <script type="text/javascript">
        var imgcount = 1;
        var total = 6;

        function slide(x) {
            var Image = document.getElementById('img');
            imgcount = imgcount + x;
            if (imgcount > total) {
                imgcount = 1;
            }
            if (imgcount < 1) {
                imgcount = total;
            }
            Image.src = "../imgages/img" + imgcount + ".jpg";
        }
        window.setInterval(function slideAuto(){
            var Image = document.getElementById('img');
            imgcount = imgcount + 1;

            if (imgcount > total) {
                imgcount = 1;
            }
            if (imgcount < 1) {
                imgcount = total;
            }
            Image.src = "../images/img" + imgcount + ".jpg";
        },3000);
    </script>


</head>
<body>

<div class="head menu">
    <ul>
        <li><a href="/${APP_NAME}/login.html">Sign-In</a></li>
        <li><a href="/${APP_NAME}/register.jsp">Sign_Up</a> </li>
    </ul>
</div>

<body onload="slideAuto()">

<div id="container">
    <img src="../images/img1.jpg" id="img">
    <div id="leftHolder"><img onclick="slide(-1)" class="left" src="../images/leftArrow.png"></div>
    <div id="rightHolder"><img onclick="slide(+1)" class="right" src="../imgage/rightArrow.png"></div>
</div>

</body>
</html>
