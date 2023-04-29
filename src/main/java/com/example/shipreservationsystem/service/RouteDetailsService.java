package com.example.shipreservationsystem.service;

import com.example.shipreservationsystem.model.RouteDetails;
import com.example.shipreservationsystem.model.RoutesShipsSchedulesDTO;
import com.example.shipreservationsystem.repos.RouteDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RouteDetailsService {

    private final RouteDetailsRepository routesRepo;

    public List<RouteDetails> getAllRouteDetails() {
        List<RouteDetails> routeDetailsList = routesRepo.findAll();
        System.out.println(routeDetailsList);
        log.debug(routeDetailsList.toString());
        return routeDetailsList;
    }

    public List<RoutesShipsSchedulesDTO> getRouteDetails(String dest, String src) {
//        routesRepo.findRouteDetailsBySourceAndDestination(src, dest);
//        List list = routesRepo.findScheduleForGivenSourceDestinationAndDateTime(src, dest);
        return null;
    }
}
