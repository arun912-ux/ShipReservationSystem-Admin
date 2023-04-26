<%@ page import="com.example.shipreservationsystem.model.RouteDetails" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>View Routes</title>
        <link rel="stylesheet" href="../css/routes.css">
    </head>

    <body>

        <h1>Hello World from JSP</h1>
        <%
            out.print("routes.jsp : Hello from servlet section </br>");

            List<RouteDetails> routes = (List<RouteDetails>) request.getAttribute("routes");

            for (RouteDetails route : routes) {
                    out.println(route);
                    out.println("</br>");
            }

        %>

<%--        <c:out value="Test from c:out"></c:out>--%>


    </body>


</html>