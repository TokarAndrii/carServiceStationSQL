<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="WEB-INF/pages/import.jsp" %>
<head>
    <title>Updating service for client!!!!</title>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    <script>

        function showForm() {
            document.getElementById("updateSFCform").style.display = "block";

        }
        ;

        function sendSFCinformation() {

            var idSFC = $("#idSFC").val();
            var objectText = {
                type: "GET",
                url: "/carServiceStation/updateSFC",
                data: {idSFC: idSFC},
                success: function (result) {
                    $("#response").html(result);
                    showForm();
                }
            };

            $.ajax(objectText);


        }

        $(function () {
            $(".form_datetime").datetimepicker({
                format: "dd MM yyyy - hh:ii",
                autoclose: true,
                todayBtn: true,
                startDate: "2016-01-01 09:00",
                minuteStep: 60
            });
        })


    </script>


</head>
<body>

<p class="headerRegister">
    <span id="registerClientForm">Update Service for client</span>
    <span><img src="images/serviceCenterLogo.jpg" class="img-thumbnail" alt="logo"
               style="width: 85px; height: 85px;float:right"/></span>
</p>




<div class="form-group">
    <label class="control-label col-md-2">Add ID of Service of client to be updated: </label>
    <div class="col-md-2">
        <input type="number" name="idSFC" id="idSFC" placeholder="Enter ID of SFC " required>
    </div>

</div>

<br><br>

<div class="form-group">
    <div class="col-md-offset-2 col-md-2">
        <button id="submitButton" onclick="sendSFCinformation()" class="btn btn-sm btn-default">Find</button>
    </div>

</div>

<br><br><br>


<div><p id="response"></p></div>
<br><br><br>


<div id="updateSFCform" style="display: none">
    <form class="form-horizontal" action="updateSFC" method="post">
        <div class="form-group">
            <label class="control-label col-md-2">Choose new name of service or goods:</label>
            <div class="col-md-2">
                <select class="typeOfService" name="newTypeOfCFC">
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
                    <option selected></option>
                </select>
            </div>
        </div>
        <br>
        <br>
        <br>
        <div class="form-group">
            <label class="control-label col-md-2">New start date of service or goods: </label>
            <div class="col-md-6">
                <div class="input-append date form_datetime" data-date="2016-01-01T15:25:00Z" data-date-format="dd mm yyyy  hh:ii" data-link-field="dtp_input1" >

                    <input class="datetimepicker" type="text" name="startDate" value="">
                    <span class="add-on"><i class="icon-remove"></i></span>
                    <span class="add-on"><i class="icon-th"></i></span>
                </div>


            </div>
        </div>
        <br><br>


        <div class="form-group">
            <label class="control-label col-md-2">New finish date of service or goods:</label>
            <div class="col-md-6">
                <div class="input-append date form_datetime" data-date="2016-01-01T15:25:00Z">

                    <input class="datetimepicker" type="text" name="finishDate" value="">
                    <span class="add-on"><i class="icon-remove"></i></span>
                    <span class="add-on"><i class="icon-th" aria-hidden="true"></i></span>
                </div>


            </div>


        </div>

        <br>
        <br>

        <div class="form-group">
            <label class="control-label col-md-2">New price of service or goods: </label>
            <div class="col-md-2">
                <input type="number" name="price">
            </div>
        </div>
        <br>
        <br>

        <div class=" form-group">
            <label class="control-label col-md-2">New worker responsible for SFC - enter ID: </label>
            <div class="col-md-2">
                <input type="text" name="workers">
            </div>
        </div>
        <br>
        <br>
        <div class="form-group">
            <div class="col-md-offset-2 col-md-2">
                <button type="submit" class="btn btn-lg btn-default">Submit</button>
            </div>
        </div>

    </form>
</div>
<link rel="stylesheet" href="dateTimePeacker/css/bootstrap.css">
<link rel="stylesheet" href="dateTimePeacker/css/bootstrap-datetimepicker.css">
<script src="dateTimePeacker/js/main.js"></script>
<script src="dateTimePeacker/js/bootstrap-datetimepicker.js"></script>


</body>
</html>
