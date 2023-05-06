
<%--TODO : show all possible routes-ships-schedules--%>


<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <title>Search Result</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"  crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"  crossorigin="anonymous"></script>
</head>




<body>

    <%
        List<List<String>> routes = (List<List<String>>) request.getAttribute("routes");

    %>

    <h1 style="text-align: center" >Search Results</h1>

    <table class="table table-bordered" style="margin: 20px">
        <thead>
            <tr>
                <th>Source</th>
                <th>Destination</th>
                <th>Ship Name</th>
                <th>Ship Model</th>
                <th>Date & Time</th>
            </tr>
        </thead>

        <tbody>

    <%
        out.print("<br>");

        for (List<String> route : routes) {

//            out.print(route); out.print("<br>");

            out.print("<tr>");

                out.print("<td>"); out.print(route.get(0));out.print("</td>");
                out.print("<td>");out.print(route.get(1));out.print("</td>");
                out.print("<td>"); out.print(route.get(2));out.print("</td>");
                out.print("<td>"); out.print(route.get(3));out.print("</td>");
                out.print("<td>"); out.print(route.get(4));out.print("</td>");

            out.print("</tr>");
        }


    %>

        </tbody>


    </table>

</body>

