<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>


<body>

<%
    int id = (int) request.getAttribute("id");
%>


<%--@elvariable id="routeDetails" type="com.example.shipreservationsystem.model.RouteDetails"--%>
<form:form method="post" action="/routes/details/new/" modelAttribute="routeDetails">

<%--    <form:input path="route_id" type="text" disabled="true" value=""/> <br>--%>
    <form:input path="source" type="text" /> <br>
    <form:input path="destination" type="text"/> <br>
    <form:input path="distance" type="text" /> <br>
    <input type="submit" value="Create New">

</form:form>


<%--write script for fetch action to RestController new endpoint--%>

<script>

</script>

</body>