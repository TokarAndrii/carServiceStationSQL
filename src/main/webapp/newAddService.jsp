<%--
  Created by IntelliJ IDEA.
  User: tokarandrii
  Date: 07.05.16
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add SERVICE PAGE!!!!!</title>
    <link rel="stylesheet" href="dateTimePeacker/css/bootstrap.css">
    <link rel="stylesheet" href="dateTimePeacker/css/bootstrap-datetimepicker.css">
    <script src="dateTimePeacker/js/main.js"></script>
    <script src="dateTimePeacker/js/bootstrap-datetimepicker.js"></script>


    <script type="text/javascript">
        $(function () {
            $(".form_datetime").datetimepicker({
                format: "dd MM yyyy - hh:ii",
                autoclose: true,
                todayBtn: true,
                startDate: "2016-01-01 09:00",
                minuteStep: 10
            });
        })


    </script>

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
    <form lass="form-horizontal" role="form" action="addServiceForClient" method="post">
        <div class="form-group">
            <label class="control-label col-sm-2">Type of service or goods:</label>
            <div class="col-sm-10">
                <select class="typeOfService" required>
                    <optgroup label="SERVICES">
                        <option>Diagnostic</option>
                        <option>Change consumables</option>
                        <option>Change tires</option>
                        <option>repair motor</option>
                        <option>repair chassis</option>
                        <option>repair carbody</option>
                        <option>repair brakes</option>
                        <option>repair clutch</option>
                        <option>repair gearBox</option>
                        <option>other kind of repairing</option>
                    </optgroup>
                    <optgroup label="GOODS IN STORE">
                        <option>Spare parts</option>
                        <option>Consumables</option>
                        <option>Tires</option>
                        <option>Souvenirs</option>
                    </optgroup>
                </select>
            </div>
        </div>
        <br>
        <br>
        <br>
        <div class="form-group">
            <label class="control-label col-sm-2">Start Date:</label>
            <div class="input-append date form_datetime" data-date="2016-01-01T15:25:00Z">

                <input class="datetimepicker" type="text" name="startDate" value="" required>
                <%--<span class="add-on"><i class="icon-remove"></i></span>
                <span class="add-on"><i class="icon-th"></i></span>--%>

            </div>
        </div>
        <br>


        <div class="form-group">
            <label class="control-label col-sm-2">Finish Date:</label>
            <div class="input-append date form_datetime" data-date="2016-01-01T15:25:00Z">

                <input class="datetimepicker" type="text" name="finishDate" value="" required>
                <%--<span class="add-on"><i class="icon-remove"></i></span>
                <span class="add-on"><i class="icon-th"></i></span>--%>

            </div>
        </div>

        <br>
        <br>

        <div class="form-group">
            <label class="control-label col-sm-2">Price:</label>
            <div class="col-sm-10">
                <input type="number" name="price" placeholder="Enter price" required>
            </div>
        </div>
        <br>
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
                <input type="text" class="form-control" name="workers"
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
</html>
