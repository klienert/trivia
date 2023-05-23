<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>

<html>
<body>
<div class="container">
    <%@include file="nav.jsp"%>
    <div class="col-sm-8"><h2>Search Results</h2></div>
    <table id="userTable" class="table table-bordered" cellspacing="0" width="100%">
        <thead>
        <th>Name</th>
        <th>User Name</th>
        <th>Email</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.userName}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>





<%--<%@include file="taglib.jsp"%>--%>
<%--<c:set var="title" value="Search Results" />--%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">--%>
<%--<html xmlns="http://www.w3.org/1999/xhtml">--%>
<%--<%@include file="head.jsp"%>--%>
<%--<body>--%>

<%--    <div class="container-fluid">--%>
<%--        <h2>Search Results: </h2>--%>
<%--    &lt;%&ndash;    Enter a table with users &ndash;%&gt;--%>
<%--        <table id="userTable" class="table table-striped w-75  " >--%>
<%--            <thead>--%>
<%--            <th scope="col">Name</th>--%>
<%--            <th scope="col">User</th>--%>
<%--            <th scope="col">Age</th>--%>
<%--            <th scope="col">Orders</th>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--            <c:forEach var="user" items="${users}">--%>
<%--                <tr>--%>
<%--                    <td>${user.firstName} ${user.lastName}</td>--%>
<%--                    <td>${user.userName} </td>--%>
<%--                    <td>${user.age} </td>--%>
<%--                    <td>--%>
<%--                        <c:forEach var="order" items="${user.orders}">--%>
<%--                        ${order.id} ${order.description}<br />--%>
<%--                        </c:forEach>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <a class='add' title="Add" data-toggle="tooltip" href="editUser.jsp"><i class="material-icons" >&#xe146;</i></a>--%>
<%--                        <a class="edit" title="Edit" data-toggle="tooltip" href="editUser?id=${user.id}"><i class="material-icons" >&#xE254;</i></a>--%>
<%--                        <a class="delete" title="Delete" data-toggle="tooltip" href="deleteUser?id=${user.id}"><i class="material-icons" >&#xE872;</i></a>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </tbody>--%>
<%--        </table>--%>
<%--    <a href="index.jsp">Back to Search</a>--%>
<%--&lt;%&ndash;        ${users}&ndash;%&gt;--%>
<%--    </div>--%>
<%--</body>--%>
<%--</html>--%>
