<%@ page import="com.example.shipreservationsystem.model.ShipDetails" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.example.shipreservationsystem.model.ShipSchedule" %>
<%@ page import="com.example.shipreservationsystem.model.RouteDetails" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <title>Title</title>
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

            String edit =   "<form style=\"display: inline\" action=\"/page/routes/details/update/"+route.getRoute_id()+"\"><input type=\"submit\" value=\"Edit\" /></form>";
            String delete = "<input type=\"submit\" value=\"Delete\" onclick=\"onDelete(" + route.getRoute_id() + ")\"/>";
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
                out.print("<td>"); out.print(edit); out.print("  "); out.print(open); out.print("  "); out.print(delete); out.print("</td>");
            out.print("</tr>");

            out.print("<tr id=\"schedule-row\" style=\"display:none\">");
            out.print("<td></td>");
            out.print("<td style=\"display:flex; justify-content:space-around\">");
            for (ShipSchedule schedule : schedules) {

                    out.print("<div>");
                    out.print(schedule.getSch_id()); out.print("<br>");
                    out.print(schedule.getJourneyDate()); out.print("<br>");
                    out.print(schedule.getSeatAvailability() + "/" + ship.getCapacity()); out.print("<br>");
                    out.print("EDIT    "); out.print("   DELETE");
                    out.print("</div>");

            }
            out.print("</td>");
            out.print("</tr>");


//            out.print("<td>"); out.print(edit); out.print("  "); out.print(select); out.print("  "); out.print(delete); out.print("</td>");



//            out.print("</tr>");




        }
    %>

        </tbody>
    </table>



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
    </script>
</body>