<html>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Trivia Time!" />
<%@include file="head.jsp"%>

<body>
<div class="container">
    <%@include file="nav.jsp"%>
    <div class="row">
        <div class="col-sm-8 mx-auto m-2"><h2 class="text-success">Welcome to Trivia, ${username}!</h2></div>
    </div>
    <div class="row">
        <p class="text-center">Score:&nbsp;${score}</p>
    </div>

    <hr>
    <%--    Getting Ready --%>
    <div class="text-center ">
        <h3 class="text-primary">${x}</h3>
    </div>
    <div class="row">
        <div class="col mx-auto">
            <a class="btn btn-primary" href="questions">Start Trivia!</a>
        </div>

    </div>





</div>
</body>
</html>
