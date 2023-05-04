<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <title>New Route</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"  crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</head>


<body>


    <%--@elvariable id="route" type="com.example.shipreservationsystem.model.RouteDetails"--%>
    <form:form class="form-group" cssStyle="margin: 100px" value="POST" action="/page/routes/details/new" modelAttribute="route" >

    <%--    <div class="form-group row">--%>
    <%--        <form:label path="route_id" class="bolder" >Route ID : </form:label>--%>
    <%--        <form:input class="form-control" id="route_id" path="route_id" type="text" disabled="true" value=""/> <br>--%>
    <%--    </div> <br>--%>

        <div class="form-group row">
            <form:label path="source" class="bolder" >Source : </form:label>
            <form:input class="form-control" id="source" path="source" type="text" />
        </div> <br>

        <div class="form-group row">
            <form:label path="destination" class="bolder" >Destination : </form:label>
            <form:input class="form-control" id="destination" path="destination" type="text"/>
        </div> <br>

        <div class="form-group row">
            <form:label path="distance" class="bolder" >Distance : </form:label>
            <form:input cssClass="form-control" id="distance" path="distance" type="text"/>
        </div> <br>

        <input type="submit" value="Submit">

    </form:form>


<style>
    .bolder{
        font-weight: bolder;
    }
</style>

</body>