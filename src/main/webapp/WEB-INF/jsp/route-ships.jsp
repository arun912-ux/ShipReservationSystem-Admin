<%@ page import="com.example.shipreservationsystem.model.ShipDetails" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.example.shipreservationsystem.model.ShipSchedule" %>
<%@ page import="com.example.shipreservationsystem.model.RouteDetails" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <title>Route-Ships</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</head>



<body>

    <%
        RouteDetails route = (RouteDetails)request.getAttribute("route");

        out.print("<h1 style=\"text-align: center\">"); out.print(route.getSource()); out.print("  ----------->   "); out.print(route.getDestination()); out.print("</h1>");

        Set<ShipDetails> ships = (Set<ShipDetails>) request.getAttribute("ships");

    %>



    <table style="margin: 20px" class="table table-bordered">
        <thead class="table-header">
        <tr>
            <th>Ship ID</th>
            <th>Ship Name</th>
            <th>Ship Model</th>
<%--            <th>Schedule</th>--%>
<%--            <th>Seats</th>--%>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>



    <%

        for (ShipDetails ship : ships) {
            Set<ShipSchedule> schedules = ship.getSchedules();
//            System.out.println(schedules);

            String edit =   "<form style=\"display: inline\" action=\"/page/ships/details/update/"+route.getRoute_id()+"\"><input type=\"submit\" value=\"Edit\" /></form>";
            // remove route-ship association
            String delete = "<input type=\"submit\" value=\"Delete\" onclick=\"onDeleteShip(" + route.getRoute_id() + ',' + ship.getSd_id() + ")\"/>";
            String open = "<input type=\"submit\" value=\"Open\" onclick=\"changeScheduleDisplay()\">";
//            out.print("<tr>");
//            out.print("<td>"); out.print(ship.getSd_id()); out.print("</td>");
//            out.print("<td>"); out.print(ship.getSname()); out.print("</td>");
//            out.print("<td>"); out.print(ship.getModel()); out.print("</td>");

            // iterate over schedules
            out.print("<tr>");
                out.print("<td>"); out.print(ship.getSd_id()); out.print("</td>");
                out.print("<td>"); out.print(ship.getSname()); out.print("</td>");
                out.print("<td>"); out.print(ship.getModel()); out.print("</td>");
                out.print("<td>"); out.print("edit"); out.print("  "); out.print(open); out.print("  "); out.print(delete); out.print("</td>");
            out.print("</tr>");

            out.print("<tr id=\"schedule-row\" >");
            out.print("<td></td>");
            out.print("<td style=\"display:flex; justify-content:space-around\">");
            for (ShipSchedule schedule : schedules) {

                    String EDIT = "<form style=\"display: inline\" action=\"/page/schedules/details/update/"+schedule.getSch_id()+"\"><input type=\"submit\" value=\"Edit\" /></form>";
                    String DELETE = "<input type=\"submit\" value=\"Delete\" onclick=\"onDeleteSchedule(" + schedule.getSch_id() + ")\"/>";
//                    String OPEN = "<input type=\"submit\" value=\"OPEN\" action=\"/page/schedules/details/" + schedule.getSch_id() +"\" \"/>";
                    String OPEN = "<form style=\"display: inline\" action=\"/page/schedules/details/"+schedule.getSch_id()+"\"><input type=\"submit\" value=\"Open\" /></form>";
                    out.print("<div>");
                    out.print("<strong>Schedule ID :</strong>" + schedule.getSch_id()); out.print("<br>");
                    out.print("<strong>DateTime : </strong>" + schedule.getJourneyDate()); out.print("<br>");
                    out.print("<strong>Seats :</strong> " + schedule.getSeatAvailability() + "/" + ship.getCapacity()); out.print("<br>");

                    out.print(EDIT); out.print(OPEN); out.print(DELETE);
                    out.print("</div>");
//                    String newSchedule =   "<form style=\"display: inline\" action=\"/page/schedules/details/new/" + ship.getSd_id() + "\"><input type=\"submit\" value=\"New\" /></form>";
//                    out.print("<td>"); out.print(newSchedule); out.print("</td>");

            }

            String newSchedule =   "<form style=\"display: inline\" action=\"/page/schedules/details/new/" + ship.getSd_id() + "\"><input type=\"submit\" value=\"New\" /></form>";
            out.print("<td>"); out.print(newSchedule); out.print("</td>");
            out.print("</td>");
            out.print("</tr>");


//            out.print("<td>"); out.print(edit); out.print("  "); out.print(select); out.print("  "); out.print(delete); out.print("</td>");



//            out.print("</tr>");




        }
    %>

        </tbody>
    </table>


<%--    TODO : add new ship details page here and assign it to the route--%>


        <a href="/page/ships/details/new?assign=true&route_id=${route.getRoute_id()}">New Ship</a>



    <script>
        function changeScheduleDisplay(){
            let scheduleRow = document.getElementById("schedule-row");
            if(scheduleRow.style.display == 'none'){
                console.log(scheduleRow.style.display);
                scheduleRow.style.display="flex";
            }
            else{
                scheduleRow.style.display="none";
            }
        }


        function onDeleteSchedule(id) {
            console.log(id)
            // let b = confirm("Do you really want to delete");
            link = "${pageContext.request.contextPath}/schedules/details/delete/"+id;
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
                location.reload();
            }, 100);
        }


        function onDeleteShip(rid, sid){
            console.log(rid, sid);
            let link = "${pageContext.request.contextPath}/routes/details/" + rid + "/ship/" + sid;
            console.log(link);

            fetch(link, {
                method : "DELETE"
            })
                .then((resp) => resp.json())
                .then((json) => console.log(json))
                .catch((error) => console.log(error));
        }


    </script>
</body>