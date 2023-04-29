package com.example.shipreservationsystem.resource;

import com.example.shipreservationsystem.model.RouteDetails;
import com.example.shipreservationsystem.model.RoutesShipsSchedulesDTO;
import com.example.shipreservationsystem.service.RouteDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class RouteDetailsController {

    private final RouteDetailsService routeDetailsService;

    @GetMapping("/allroutedetails")
    @ResponseBody
    public ResponseEntity<List<RouteDetails>> allRoutes() {
        List<RouteDetails> allRouteDetails = routeDetailsService.getAllRouteDetails();
        return ResponseEntity.ok().body(allRouteDetails);
    }

    @RequestMapping(value = "/allroutesdetailspage", method = RequestMethod.GET)
    public String viewAllRoutes(Model model){
        model.addAttribute("routes", routeDetailsService.getAllRouteDetails());
        return "routes";
    }

    @GetMapping("/")
    public String viewSpecificPage(@RequestParam("page") String page){
        return page;
    }

    @GetMapping("/route-details")
    @ResponseBody
    public List<RoutesShipsSchedulesDTO> getRouteDetails(@RequestParam("datetime") Optional<LocalDateTime> dateTime,
                                                         @RequestParam("destination") Optional<String> dest,
                                                         @RequestParam("source") Optional<String> src
                                            ){

//                routeDetailsService.getRouteDetails(dest.orElse(""), src.orElse(""));
        return null;
    }

}
