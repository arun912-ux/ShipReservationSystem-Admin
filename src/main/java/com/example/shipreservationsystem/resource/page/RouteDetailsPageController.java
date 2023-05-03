package com.example.shipreservationsystem.resource.page;


import com.example.shipreservationsystem.model.RouteDetails;
import com.example.shipreservationsystem.ro.IndexRO;
import com.example.shipreservationsystem.ro.ResponseRO;
import com.example.shipreservationsystem.ro.RouteTablesRO;
import com.example.shipreservationsystem.service.RouteDetailsService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/page/routes")
public class RouteDetailsPageController {


    private final RouteDetailsService routeDetailsService;

    @GetMapping("/")
    public String homePage(Model model, @ModelAttribute("indexRo") IndexRO indexRo, BindingResult bindingResult){
//        System.out.println(indexRo);
        return "index";
    }

    // get all routes details from db

    @GetMapping(value = "/details")
    public String viewAllRoutes(Model model){
        model.addAttribute("routes", routeDetailsService.getAllRouteDetails());
        return "route-tables";
    }



    @GetMapping("/details/{id}")
    public String viewSpecificPage(@PathParam("id") Long id, Model model, BindingResult bindingResult){
        model.addAttribute("routeForId", routeDetailsService.getRouteDetailsById(id));
        return "routes";
    }



    // get routes details for a specific source and destination and datetime
    @PostMapping(value = "/details/request")
    public String getRouteDetails(Model model, @ModelAttribute("indexRo") IndexRO indexRo, BindingResult bindingResult){


        System.out.println(indexRo);
//        LocalDateTime dateTime = LocalDateTime.parse(data.get("datetime").toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        List<Object> routes =
                routeDetailsService.getRoutesForSrcAndDist(indexRo.getSource().orElse(""),
                                    indexRo.getDestination().orElse(""),
                                    indexRo.getDatetime().orElse(LocalDateTime.now()));
        model.addAttribute("returnData", routes);
        System.out.println("returned Data from custom query : " + routes);
        return "route-tables";

    }









    // add a new route to table
    @GetMapping("/details/new")
    public String newRouteDetails(Model model){
//        System.out.println(routeDetails);
//        RouteDetails saved = routeDetailsService.insertNewRouteDetails(routeDetails);
//        System.out.println(saved);
        return "new-route";
    }
















    // update a route details with route_id
    @PutMapping("/details/update/{id}")
    public String updateRouteDetails(Model model, @ModelAttribute("route") RouteDetails routeDetails, @PathVariable Long id){
        RouteDetails updated = routeDetailsService.updateRouteDetails(routeDetails, id);
        model.addAttribute("id", id);
        return "edit-route";
    }


    // when edit button is clicked, send the corresponding route details to edit page for editing and then
    // WE CAN CLICK THE UPDATE BUTTON IN EDIT PAGE and send that to above method for update.
    @PostMapping(value = "/details/update/", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public String showUpdatePage(Model model, @RequestBody RouteDetails route){
        model.addAttribute("route", route);
        return "edit-route";
    }


    // delete a route details by id
    @DeleteMapping("/details/delete/{id}")
    public String deleteRouteDetails(@PathVariable Long id){
        RouteDetails deletedRouteDetails = routeDetailsService.deleteRouteDetails(id);
        return "redirect:/route-tables";

    }



}
