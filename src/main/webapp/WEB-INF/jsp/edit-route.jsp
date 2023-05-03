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


    <%--@elvariable id="indexRo" type="com.example.shipreservationsystem.model.RouteDetails"--%>
    <form:form method="post" action="/page/routes/details/update/" >

        <form:input path="route_id" type="text" disabled="true" value=""/> <br>
        <form:input path="source" type="text" /> <br>
        <form:input path="destination" type="text"/> <br>
        <form:input path="datetime" type="datetime-local"/> <br>
        <input type="submit" value="Submit">

    </form:form>

</body>