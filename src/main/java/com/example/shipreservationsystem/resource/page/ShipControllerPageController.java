package com.example.shipreservationsystem.resource.page;


import com.example.shipreservationsystem.model.RouteDetails;
import com.example.shipreservationsystem.model.ShipDetails;
import com.example.shipreservationsystem.repos.ShipDetailsRepo;
import com.example.shipreservationsystem.resource.RouteDetailsController;
import com.example.shipreservationsystem.service.ShipDetailsService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/page/ships")
public class ShipControllerPageController {

    private final ShipDetailsService shipDetailsService;
    private final ShipDetailsRepo shipDetailsRepo;
    private final RouteDetailsController routeDetailsController;


    // all ship details
    @GetMapping(value = "/details")
    public String getAllShipDetails(Model model) {
        List<ShipDetails> allShipDetails = shipDetailsService.getAllShipDetails();
        model.addAttribute("ships", allShipDetails);
        return "ships-table";

    }






    // add a new route to table
//    @GetMapping("/details/new")
//    public String newShipDetailsPage(Model model, @ModelAttribute("ship") ShipDetails ship, BindingResult bindingResult){
//        System.out.println("newShipDetailsPage");
//        model.addAttribute("ship", new ShipDetails());
//        return "new-ship";
//    }



    @GetMapping("/details/new")
    public String newShipDetailsPage(@PathParam("assign") String assign,
                                     @PathParam("route_id") Long route_id,
                                     Model model, @ModelAttribute("ship") ShipDetails ship, BindingResult bindingResult){
//        System.out.println("newShipDetailsPage");
        model.addAttribute("ship", new ShipDetails());
        if(assign != null && route_id != null){
            model.addAttribute(route_id);
            model.addAttribute(assign);
        }
        return "new-ship";
    }





    // add a new route to table
//    @PostMapping("/details/new")
//    public String newShipDetails(@ModelAttribute("ship") ShipDetails ship, BindingResult result, Model model){
//        System.out.println(ship);
//        ShipDetails saved = shipDetailsService.saveShipDetails(ship);
//        System.out.println(saved);
//        return "redirect:/page/ships/details";
//    }


    // add path params to call assignShipToRoute method
    @PostMapping("/details/new")
    public String newShipDetails(@PathParam("route_id") Long route_id, @ModelAttribute("ship") ShipDetails ship, BindingResult result, Model model){
        System.out.println(ship);
        ShipDetails saved = shipDetailsService.saveShipDetails(ship);
        System.out.println(saved);
        Long sd_id = saved.getSd_id();
        if(route_id != null){
            System.out.println("PathParams working : " + route_id);
            routeDetailsController.assignShipToRoute(route_id, sd_id);
        }
        return "redirect:/page/ships/details";
    }



    // update a route details with route_id
    @RequestMapping(value = "/details/update/{id}", method = {RequestMethod.PUT, RequestMethod.POST})
    public String updateShipDetails(Model model, @ModelAttribute("ship") ShipDetails ship, @PathVariable Long id){
        ShipDetails updated = shipDetailsService.updateShipDetails(ship, id);
        model.addAttribute("id", id);
        return "redirect:/page/ships/details";
    }


    // when edit button is clicked, send the corresponding route details to edit page for editing and then
    // WE CAN CLICK THE UPDATE BUTTON IN EDIT PAGE and send that to above method for update.
    @GetMapping(value = "/details/update/{id}")
    public String showUpdatePage(@PathVariable Long id, Model model){
        ShipDetails ship = shipDetailsRepo.findById(id).orElseThrow(() -> new RuntimeException("Ship ID not found"));
//        System.out.println("route update : " + route);
        model.addAttribute("ship", ship);
        return "edit-ship";
    }







}
