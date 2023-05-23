<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</head>

<body>

    <%--@elvariable id="passwords" type="com.example.shipreservationsystem.ro.Passwords"--%>
    <form:form class="form-group" cssStyle="margin: 100px" name="_method" value="POST" action="/page/admin/" modelAttribute="passwords" >

<%--        <div class="form-group row">--%>
<%--            <form:label path="route_id" class="bolder" >Route ID : </form:label>--%>
<%--            <form:input class="form-control" id="route_id" path="route_id" type="text" disabled="true" value=""/> <br>--%>
<%--        </div> <br>--%>

        <div class="form-group row">
            <form:label path="oldPassword" class="bolder" >Old Password : </form:label>
            <form:input class="form-control" id="source" path="oldPassword" type="text" />
        </div> <br>

        <div class="form-group row">
            <form:label path="newPassword" class="bolder" >New Password : </form:label>
            <form:input class="form-control" id="destination" path="newPassword" type="text"/>
        </div> <br>

<%--        <div class="form-group row">--%>
<%--            <form:label path="distance" class="bolder" >Distance : </form:label>--%>
<%--            <form:input cssClass="form-control" id="distance" path="distance" type="text"/>--%>
<%--        </div> <br>--%>

        <input type="submit" value="Submit">

    </form:form>



</body>