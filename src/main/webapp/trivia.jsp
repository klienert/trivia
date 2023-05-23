<html>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Trivia Time!" />
<%@include file="head.jsp"%>
<script src="js/quiz.js"></script>
<body>
<div class="container">
    <%@include file="nav.jsp"%>
    <div class="row">
        <div class="col-sm-8 mx-auto m-2"><h2 class="text-success">Welcome to Trivia, ${username}!</h2></div>
        <br>
        <p class="text-center">Score:&nbsp;${score}</p>
    </div>

    <hr>
<%--    Question--%>
        <div class="text-center ">
            <h3 class="text-primary">${q.question}</h3>
        </div>

    <%--    Answers--%>
    <div class="row justify-content-center">
        <c:forEach var = "i" items="${ans}">
            <button class="btn btn-light col-2 m-2 p-2"
                    value="<c:out value = "${i}"/>"
                    name="<c:out value = "${i}"/>">
                <c:out value = "${i}"/>
            </button><br />
        </c:forEach>
    </div>



    <%--    full API for 8 questions, based on choices --%>
    <hr>
    <br />
    <small>${quiz}</small>


    <%--    Answer buttons--%>
<%--    <div class="row justify-content-center">--%>
<%--        <c:forEach var = "i" items="${ans}">--%>
<%--            <button class="btn btn-light col-2 m-2 p-2"--%>
<%--                    value="<c:out value = "${i}"/>">--%>
<%--                <c:out value = "${i}"/>--%>
<%--            </button><br />--%>
<%--        </c:forEach>--%>
<%--    </div>--%>
    <hr>

    <div class="row justify-content-center">
        <%--  Answer--%>
        <p>The correct Answer is: ${corrAns}</p>
    </div>

</div>
</body>
</html>
