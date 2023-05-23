<html>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Sign In" />
<%@include file="head.jsp"%>
<body>
<div class="container">
    <%@include file="nav.jsp"%>

    <%--    Form for User Sign In--%>
    <form id="signInForm" role="form" data-toggle="validator" class="form-horizontal needs-validation"
          action="signInUser" novalidate method="POST">

        <%-- Username --%>
        <div class="form-group">
            <label class="control-label col-sm-2" for="userName">UserName</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="userName"
                    name="userName" data-error="Please enter your userName" required>
            </div>
            <div class="invalid-feedback">
                Please provide a valid user name.
            </div>
<%--            <div class="help-block with-errors"></div>--%>
        </div>
        <%-- Password --%>
        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Password</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="password"
                       name="password" data-error="Please enter your password" required>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input"
                    id="show_password_check" onclick="togglePassword()">
                    <label class="form-check-label" for="show_password_check">Show Password</label>
                </div>
                <div class="invalid-feedback">
                    Please provide a valid password.
                </div>
            </div>

        </div>
        <%-- button--%>
        <button type="submit" class="btn btn-default col-sm-offset-3 border border-dark" data-disable="true">
            Log In
        </button>
        <button type="reset" class="btn btn-default border border-dark">Clear</button>
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
