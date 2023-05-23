<html>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Users" />
<%@include file="head.jsp"%>
<body>
<div class="container-fluid">
  <h2>User Display Exercise</h2>
  <form action="searchUser" class="form-inline">
    <div class="form-group">
      <label for="searchTerm">Search</label>
      <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp" placeholder="Enter last name">
    </div>
    <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
    <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View all users</button>
  </form>
</div>
</body>
</html>