package com.example.shipreservationsystem.resource.page;


import com.example.shipreservationsystem.model.RouteDetails;
import com.example.shipreservationsystem.model.ShipDetails;
import com.example.shipreservationsystem.repos.ShipDetailsRepo;
import com.example.shipreservationsystem.service.ShipDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/page/ships")
public class ShipControllerPageController {

    private final ShipDetailsService shipDetailsService;
    private final ShipDetailsRepo shipDetailsRepo;


    // all ship details
    @GetMapping(value = "/details")
    public String getAllShipDetails(Model model) {
        List<ShipDetails> allShipDetails = shipDetailsService.getAllShipDetails();
        model.addAttribute("ships", allShipDetails);
        return "ships-table";

    }






    // add a new route to table
    @GetMapping("/details/new")
    public String newShipDetailsPage(Model model, @ModelAttribute("ship") ShipDetails ship, BindingResult bindingResult){
        System.out.println("newShipDetailsPage");
        model.addAttribute("ship", new ShipDetails());
        return "new-ship";
    }



    // add a new route to table
    @PostMapping("/details/new")
    public String newShipDetails(@ModelAttribute("ship") ShipDetails ship, BindingResult result, Model model){
        System.out.println(ship);
        ShipDetails saved = shipDetailsService.saveShipDetails(ship);
        System.out.println(saved);
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
