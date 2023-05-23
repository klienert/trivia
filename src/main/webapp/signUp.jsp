<html>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Sign Up" />
<%@include file="head.jsp"%>
<body>
    <div class="container">
        <%@include file="nav.jsp"%>
    <%--        Form for User registration --%>
        <form id="signUpForm" role="form" data-toggle="validator" class="form-horizontal needs-validation"
              action="signUpUser" novalidate method="post">

            <div class="form-group">
                <label class="control-label col-sm-2" for="firstName">First
                    Name</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="firstName"
                           name="firstName"
                           data-error="Please enter your first name." required>
                </div>
                <div class="invalid-feedback">
                    Please provide a valid first name.
                </div>
<%--                <div class="help-block with-errors"></div>--%>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="lastName">Last Name</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="lastName"
                           name="lastName"
                           data-error="Please enter your last name." required>
                </div>
                <div class="invalid-feedback">
                    Please provide a valid last name.
                </div>
<%--                <div class="help-block with-errors"></div>--%>
            </div>
            <div class="form-group">
                <label  class="control-label col-sm-2" for="emailAddress">Email
                    Address</label>
                <div class="col-sm-4">
                    <input type="email" class="form-control" id="emailAddress"
                           name="emailAddress"
                           data-error="Please enter your email address." required>
                </div>
                <div class="invalid-feedback">
                    Please provide a valid email address.
                </div>
<%--                <div class="help-block with-errors"></div>--%>
            </div>
            <div class="form-group">
                <label  class="control-label col-sm-2" for="userName">Username</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="userName"
                           name="userName"
                           data-error="Please enter your userName." required>
                </div>
                <div class="invalid-feedback">
                    Please provide a valid user name.
                </div>
<%--                <div class="help-block with-errors"></div>--%>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="password">Password
                </label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="password"
                           name="password" data-error="Please provide a password."
                           required>
                    <div class="form-group form-check">
                        <input type="checkbox" class="form-check-input"
                               id="show_password_check"
                               onclick="togglePassword()">
                        <label class="form-check-label"
                               for="show_password_check">Show Password</label>
                    </div>
<%--                    <div class="help-block with-errors"></div>--%>
                    <div class="invalid-feedback">
                        Please provide a valid password.
                    </div>
                </div>

            </div>
<%--            <div class="form-group">--%>
<%--                <label class="control-label col-sm-2"--%>
<%--                       for="confirmPassword">Retype Password</label>--%>
<%--                <div class="col-sm-4">--%>
<%--                    <input type="password" class="form-control" id="confirmPassword"--%>
<%--                           name="confirmPassword" equalTo="#password"--%>
<%--                           data-match="#password"--%>
<%--                           data-match-error="Confirmation password does not match"--%>
<%--                           required data-error="Please retype your password.">--%>
<%--                    <div class="help-block with-errors"></div>--%>
<%--                </div>--%>
<%--            </div>--%>

            <button type="submit" class="btn btn-primary col-sm-offset-3"
                    data-disable="true">Submit</button>
            <button type="reset" class="btn btn-primary">Clear</button>
            <!--for google recaptcha-->
<%--            <div class="g-recaptcha" data-sitekey="6LewtTgUAAAAADuEbgusz9FbghpuXq-gBm6rLPS9"></div>--%>
        </form>
        <!-- JS for form -->
        <script>
            // JavaScript for disabling form submissions if there are invalid fields
            (function () {
                'use strict';
                window.addEventListener('load', function () {
                    // Fetch all the forms we want to apply custom Bootstrap validation styles to
                    var forms = document.getElementsByClassName('needs-validation');
                    // Loop over them and prevent submission
                    var validation = Array.prototype.filter.call(forms, function (form) {
                        form.addEventListener('submit', function (event) {
                            if (form.checkValidity() === false) {
                                event.preventDefault();
                                event.stopPropagation();
                            }
                            form.classList.add('was-validated');
                        }, false);
                    });
                }, false);
            })();

            function togglePassword() {
                var password_entry = document.getElementById("password");
                if (password_entry.type === "password") {
                    password_entry.type = "text";
                } else {
                    password_entry.type = "password";
                }
            }
        </script>
    </div>
</body>
</html>
