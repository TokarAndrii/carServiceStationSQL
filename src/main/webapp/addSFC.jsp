

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="WEB-INF/pages/import.jsp" %>


<head>
    <title>Add SERVICE PAGE!!!!!</title>
    <link rel="stylesheet" href="dateTimePeacker/css/bootstrap.css" media="screen">
    <link rel="stylesheet" href="dateTimePeacker/css/bootstrap-datetimepicker.css" media="screen">
    <link rel="stylesheet" href="dateTimePeacker/css/jquery-ui.theme.css" media="screen">
    <link rel="stylesheet" href="dateTimePeacker/css/jquery-ui.css" media="screen">

    <link rel="stylesheet" href="dateTimePeacker/css/bootstrap-datetimepicker.css" media="screen">


    <script src="dateTimePeacker/js/main.js"></script>
    <script src="dateTimePeacker/js/bootstrap-datetimepicker.js"></script>
    <script src="dateTimePeacker/js/jquery-ui.js"></script>


    <script type="text/javascript">
        $(function () {
            $(".form_datetime").datetimepicker({
                format: "dd mm yyyy hh:ii",

                autoclose: true,
                todayBtn: true,
                startDate: "2016-01-01 09:00",
                minuteStep: 10
            });
        })


    </script>
   <!-- <script type="text/javascript">
        $(function () {
            $(".icon-remove").clear()
        })


    </script>-->

</head>
<body>


<p class="headerRegister">
    <span id="registerClientForm">Adding Service for client</span>
                <span><img src="images/serviceCenterLogo.jpg" class="img-thumbnail" alt="logo"
                           style="width: 85px; height: 85px;float:right"/></span>
</p>
</div>
<br>
<br>
<br>

<div id="serviceForClientServAddForm">
    <form class="form-horizontal" role="form" action="addSFC" method="post">


        <div class="form-group">
            <label class="control-label col-sm-2">Type of service or goods:</label>
            <div class="col-sm-10">
                <select name="typeOfService">
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
            <div class="input-group date form_datetime col-md-5" data-date="1979-09-16T05:25:07Z" data-date-format="dd mm yyyy  hh:ii" data-link-field="dtp_input1">
                <input class="form-control" size="16" type="text" value="" required name="startDate" placeholder="Input start date of service or product">
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <input type="hidden" id="dtp_input2" value="" /><br/>
        </div>
        <br>
        <div class="form-group">
            <label for="dtp_input1" class="col-md-2 control-label">Finish date of service:</label>
            <div class="input-group date form_datetime col-md-5" data-date="1979-09-16T05:25:07Z" data-date-format="dd mm yyyy  hh:ii" data-link-field="dtp_input1">
                <input class="form-control" size="16" type="text" value="" required name="finishDate" placeholder="Input start date of service or product">
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <input type="hidden" id="dtp_input1" value="" /><br/>
        </div>
        <br>

        <div class="form-group">
            <label class="control-label col-sm-2">Price:</label>
            <div class="col-sm-10">
                <input type="number" name="price" placeholder="Enter price" required>
            </div>
        </div>
        <br>

        <div class=" form-group">
            <label class="control-label col-sm-2">Clients ID:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="clientID"
                       placeholder="Enter Clients ID" required>
            </div>

        </div>
        <br>
        <br>
        <div class=" form-group">
            <label class="control-label col-sm-2">Workers ID:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="workersID"
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

</body>

