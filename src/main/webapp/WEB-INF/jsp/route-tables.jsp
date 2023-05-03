<%@ page import="java.util.List" %>
<%@ page import="com.example.shipreservationsystem.model.RouteDetails" %>
<%--<%@ page contentType="text/html; charset=UTF-8" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>

<body>


    <h1>ROUTES-TABLE</h1>


    <table>
        <thead>
            <tr>
                <th>Route ID</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Distance</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>

    <%
        List<RouteDetails> returnData = (List<RouteDetails>) request.getAttribute("routes");
        for (RouteDetails route : returnData) {
            String edit = "";
            String delete = "<input type=\"submit\" value=\"Delete\" onclick=\"onDelete(" + route.getRoute_id() + ")\"/>";
            edit = "<input type=\"submit\" value=\"Edit\" onclick=\"onEdit(" + route.customToString() + ", " + route.getRoute_id() + ")\"/>";
            out.print("<tr>");
            out.print("<td>"); out.print(route.getRoute_id()); out.print("</td>");
            out.print("<td>"); out.print(route.getSource()); out.print("</td>");
            out.print("<td>"); out.print(route.getDestination()); out.print("</td>");
            out.print("<td>"); out.print(route.getDistance()); out.print("</td>");
            out.print("<td>"); out.print(edit); out.print(delete); out.print("</td>");
            out.print("</tr>");
        }

    %>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/page/routes/details/new" >Create New Route</a>

    <script>
        function onDelete(id) {
            console.log(id)
            let b = confirm("Do you really want to delete");
            link = "${pageContext.request.contextPath}/page/routes/details/delete/"+id;
            console.log(link)
            if(b)
            fetch(link, {
                method : "DELETE"
            })
                .then((resp) => resp.json())
                .then((json) => console.log(json));
        }


        // need to rectify the error.
        function onEdit(route, id) {
            console.log("calling edit-page")
            console.log(route)
            link = "${pageContext.request.contextPath}/page/routes/details/update/";
            console.log(link)
            fetch(link, {
                method : "POST",
                body : JSON.stringify(route)

            })
        }
    </script>
</body>