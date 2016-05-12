<%--
  Created by IntelliJ IDEA.
  User: tokarandrii
  Date: 29.04.16
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="import.jsp" %>
<div id="worker_container_header">
    <p class="headerLogin">
        <span id="loginClientForm">Administrator of Car  Service Station Cabinet!!!!!</span>
                <span><a href="index.html"> <img src="images/serviceCenterLogo.jpg" class="img-thumbnail" alt="logo"
                                                 style="width: 85px; height: 85px;float:right"/></a>
                   </span>
    </p>
</div>
<head>
    <title>Car Service Station Worker's Cabinet</title>
</head>
<body>
<%--<%@include file="../mainLogoImport.jsp"%>--%>

<div id="workerCabinetMenu">
    <ul>


        <li><a href="registerWorker.jsp">Add worker</a> </li>
        <li><a href="#">Update worker</a></li>
        <li><a href="#">Remove worker</a></li>
        <br>

        <li> <a href="addSFC.jsp">Add service</a></li>
        <li><a href="#">Update service</a></li>
        <li><a href="#">Remove service from Time-table</a></li>
        <li><a href="#">Confirm of service have done</a></li>
        <br>

        <li><a href="#">Add client</a></li>
        <li><a href="#">Update client data</a></li>
        <br>
        <li><a href="#">See Time-table for some period</a></li>
        <li><a href="#">See statistics for some creteria</a></li>

    </ul>

</div>

</body>
</html>
