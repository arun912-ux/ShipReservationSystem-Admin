package com.example.shipreservationsystem.resource.page;

import com.example.shipreservationsystem.model.ShipDetails;
import com.example.shipreservationsystem.model.ShipSchedule;
import com.example.shipreservationsystem.repos.SchedulesRepo;
import com.example.shipreservationsystem.resource.ShipController;
import com.example.shipreservationsystem.service.ScheduleService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/page/schedules")
public class SchedulePageController {

    private final ScheduleService scheduleService;
    private final SchedulesRepo schedulesRepo;
    private final ShipController shipController;



    // specific schedule id details. this shows passengers lislt
    @GetMapping("/details/{id}")
    public String viewSpecificSchedulePage(@PathVariable Long id, Model model){
        model.addAttribute("schedule", scheduleService.getScheduleById(id));
        return "schedule-details";
    }







    // update a route details with route_id
    @RequestMapping(value = "/details/update/{id}", method = {RequestMethod.PUT, RequestMethod.POST})
    public String updateScheduleDetails(Model model, @ModelAttribute("schedule") ShipSchedule schedule, @PathVariable Long id){
        ShipSchedule updated = scheduleService.updateScheduleDetails(schedule, id);
//        model.getAttribute("ship-id");
        return "redirect:/page/routes/details";
    }


    // when edit button is clicked, send the corresponding route details to edit page for editing and then
    // WE CAN CLICK THE UPDATE BUTTON IN EDIT PAGE and send that to above method for update.
    @GetMapping(value = "/details/update/{id}")
    public String showUpdatePage(@PathVariable Long id, Model model){
        ShipSchedule schedule = schedulesRepo.findById(id).orElseThrow(() -> new RuntimeException("Schedule ID not found"));
//        System.out.println("route update : " + route);
        model.addAttribute("schedule", schedule);
        return "edit-schedule";
    }














    // add a new route to table
    @GetMapping("/details/new/{ship_id}")
    public String newShipSchedulePage(@PathVariable Long ship_id, Model model, @ModelAttribute("schedule") ShipSchedule schedule, BindingResult bindingResult){
        System.out.println("newShipDetailsPage" + schedule);
        model.addAttribute("ship_id", ship_id);
        model.addAttribute("schedule", new ShipSchedule());
        return "new-schedule";
    }



    // add a new route to table
    @PostMapping("/details/new/{ship_id}")
    public String newShipSchedule(@PathVariable Long ship_id, @ModelAttribute("schedule") ShipSchedule schedule, BindingResult result, Model model){
        System.out.println(schedule);
        ShipSchedule saved = scheduleService.insertNewShipSchedule(schedule);
        System.out.println(saved);

        // now assign schedule_id to ship_id
        shipController.assignScheduleToShips(ship_id, saved.getSch_id());

        return "redirect:/page/routes/details";
    }















}
