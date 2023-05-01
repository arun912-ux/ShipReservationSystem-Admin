package com.example.shipreservationsystem.resource.page;


import com.example.shipreservationsystem.service.RouteDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/routes")
public class RouteDetailsPageController {


    private final RouteDetailsService routeDetailsService;
    private Object RequestMethod;


    @GetMapping(value = "/details-page")
    public String viewAllRoutes(Model model){
        model.addAttribute("routes", routeDetailsService.getAllRouteDetails());
        return "routes";
    }

    @GetMapping("/")
    public String viewSpecificPage(@RequestParam("page") String page){
        return page;
    }



}
