<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <title>New-Schedule</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"  crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"  crossorigin="anonymous"></script>
</head>


<body>

<%
    //    Long id = (Long) request.getAttribute("id");
//        System.out.println(id);
    Long ship_id = (Long) request.getAttribute("ship_id");

%>


<%--@elvariable id="schedule" type="com.example.shipreservationsystem.model.ShipSchedule"--%>
<form:form class="form-group" cssStyle="margin: 100px" name="_method" value="PUT" action="/page/schedules/details/new/${ship_id}" modelAttribute="schedule" >

<%--    <div class="form-group row">--%>
<%--        <form:label path="sch_id" class="bolder" >Route ID : </form:label>--%>
<%--        <form:input class="form-control" id="sch_id" path="sch_id" type="text" disabled="true" value=""/> <br>--%>
<%--    </div> <br>--%>

    <div class="form-group row">
        <form:label path="journeyDate" class="bolder" >Source : </form:label>
        <form:input class="form-control" id="journeyDate" path="journeyDate" type="datetime-local" />
    </div> <br>

    <div class="form-group row">
        <form:label path="seatAvailability" class="bolder" >Destination : </form:label>
        <form:input class="form-control" id="seatAvailability" path="seatAvailability" type="text"/>
    </div> <br>

    <%--    <div class="form-group row">--%>
    <%--        <form:label path="capacity" class="bolder" >Distance : </form:label>--%>
    <%--        <form:input cssClass="form-control" id="capacity" path="capacity" type="text"/>--%>
    <%--    </div> <br>--%>

    <input type="submit" value="Submit">

</form:form>


<style>
    .bolder{
        font-weight: bolder;
    }
</style>

</body>