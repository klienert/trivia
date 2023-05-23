<html>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Trivia App" />
<%@include file="head.jsp"%>


<body>
<div class="container">
    <%@include file="nav.jsp"%>
    <h2 class="text-center">Trivia Quiz App</h2>

    <div class="row">
        <div class="col-8">
            <h3>Welcome to the Trivia Quiz App</h3>
            <p>I developed this app as a way to play some trivia, using an API from <a href="https://opentdb.com/" target="_blank"> Open Trivia DB</a></p>
            <p>Users can either log in to specify a topic and difficulty level, as well as eventually keep track of their progress. Or you may skip the log in
                and head straight to the <a href="randomStart">Random Trivia</a>!</p>
        </div>
    </div>
</div>
</body>
</html>