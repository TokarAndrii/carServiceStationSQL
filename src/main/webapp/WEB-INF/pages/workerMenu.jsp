<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="dateTimePeacker/js/bootstrap-datetimepicker.js"></script>
    <script src="js/sorttable.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="dateTimePeacker/css/bootstrap-datetimepicker.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <script src="dateTimePeacker/js/jquery-ui.js"></script>
    <script>
        function showTable() {
            document.getElementById("workSpaceHolder").style.display = "block";

        }

        function hideTable() {
            document.getElementById("workSpaceHolder").style.display = "none";
        }
        ;

        function showFormAdd() {
            document.getElementById("workSpaceHolder2").style.display = "block";

        }

        function hideFormAdd() {
            document.getElementById("workSpaceHolder2").style.display = "none";

        }

        $(function () {
            $(".form_datetime").datetimepicker({
                format: "dd mm yyyy  hh:ii",
                autoclose: true,
                todayBtn: true,
                startDate: "2016-01-01 09:00",
                minuteStep: 60
            });
        })
    </script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

    <style type="text/css">

        body {
            overflow-y: scroll;
            overflow-x: scroll;
        }

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

        #logo {
            height: auto;
            min-height: 120px;
            width: auto;
            min-height: 120px;

        }

        #comntainerLogo {
            float: right;

        }

        #workersData {
            /*  padding-right: 10px;
              padding-top: 25px;*/
            vertical-align: middle;
            padding-right: 16px;
        }

        #worker_container_header {
            font-weight: bold;
            padding-left: 40px;
        }

        #headerWorkersMenu {
            height: 150px;
            padding: 5px;
            background-color: lightgreen;
        }

        #workerCabinetNav li {
            display: inline;
            font-weight: bold;
            border-style: ridge;

        }

        #workerCabinetNav ul {
            list-style-type: none;
            /*padding-left: 20px;*/
        }

        #workerCabinetNav {
            background-color: lightgrey;

            width: 100%;
            padding: 7px 7px 7px 7px;
            /*word-spacing: 10px;*/
        }

        #hideTableButton, #hideFormAdd, #updateTableButton {
            list-style-type: none;
            font-weight: bold;
            border-style: ridge;
            width: 150px;

        }

        #workSpaceHolder {
            width: 70%;
        }

        #workSpaceHolder, #workSpaceHolder2 {
            padding: 10px;
        }

        #timeShedullerButtons li,#serviceAddButtons li {
            display: inline;
            list-style-type: none;
            font-weight: bold;
            border-style: ridge;

        }
        #serviceAddButtons{
            width: 70%;

        }


    </style>
</head>
<body>

<%@include file="import.jsp" %>

<header id="headerWorkersMenu">
    <div class="row" id="workersData">
        <figure id="comntainerLogo">
            <a id="logoContainer" href="index.html"><img id="logo" height="45px" src="images/serviceCenterLogo.jpg"
                                                         alt="logo of Car service station Tokar"></a>
        </figure>
        <div class="row">

            <div id="worker_container_header">
                <div style="float:left">Workers cabinet of:&nbsp <c:out
                        value="${fn:toUpperCase(requestScope.worker.firstName)}"/></div>

                <div style="float:left">&nbsp<c:out value="${fn:toUpperCase(requestScope.worker.secondName)}"/></div>

                <div style="float:left">, <c:out value="${fn:toUpperCase(requestScope.worker.workerTypes)}"/></div>

            </div>


        </div>


    </div>


</header>
<div class="spacer" style="height: 8px"></div>

<nav class="navbar navbar-default" id="workerCabinetNav">
    <ul class="nav navbar-nav">

        <%--<li><a href="addSFC.jsp">Add service</a></li>--%>
        <li onclick="showFormAdd()"><a href="#">Add service</a></li>

        <li><a href="updateSFC.jsp">Update service</a></li>
        <li><a href="#">Remove service from Time-table</a></li>
        <li><a href="#">Confirm of service have done</a></li>


        <li><a href="#">Add client</a></li>
        <li><a href="#">Update client data</a></li>

        <%--<li><a href="${pageContext.servletContext.contextPath}/workerSheduler.jsp">See Time-table for some period</a></li>--%>
        <li onclick="showTable()"><a href="#">See Time-table</a></li>

    </ul>
</nav>

<section style="min-height: 57%">
    <section id="workSpaceHolder" style="display: none">

        <table id="workersSheduler" class="sortable">
            <thead>
            <tr>
                <th>#</th>
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
        <div class="spacer" style="height: 8px"></div>

        <nav class="navbar navbar-default" id="timeShedullerButtons">
            <ul class="nav navbar-nav">
                <li><a href="#" onclick="hideTable()">Hide Time Sheduler</a></li>
                <li><a href="#" onclick="updateTable()">Update Time Sheduler</a></li>
            </ul>
        </nav>


        <%-- <div id="timeShedullerButtons">
             <div id="hideTableButton">
                 <li><a href="#" onclick="hideTable()">Hide Time Sheduler</a></li>
             </div>
             <div id="updateTableButton" style="width: 200px">
                 <li><a href="#" onclick="updateTable()">Update Time Sheduler</a></li>
             </div>
         </div>--%>


    </section>
    <div class="spacer" style="height: 8px"></div>

    <section id="workSpaceHolder2" style="display: none">

        <div id="serviceForClientServAddForm">
            <form class="form-horizontal" role="form" action="addSFC" method="post">

                <div class="form-group">
                    <label class="control-label col-sm-2">Type of service or goods:</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="typeOfService" style="max-width: 400px">
                            <optgroup label="SERVICES">
                                <option value="Diagnostic">Diagnostic</option>
                                <option value="CHANGE_CONSUMABLES">Change consumables</option>
                                <option value="CHANGE_TIRES">Change tires</option>
                                <option value="REPAIR_MOTOR">Repair motor</option>
                                <option value="REPAIR_CHASSIS">Repair chassis</option>
                                <option value="REPAIR_BODY_CAR">Repair carbody</option>
                                <option value="REPAIR_BRAKE">Repair brakes</option>
                                <option value="REPAIR_CLUTCH">Repair clutch</option>
                                <option value="REPAIR_GEARBOX">Repair gearBox</option>
                                <option value="OTRHER_KIND_REPAIRING">Other kind of repairing</option>
                                <option value="WARRANTY_SERVICE">Warranty service</option>
                            </optgroup>
                            <optgroup label="GOODS IN STORE">
                                <option value="SPARE_PARTS">Spare parts</option>
                                <option value="Consumables">Consumables</option>
                                <option value="Tires">Tires</option>
                                <option value="Souvenirs">Souvenirs</option>
                            </optgroup>
                        </select>
                    </div>
                </div>
                <br>


                <br>

                <div class="form-group">
                    <label for="dtp_input1" class="col-md-2 control-label">Start date of service:</label>
                    <div style="max-width: 400px" class="input-group date form_datetime col-md-5"
                         data-date="1979-09-16T05:25:07Z"
                         data-date-format="dd mm yyyy  hh:ii" data-link-field="dtp_input1">
                        <input class="form-control" size="16" type="text" value="" required name="startDate"
                               placeholder="Input start date of service or product">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                    </div>
                    <input type="hidden" id="dtp_input2" value=""/><br/>
                </div>
                <br>
                <div class="form-group">
                    <label for="dtp_input1" class="col-md-2 control-label">Finish date of service:</label>
                    <div style="max-width: 400px" class="input-group date form_datetime col-md-5"
                         data-date="1979-09-16T05:25:07Z"
                         data-date-format="dd mm yyyy  hh:ii" data-link-field="dtp_input1">
                        <input class="form-control" size="16" type="text" value="" required name="finishDate"
                               placeholder="Input start date of service or product">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                    </div>
                    <input type="hidden" id="dtp_input1" value=""/><br/>
                </div>
                <br>

                <div class="form-group">
                    <label class="control-label col-sm-2">Price:</label>
                    <div class="col-sm-10">
                        <input style="max-width: 200px" type="number" class="form-control" name="price"
                               placeholder="Enter price" required>
                    </div>
                </div>
                <br>

                <div class=" form-group">
                    <label class="control-label col-sm-2">Clients ID:</label>
                    <div class="col-sm-10">
                        <input style="max-width: 200px" type="text" class="form-control" name="clientID"
                               placeholder="Enter Clients ID" required>
                    </div>

                </div>
                <br>
                <br>
                <div class=" form-group">
                    <label class="control-label col-sm-2">Workers ID:</label>
                    <div class="col-sm-10">
                        <input style="max-width: 200px" type="text" class="form-control" name="workersID"
                               placeholder="Enter Workers ID" required>
                    </div>
                </div>
                <br>
                <br>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>

            </form>
        </div>

        <div class="spacer" style="height: 8px"></div>


        <%-- <div id="hideFormAdd">
             <li><a href="#" onclick="hideFormAdd()">Hide form ADD SFC</a></li>
         </div>
 --%>

        <nav class="navbar navbar-default" id="serviceAddButtons">
            <ul class="nav navbar-nav">
                <li><a href="#" onclick="hideFormAdd()">Hide form ADD SFC</a></li>
            </ul>
        </nav>
    </section>
</section>


<div style="height: 100px"></div>


<nav style="padding: 5px; position:relative;
     width: 100%; margin-top: -10px;" class="navbar navbar-default">
    <div class="footerPlace " style="height: 51px; background-color:lavenderblush;">

        <div class="clear" style="height: 41px"></div>


        <div style=" background-color: white" class="grid_16 bottomRow">
            <div class="text">
                &copy; 2016.

                CSS Systems. Все права защищены.

                <a href="#">Политика конфиденциальности</a>

            </div>

        </div>
    </div>
</nav>


</body>
</html>
