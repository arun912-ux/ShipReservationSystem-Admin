<%@ page import="com.example.shipreservationsystem.model.ShipSchedule" %>
<%@ page import="com.example.shipreservationsystem.model.PassengerProfile" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <title>Schedule</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"  crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"  crossorigin="anonymous"></script>
</head>

<body>


    <%
        ShipSchedule schedule = (ShipSchedule) request.getAttribute("schedule");
        out.print("<h1>" + schedule.getSch_id() + "<br>");
        out.print("<h1>" + schedule.getJourneyDate() + "<h1><br>");
        out.print("Passengers List");
    %>


    <%
        Set<PassengerProfile> passengers = schedule.getPassengers();
        for (PassengerProfile passenger : passengers) {
            out.print(passenger.getPas_id() + "<br>");
            out.print(passenger.getName() + "<br>");
        }

    %>

</body>