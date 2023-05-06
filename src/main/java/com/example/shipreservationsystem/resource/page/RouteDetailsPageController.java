package com.example.shipreservationsystem.resource.page;


import com.example.shipreservationsystem.model.RouteDetails;
import com.example.shipreservationsystem.model.ShipDetails;
import com.example.shipreservationsystem.repos.RouteDetailsRepo;
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
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/page/routes")
public class RouteDetailsPageController {


    private final RouteDetailsService routeDetailsService;
    private final RouteDetailsRepo routeDetailsRepo;

    @GetMapping({"/", ""})
    public String homePage(Model model, @ModelAttribute("indexRo") IndexRO indexRo, BindingResult bindingResult){
//        System.out.println(indexRo);
        return "search-page";
    }

    // get all routes details from db

    @GetMapping(value = {"/details", "/details/"})
    public String viewAllRoutes(Model model){
        model.addAttribute("routes", routeDetailsService.getAllRouteDetails());
        return "route-tables";
    }



    @GetMapping("/details/{id}")
    public String viewSpecificPage(@PathVariable("id") Long id, Model model, BindingResult bindingResult){
        model.addAttribute("routeForId", routeDetailsService.getRouteDetailsById(id));
        return "routes";
    }



    // get routes details for a specific source and destination and datetime
    @PostMapping(value = "/details/request")
    public String getRouteDetails(Model model, @ModelAttribute("indexRo") IndexRO indexRo, BindingResult bindingResult){


        System.out.println(indexRo);
//        LocalDateTime dateTime = LocalDateTime.parse(data.get("datetime").toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        List<List<String>> routes =
                routeDetailsService.getRoutesForSrcAndDist(indexRo.getSource().orElse(""),
                                    indexRo.getDestination().orElse(""),
                                    indexRo.getDatetime().orElse(LocalDateTime.now()));
        model.addAttribute("routes", routes);
        System.out.println("returned map : "+ routes);
        System.out.println("returned Data from custom query : " + routes);
        return "search-result";

    }









    // add a new route to table
    @GetMapping("/details/new")
    public String newRouteDetailsPage(Model model, @ModelAttribute("route") RouteDetails route, BindingResult bindingResult){
        System.out.println("newRouteDetailsPage");
        model.addAttribute("route", new RouteDetails());
        return "new-route";
    }



    // add a new route to table
    @PostMapping("/details/new")
    public String newRouteDetails(@ModelAttribute("route") RouteDetails route, BindingResult result, Model model){
        System.out.println(route);
        RouteDetails saved = routeDetailsService.insertNewRouteDetails(route);
        System.out.println(saved);
        return "redirect:/page/routes/details";
    }













    // update a route details with route_id
    @RequestMapping(value = "/details/update/{id}", method = {RequestMethod.PUT, RequestMethod.POST})
    public String updateRouteDetails(Model model, @ModelAttribute("route") RouteDetails routeDetails, @PathVariable Long id){
        RouteDetails updated = routeDetailsService.updateRouteDetails(routeDetails, id);
        model.addAttribute("id", id);
        return "redirect:/page/routes/details";
    }


    // when edit button is clicked, send the corresponding route details to edit page for editing and then
    // WE CAN CLICK THE UPDATE BUTTON IN EDIT PAGE and send that to above method for update.
    @GetMapping(value = "/details/update/{id}")
    public String showUpdatePage(@PathVariable Long id, Model model){
        RouteDetails route = routeDetailsRepo.findById(id).orElseThrow(() -> new RuntimeException("Route ID not found"));
//        System.out.println("route update : " + route);
        model.addAttribute("route", route);
        return "edit-route";
    }


    // delete a route details by id
    @DeleteMapping("/details/delete/{id}")
    public String deleteRouteDetails(@PathVariable Long id){
        RouteDetails deletedRouteDetails = routeDetailsService.deleteRouteDetails(id);
        return "route-tables";
    }







    // show the ships for the selected routes in new page.

    @RequestMapping(value = "/details/ships/{id}", method = {RequestMethod.GET})
    public String showAllCorrespondingShips(@PathVariable Long id, Model model){
        RouteDetails route = routeDetailsRepo.findById(id).get();
        Set<ShipDetails> ships = route.getShips();
        model.addAttribute("route", route);
        model.addAttribute("ships", ships);
        return "route-ships";
    }











}
