<%@ page language="java" %>
<html>
<%@include file="/taglib.jsp"%>
<c:set var="title" value="Test Form" />
<%@include file="/head.jsp"%>
<body>
<div class="container">
<%@include file="/nav.jsp"%>
    <div class="row ">
      <h1>My Quiz</h1>
    </div>
  <div class="row ">
      <%-- handle GET request --%>
      <div class="text-center ">
          <h3 class="text-primary">Sample Question</h3>
      </div>
      <%
          
        if ("GET".equals(request.getMethod())) {
          // initialize the choice variable
          String choice = "";
          // get the choice parameter if it exists
          if (request.getParameter("choice") != null) {
            choice = request.getParameter("choice");
          }
          // display the current choice
          out.println("<p>Current choice: " + choice + "</p>");
      %>
      <form method="post">
        <input class="btn btn-light col-2 m-2 p-2" type="submit" name="choice" value="Ans 1">
        <input class="btn btn-light col-2 m-2 p-2" type="submit" name="choice" value="Ans 2">
        <input class="btn btn-light col-2 m-2 p-2" type="submit" name="choice" value="Ans 3">
        <input class="btn btn-light col-2 m-2 p-2" type="submit" name="choice" value="Ans 4">
      </form>
      <%-- handle POST request --%>
      <% } else if ("POST".equals(request.getMethod())) {
        // get the selected choice
        String choice = request.getParameter("choice");
        // display the selected choice
        out.println("<p>Selected choice: " + choice + "</p>");
      } %>
<%--      <p>You Selected: ${choice}</p>--%>

    </div>
</div>
</body>
</html>
