<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <title>New Ship</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"  crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</head>


<body>


<%--@elvariable id="ship" type="com.example.shipreservationsystem.model.ShipDetails"--%>
<form:form class="form-group" cssStyle="margin: 100px" value="POST" action="/page/ships/details/new" modelAttribute="ship" >

    <%--    <div class="form-group row">--%>
    <%--        <form:label path="route_id" class="bolder" >Route ID : </form:label>--%>
    <%--        <form:input class="form-control" id="route_id" path="route_id" type="text" disabled="true" value=""/> <br>--%>
    <%--    </div> <br>--%>

    <div class="form-group row">
        <form:label path="sname" class="bolder" >Ship Name : </form:label>
        <form:input class="form-control" id="sname" path="sname" type="text" />
    </div> <br>

    <div class="form-group row">
        <form:label path="model" class="bolder" >Model Name : </form:label>
        <form:input class="form-control" id="model" path="model" type="text"/>
    </div> <br>

    <div class="form-group row">
        <form:label path="capacity" class="bolder" >Capacity : </form:label>
        <form:input cssClass="form-control" id="capacity" path="capacity" type="text"/>
    </div> <br>

    <input type="submit" value="Submit">

</form:form>


<style>
    .bolder{
        font-weight: bolder;
    }
</style>

</body>