<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <title>Edit-Ship</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"  crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"  crossorigin="anonymous"></script>
</head>


<body>

<%
    Long id = (Long) request.getAttribute("id");
//        System.out.println(id);
%>


<%--@elvariable id="ship" type="com.example.shipreservationsystem.model.ShipDetails"--%>
<form:form class="form-group" cssStyle="margin: 100px" name="_method" value="PUT" action="/page/ships/details/update/${ship.sd_id}" modelAttribute="ship" >

    <div class="form-group row">
        <form:label path="sd_id" class="bolder" >Route ID : </form:label>
        <form:input class="form-control" id="sd_id" path="sd_id" type="text" disabled="true" value=""/> <br>
    </div> <br>

    <div class="form-group row">
        <form:label path="sname" class="bolder" >Source : </form:label>
        <form:input class="form-control" id="sname" path="sname" type="text" />
    </div> <br>

    <div class="form-group row">
        <form:label path="model" class="bolder" >Destination : </form:label>
        <form:input class="form-control" id="model" path="model" type="text"/>
    </div> <br>

    <div class="form-group row">
        <form:label path="capacity" class="bolder" >Distance : </form:label>
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