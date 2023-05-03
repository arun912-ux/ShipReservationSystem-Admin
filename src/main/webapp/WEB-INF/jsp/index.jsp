<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>


<body>

        <H1>Hello World</H1>
        <%
            out.print("index.jsp : Hello from servlet section");
        %>

        <%--@elvariable id="indexRo" type="com.example.shipreservationsystem.ro.IndexRO"--%>
        <form:form method="post" action="/page/routes/details/request" modelAttribute="indexRo">
            
            <form:input path="source" type="text" /> <br>
            <form:input path="destination" type="text"/> <br>
            <form:input path="datetime" type="datetime-local"/> <br>
            <input type="submit" value="Submit">

        </form:form>

</body>
</html>