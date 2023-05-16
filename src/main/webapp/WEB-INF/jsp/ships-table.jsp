<%@ page import="java.util.List" %>
<%@ page import="com.example.shipreservationsystem.model.RouteDetails" %>
<%@ page import="com.example.shipreservationsystem.model.ShipDetails" %>
<%--<%@ page contentType="text/html; charset=UTF-8" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <title>Ships-Table</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</head>

<body>



<br>


<div class="home">

    <a href="/" class="bolder">Home</a>
</div>



<h1 style="text-align: center">SHIPS-TABLE</h1>



<%--    <button><a href="/page/routes/details/update/{}" >Edit</a></button>--%>
<%--    <form style="display: inline" action="/page/routes/shpis/{}"><input type="submit" value="Select" /></form>--%>



<a href="${pageContext.request.contextPath}/page/ships/details/new" >Create New Ship</a>






<table style="margin: 20px" class="table table-bordered">
    <thead class="table-header">
    <tr>
        <th>Ship ID</th>
        <th>Ship Name</th>
        <th>Model Name</th>
        <th>Capacity</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>

    <%
        List<ShipDetails> returnData = (List<ShipDetails>) request.getAttribute("ships");
        for (ShipDetails route : returnData) {

            String edit =   "<form style=\"display: inline\" action=\"/page/ships/details/update/"+route.getSd_id()+"\"><input type=\"submit\" value=\"Edit\" /></form>";
            String delete = "<input type=\"submit\" value=\"Delete\" onclick=\"onDelete(" + route.getSd_id() + ")\"/>";
            String delete1 = "<form style=\"display: inline\" action=\"/page/ships/details/delete/"+route.getSd_id()+"\"><input type=\"submit\" value=\"DELETE\" /></form>";
            String select = "<form style=\"display: inline\" action=\"/page/ships/details/"+ route.getSd_id() + "\"><input type=\"submit\" value=\"Open\" /></form>";
            out.print("<tr>");
            out.print("<td>"); out.print(route.getSd_id()); out.print("</td>");
            out.print("<td>"); out.print(route.getSname()); out.print("</td>");
            out.print("<td>"); out.print(route.getModel()); out.print("</td>");
            out.print("<td>"); out.print(route.getCapacity()); out.print("</td>");
            out.print("<td>"); out.print(edit); out.print("  "); out.println(); out.print("  "); out.print(delete1); out.print("</td>");
            out.print("</tr>");
        }

    %>
    </tbody>
</table>

<%--    <a href="${pageContext.request.contextPath}/page/routes/details/new" >Create New Route</a>--%>

<script>
    function onDelete(id) {
        console.log(id)
        // let b = confirm("Do you really want to delete");
        link = "${pageContext.request.contextPath}/ships/details/delete/"+id;
        console.log(link)
        // if(b){
        //     console.log("boolean : " , b)
        // }
        fetch(link, {
            method : "DELETE"
        })
            .then((resp) => resp.json())
            .then((json) => console.log(json))
            .catch((error) => console.log(error));

        setTimeout(function() {
            // location.reload();
        }, 100);
    }


    // need to rectify the error.
    <%--function onEdit(route, id) {--%>
    <%--    console.log("calling edit-page")--%>
    <%--    console.log(route)--%>
    <%--    link = "${pageContext.request.contextPath}/page/routes/details/update/";--%>
    <%--    console.log(link)--%>
    <%--    fetch(link, {--%>
    <%--        method : "POST",--%>
    <%--        body : JSON.stringify(route)--%>

    <%--    })--%>
    <%--}--%>
</script>

<style>
    .bolder{
        font-weight: bolder;
    }

    .home {
        margin: 20px;
        align-content: end;
        align-items: end;
        text-align: right;
    }

    a{
        text-decoration-line: none;
    }
</style>

</body>