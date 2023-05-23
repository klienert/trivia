

<%@include file="taglib.jsp"%>
<c:set var="title" value="Profile Page" />
<%@include file="head.jsp"%>
<html>
<div class="container">
  <%@include file="nav.jsp"%>
    <body>

     <div class="col-sm-6 text-info"><h2>Welcome ${user.firstName}!</h2>
          <table id="profileTable" class="table table-bordered">
            <thead>
              <th>Name</th>
              <th>User Name</th>
              <th>Email</th>
            </thead>
            <tbody>
                <tr>
                    <td>${user.firstName} ${user.lastName}</td>
                    <td>${user.userName}</td>
                    <td>${user.email}</td>
                </tr>
            </tbody>
          </table>
     </div>
<%--     <form action="profile-edit" method="post">--%>
<%--         <button type="button" class="btn btn-primary m-2 p-2">Edit Profile</button>--%>
<%--     </form>--%>

          <div class="row">
              <div class="col-sm-9">
                  <h2 class="text-dark">Past Trivia Rounds</h2>
                  <table class="table table-striped">
                      <thead>
                          <th>Description</th>
                          <th>Difficulty</th>
                          <th>Topic</th>
                          <th>Score</th>
                          <th>Completed</th>
                      </thead>
                      <tbody>
                          <c:forEach var="l" items="${list}">
                              <tr>
                                  <td>${l.description}</td>
                                  <td>${l.difficulty}</td>
                                  <td>${l.topic}</td>
                                  <td>${l.score}</td>
                                  <td>${l.completed}</td>
                              </tr>
                          </c:forEach>
                      </tbody>

                  </table>
              </div>
          </div>

    </body>
</div>

</html>
