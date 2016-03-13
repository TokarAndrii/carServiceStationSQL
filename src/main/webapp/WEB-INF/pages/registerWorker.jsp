<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="import.jsp" %>
<head>
    <title>Register Worker page</title>
</head>
<body>
<div class="registerWorker form">
    <form action="registerWorker" method="post">
        First Name:<input form="firstName" type="text"><br>
        Second Name: <input form="secondName" type="text"><br/>
        Second Name: <input form="secondName" type="text"><br/>
        Salary:<input form="salary" type="number"><br><br>

        <form action="registerWorker">
            <select name="workerTypes">
                <option value="MASTER_OF_REPAIR_1_KATEGORY">MASTER_OF_REPAIR_1_KATEGORY</option>
                <option value="MASTER_OF_REPAIR_2_KATEGORY">MASTER_OF_REPAIR_2_KATEGORY</option>
                <option value="MASTER_OF_REPAIR_3_KATEGORY">MASTER_OF_REPAIR_3_KATEGORY</option>
                <option value="WASHER_WORKER">WASHER_WORKER</option>
                <option value="SECRETARY">SECRETARY</option>
                <option value="ADMINISTRATOR">ADMINISTRATOR</option>
            </select>
            <input type="submit">
        </form>
        Login:<input form="login" type="text"><br>
        Password:<input form="password" type="password"><br>
        <input type="submit">

    </form>
</div>

</body>
</html>
