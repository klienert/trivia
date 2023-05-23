<%@include file="taglib.jsp"%>
<c:set var="title" value="Random Quiz" />
<%@include file="head.jsp"%>
<html>

<div class="container">
    <%@include file="nav.jsp"%>
    <body>
    <c:if test="${not empty username}">
        <div class="col-sm-8 m-2 p-2">
            <h2>Trivia Quiz</h2>
            <br>
            <h3>Welcome <span class="text-success">${user.firstName}</span> </h3>
            <br>
            <%@include file="selectedForm.jsp"%>
        </div>
    </c:if>
    <c:if test="${empty username}">
        <br>
        <div class="text-center">
            <h4 class="text-info m-2 p-2">Ope!</h4>
            <p>You need to log in first!</p>
            <p>Please <a href="signIn.jsp">sign in</a> to access this page.</p>
            <hr>
            <small>Meanwhile, here's a beaver eating cabbage!</small>
            <div class="row justify-content-center">
                <div class="tenor-gif-embed" data-postid="19336743" data-share-method="host"
                     data-aspect-ratio="1.92771" data-width="75%">
                    <a href="https://tenor.com/view/stress-cabbage-beaver-eating-cabbages-gif-19336743"></a>
                </div>
                <script type="text/javascript" async src="https://tenor.com/embed.js"></script>
            </div>
        </div>


    </c:if>






</body>
</div>
</html>
