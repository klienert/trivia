<%@ page import="com.triviabuild.trivia.Trivia" %>
<html>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Selected Trivia Question" />
<%@include file="head.jsp"%>

<body>
<div class="container">
  <%@include file="nav.jsp"%>
  <div class="row justify-content-center">
    <h2 class="text-center">Trivia Question</h2>
  </div>

  <%--    Scoring --%>
  <table class="mx-auto m-2 p-2" id="score-table">
    <tr>
      <th>Current Score&nbsp;&nbsp;</th>
      <td id="currScore">${score}</td>
    </tr>
    <tr>
      <th>Questions Remaining &nbsp;</th>
      <td>${countdown}</td>
    </tr>
  </table>

  <%--    Question--%>
  <div class="text-center ">
    <h3 class="text-primary m-2 p-2" >${api.question}</h3>

    <%--  buttons--%>
    <div class="col-sm-8 mx-auto">
      <form action="quizAnswer" method="post">
        <c:forEach var="btn" items="${allAns}">
          <button class="btn btn-light border border-dark m-2 p-2" name="btn"
                  type="submit" value="${btn}" id="${btn}">${btn}</button>
        </c:forEach>
      </form>
    </div>
    <hr>
  </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
