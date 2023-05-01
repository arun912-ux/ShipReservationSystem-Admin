package com.example.shipreservationsystem.resource.page;


import com.example.shipreservationsystem.service.RouteDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/routes")
public class RouteDetailsController {


    private final RouteDetailsService routeDetailsService;


    @RequestMapping(value = "/details-page", method = RequestMethod.GET)
    public String viewAllRoutes(Model model){
        model.addAttribute("routes", routeDetailsService.getAllRouteDetails());
        return "routes";
    }

    @GetMapping("/")
    public String viewSpecificPage(@RequestParam("page") String page){
        return page;
    }



}
