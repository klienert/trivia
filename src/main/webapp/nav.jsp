
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler" aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarToggler">
        <a class="navbar-brand" href="index.jsp">Home</a>
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="profile">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="randomStart">Random Trivia</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="quizselect">Selected Trivia</a>
            </li>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link disabled" href="#">About</a>--%>
<%--            </li>--%>
        </ul>
        <c:if test="${empty username}">
<%--            <a class="navbar-brand my-2 my-lg-0" href="signUp.jsp">Sign up</a>--%>
<%--            <a class="navbar-brand my-2 my-lg-0" href="signIn.jsp">Sign in</a>--%>
            <a class="navbar-brand my-2 my-lg-0" href="logIn">Sign in</a>
        </c:if>
        <c:if test="${not empty username}">
            <a class="navbar-brand my-2 my-lg-0" href="signOutUser">(${username}) Sign Out</a>
        </c:if>


    </div>
</nav>