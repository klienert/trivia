<html>
<%@include file="taglib.jsp"%>
<c:set var="title" value="End of Selected Trivia Answers" />
<%@include file="head.jsp"%>

<body>
    <div class="container">
        <%@include file="nav.jsp"%>
        <div class="row justify-content-center">
            <div class="col mx-auto m-2 p-2">
                <h2 class="text-center">Your Results for this round: </h2>
            </div>
        </div>
        <%--  The Topic --%>
        <h3 class="text-center">Topic <span class="text-info">${topic}</span></h3>
        <%--  The Final Score--%>
        <h4 class="text-center">Your final score is: ${finalScore}</h4>
        <hr>
        <%--        Play Again or GO Home--%>
        <h5>Play Again?</h5>
        <p class="text-center m-3 p-3"><a class="btn btn-primary" href="quizselect">New Trivia Round</a></p>

    </div>
</body>
</html>
