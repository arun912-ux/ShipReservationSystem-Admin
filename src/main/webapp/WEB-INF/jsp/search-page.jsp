<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <title>Search</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</head>


<body>

<%--        <H1>Hello World</H1>--%>
<%--        <%--%>
<%--            out.print("index.jsp : Hello from servlet section");--%>
<%--        %>--%>

<h1 style="text-align: center">Select Location and Time</h1>

<%--@elvariable id="indexRo" type="com.example.shipreservationsystem.ro.IndexRO"--%>
<form:form method="post" style="margin: 100px" action="/page/routes/details/request" modelAttribute="indexRo" cssClass="form">
    <div class="form-group row">
        <form:label path="source" class="bolder" >Source : </form:label>
        <form:input id="source" path="source" type="text" />
    </div> <br>

    <div class="form-group row">
        <form:label path="destination" class="bolder" >Destination : </form:label>
        <form:input id="destination" path="destination" type="text"/>
    </div> <br>

    <div class="form-group row">
        <form:label path="datetime" class="bolder" >Date & Time: </form:label>
        <form:input id="datetime" path="datetime" type="datetime-local"/>
    </div> <br>

    <input type="submit" value="Submit">

</form:form>

</body>

<style>
    .bolder{
        font-weight: bolder;
    }
</style>


</html>