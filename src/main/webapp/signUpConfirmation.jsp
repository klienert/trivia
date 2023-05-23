<%@include file="taglib.jsp"%>
<c:set var="title" value="Sign-Up Confirmation" />
<%@include file="head.jsp"%>

<html>
<body>
<div class="container">
    <%@include file="nav.jsp"%>

    <c:choose>
        <c:when test = "${errorMessage == null}">
            <div class="alert alert-success" role="alert">
                <strong>New User Registration -- Success</strong> Welcome!
            </div>
            <h4>Welcome ${username}</h4>
            <p>Please <a href="signIn.jsp">Sign In</a></p>
        </c:when>
        <c:otherwise>
            <div class="alert alert-danger" role="alert">
                <strong>New User Registration -- Failed</strong><br />
                ${errorMessage}<br /><br />
                <a href="signUp.jsp"><button type="button" class="btn btn-primary">Retry</button></a>
                <a href="results.jsp"><button type="button" class="btn btn-default">Cancel (Results)</button></a>
                <a href="results.jsp"><button type="button" class="btn btn-default">Cancel (Results)</button></a>
            </div>
        </c:otherwise>
    </c:choose>
</div>



</body>
</html>
