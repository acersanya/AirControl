<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="style.css">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js" type="text/javascript"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery.Validate/1.6/jQuery.Validate.js" type="text/javascript"></script>
<script type="text/javascript">

$().ready(function() {

$.validator.addMethod("time24", function(value, element) {
    return /^([01]?[0-9]|2[0-3])(:[0-5][0-9]){2}$/.test(value);
}, "Invalid time format.");

    $('#addForm').validate({
        rules: {
            departure_place: {
                required: true,
                minlength: 3,
                maxlength: 10
            },
            arrival_place: {
                required: true,
                minlength: 3,
                maxlength: 10
            },
            departure_time: {
             time24: true
            },
              arrival_time: {
                time24: true
            }


        },
        messages: {
            departure_place: "Arrival Place should be at least 3 characters.",
            arrival_place: "Departure Place should be at least 3 characters.",
            departure_time: "Your password should be at least 6 length",
            arrival_time: "Data format should be: dd/mm/yy or dd/mm/yyyy"
        },
        errorContainer: $('#errorContainer'),
        errorLabelContainer: $('#errorContainer ul'),
        wrapper: 'li'
    });
});




        </script>

  

 

        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styleOther.css" rel="stylesheet" type="text/css"/>
        <title>New Flight</title>
    </head>
    <body>
        <%@include file="header.jsp"%>

    
            <div id="mystyle" class="myform">
                <form id="addForm" name="addForm" action="AddNewFlight" method="post">
                    <h1>Flight Add</h1>
                    <p>To add new Flight enter following information</p>
                    <label>Departure Place<span class="small">Enter departure place</span></label>
                    <input type="text" name="departure_place" id="departure_place" />
                    <label>Arrival Place<span class="small">Enter arrival place</span></label>
                    <input type="text" name="arrival_place" id="arrival_place" />
                    <label>Departure Time<span class="small">Enter departure time</span></label>
                    <input type="text" name="departure_time" id="departure_time" />
                    <label>Arrival Time<span class="small">Enter arrival time</span></label>
                    <input type="text" name="arrival_time" id="arrival_time" />       
                    <button type="submit">Add New Flight</button>
                    <div class="spacer"></div>
                </form>
            </div>
            <%@include file="bottom.jsp" %>
    </body>
</html>