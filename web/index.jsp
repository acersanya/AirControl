<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
     
        <title>Login and registartion </title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="style.css">

        <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

        <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>

        <link rel="stylesheet" type="text/css" href="style.css">
        <style type="text/css">
            #errorContainer {
                display: none;
                overflow: auto;
                background-color: #FFDDDD;
                border: 1px solid #FF2323;
                padding-top: 0;
            }
            #errorContainer label {
                float: none;
                width: auto;
            }
            input.error {
                border: 1px solid #FF2323;
            }
        </style>

        <script type="text/javascript">

$.validator.addMethod("anyDate",
        function (value, element) {
            return value.match(/^(0?[1-9]|[12][0-9]|3[0-1])[/., -](0?[1-9]|1[0-2])[/., -](19|20)?\d{2}$/);
        },
        "Please enter a date in the format!"
        );

$(function () {
    $("#tabs").tabs();
});



$(function () {
    $('#registationForm').validate({
        rules: {
            fullname: "required",
            surname: "required",
            login: {
                required: true,
                minlength: 3,
                maxlength: 10
            },
            password: {
                required: true,
                minlength: 6,
                maxlength: 15
            },
            birthdate: {
                anyDate: true
            }

        },
        messages: {
            fullname: "Please enter your first name.",
            surname: "Please enter your last name.",
            login: "Your login should be at least 3 characters",
            password: "Your password should be at least 6 length",
            birthdate: "Data format should be: dd/mm/yy or dd/mm/yyyy"
        },
        errorContainer: $('#errorContainer'),
        errorLabelContainer: $('#errorContainer ul'),
        wrapper: 'li'
    });
});


$(function () {
    $('#loginForm').validate({
        rules: {
            login: {
                required: true,
                minlength: 3,
                maxlength: 10
            },
            password: {
                required: true,
                minlength: 6,
                maxlength: 15
            }

        },
        messages: {
            login: "Your login should be at least 3 characters",
            password: "Your password should be at least 6 length"

        },
        errorContainer: $('#errorContainer'),
        errorLabelContainer: $('#errorContainer ul'),
        wrapper: 'li'
    });
});


        </script>




    </head>
    <body>
        <div class="wrapper">
            <div class="header">
                <h4 style="text-align: center">Login and Registration page</h4>
            </div>

            <div class="container">
                <div class="instruction">
                    <div id="tabs">
                        <ul>
                            <li><a href="#login">Login</a></li>
                            <li><a href="#register">Register</a></li>
                        </ul>
                        <div id="login">
                            <%
            if ("Invalid username or password".equalsIgnoreCase((String) session.getAttribute("error"))) { %>
                            <h6> Invalid user name or password. Please try again.</h6>
                            <%}%>
                            <form method="post" action="LoginController" id="loginForm" >
                                <label for="login">Login:</label>
                                <input type="text" name="login" id="login" class="login" placeholder="Your login"/>
                                <label for="password">Password:</label>
                                <input type="password" name="password" id="password" class="password" placeholder="Your password"/>
                                <input type="submit" value="Login">
                            </form>
                        </div>



                        <div id="register">
                            <form  method="post" action="RegistrationController" id="registationForm">
                                <label for="fullname">Name:</label><br/>
                                <input type="text" name="fullname" id="fullname" class="fullname" placeholder="Your full name"/>
                                <br/>
                                <label for="surname">Surname:</label><br/>
                                <input type="text" name="surname" id="surname" class="surname" placeholder="Your surname"/>
                                <br/>
                                <label for="password">Password:</label><br/>
                                <input type="password" name="password" id="password" class="password" placeholder="Your password"/>
                                <br/>
                                <label for="login">Login:</label><br/>
                                <input type="text" name="login" id="login" class="login" placeholder="Your login"/>
                                <br/>
                                <label for="gender">Gender:</label><br/>
                                <select name="gender" id="gender" class="gender">
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                </select>
                                <br/>
                                <label for="position">Position:</label><br/>
                                <select name="position" id="position" class="position">
                                    <option value="captain">Captatin</option>
                                    <option value="First officer">First Officer</option>
                                    <option value="Second officer">Second Officer</option>
                                    <option value="Third officer">Third Officer</option>
                                    <option value="Flight engineer">Flight Engineer</option>
                                    <option value="Stewardesses">Stewardesses</option>
                                </select>
                                <br/>
                                <label for="birthdate">Birth Date:</label><br/>
                                <input type="text" name="birthdate" id="birthdate" class="birthdate" placeholder="Your birth date"/>
                                <br/>
                                <input type="submit" value="Register">
                            </form>
                        </div>

                    </div>
                </div>
            </div>

            <div class="footer">
                &copy; Aircompany 2015
            </div>
        </div>
    </body>
</html>