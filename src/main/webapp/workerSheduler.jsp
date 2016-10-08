<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sheduler</title>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="js/sorttable.js"></script>

    <script>
        function sendSFCinformation() {

            //var idSFC = $("#idSFC").val();
            var firstName;
            var objectText = {
                type: "GET",
                url: "/carServiceStation/workerSheduler",

                data: {firstName: firstName},

                success: function (result) {
                    $("#response").html(result);
                    //showForm();
                }
            };

            $.ajax(objectText);
        }

    </script>


    <style type="text/css">
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
        }

        table.sortable thead {
            background-color: #eee;
            color: #666666;
            font-weight: bold;
            cursor: default;
        }


    </style>
</head>
<body>

<header>Sheduller of</header>
<%--<c:out value="${worker.firstName}" escapeXml="false"/>--%>
<div id="response"></div>


<c:out value="${requestScope.firstName}"/>



<table id="workersSheduler" class="sortable">
    <thead>
    <tr>
        <th>№</th>
        <th>ID SFC</th>
        <th>Start date</th>
        <th>Finish date</th>
        <th>Type SFC</th>
        <th>Price SFC</th>
        <th>Client's ID</th>
        <th>Client's FirstName</th>
        <th>Client's SecondName</th>
        <th>Client's Phone number</th>
        <th>comment</th>
        <th>select <input type="checkbox" id="checkBoxTableSFCRow"></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>234</td>
        <td>01.01.2016</td>
        <td>02.01.2016</td>
        <td>repair</td>
        <td>58923</td>
        <td>12 340,56</td>
        <td>Andrii</td>
        <td>Tokar</td>
        <td>097-395-87-38</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>2</td>
        <td>560</td>
        <td>02.02.2016</td>
        <td>06.02.2016</td>
        <td>wash</td>
        <td>55679</td>
        <td>5430,00</td>
        <td>Aliona</td>
        <td>Tokar</td>
        <td>063-364-56-30</td>
        <td></td>
        <td></td>
    </tr>
    </tbody>


</table>

</body>
</html>
