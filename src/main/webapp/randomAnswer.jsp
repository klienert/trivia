<html>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Random Trivia Answers" />
<%@include file="head.jsp"%>
<style>
    #ans {
        animation: fadeInAnimation ease 3s;
        animation-iteration-count: 1;
        animation-fill-mode: forwards;
    }

    @keyframes fadeInAnimation {
        0% { opacity: 0; }
        100% { opacity: 1; }
    }
</style>
<body>
    <div class="container">
        <%@include file="nav.jsp"%>
        <div class="row justify-content-center">
            <div class="col mx-auto m-2 p-2">
                <h2 class="text-center">Random Trivia Answer</h2>
            </div>
        </div>

        <%--      The question --%>
        <div class="row justify-content-center m-2 p-2">
            <h3 class="text-primary">${q.question}</h3>
        </div>

        <div class="row justify-content-center">
            <c:if test="${isCorrect == true}">
                <h4 class="ans"><span class="text-success">${q.correctAnswer}</span></h4>
            </c:if>
            <c:if test="${isCorrect == false}">
                <h4 class="ans"><span class="text-danger">${a}</span>, the correct answer was <span class="font-italic">${q.correctAnswer} </span></h4>
            </c:if>
        </div>

        <%--      Button, next question? --%>
        <p class="text-center m-3 p-3"><a class="btn btn-primary" href="randomQuestion">Next Question</a></p>

    </div>
</body>
</html>
