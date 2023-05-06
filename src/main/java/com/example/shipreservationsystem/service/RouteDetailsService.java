package com.example.shipreservationsystem.service;

import com.example.shipreservationsystem.model.RouteDetails;
import com.example.shipreservationsystem.model.ShipDetails;
import com.example.shipreservationsystem.repos.RouteDetailsRepo;
import com.example.shipreservationsystem.repos.ShipDetailsRepo;
import com.example.shipreservationsystem.ro.RouteTablesRO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class RouteDetailsService {

    private final RouteDetailsRepo routesRepo;
    private final ShipDetailsRepo shipsRepo;

    public List<RouteDetails> getAllRouteDetails() {
        List<RouteDetails> routeDetailsList = routesRepo.findAll();
        System.out.println(routeDetailsList);
//        routeDetailsList.parallelStream().forEach(rd -> rd.setShips(null));
        log.debug(routeDetailsList.toString());
        return routeDetailsList;
    }
    public RouteDetails getRouteDetailsById(Long id) {
        return routesRepo.findById(id).orElseThrow(() -> new RuntimeException("Route Details not Found !"));
    }

//    public List<RoutesShipsSchedulesDTO> getRouteDetails(String dest, String src) {
////        routesRepo.findRouteDetailsBySourceAndDestination(src, dest);
////        List list = routesRepo.findScheduleForGivenSourceDestinationAndDateTime(src, dest);
//        return null;
//    }

    public RouteDetails insertNewRouteDetails(RouteDetails routeDetails) {
        return routesRepo.save(routeDetails);
    }

    public RouteDetails updateRouteDetails(RouteDetails routeDetails, Long id) {
        RouteDetails oldRouteDetails = routesRepo.findById(id).orElseThrow(() -> new RuntimeException("Route Not Found Exception"));
        oldRouteDetails.setDistance(routeDetails.getDistance());
        oldRouteDetails.setSource(routeDetails.getSource());
        oldRouteDetails.setDestination(routeDetails.getDestination());
        return routesRepo.save(oldRouteDetails);
    }

    public RouteDetails deleteRouteDetails(Long id) {
        RouteDetails deleted = routesRepo.findById(id).orElseThrow();
        routesRepo.deleteById(id);
        return deleted;
    }







    public RouteDetails addShipToRoute(Long rId, Long sId) {
        RouteDetails routeDetails = routesRepo.findById(rId).orElseThrow(() -> new RuntimeException("Route Not Found Exception"));
        ShipDetails shipDetails = shipsRepo.findById(sId).orElseThrow(() -> new RuntimeException("Ship Not Found Exception"));



//      check if current ship has other routes, if not add or if it has other routes don't add throw error
        Set<RouteDetails> routes = shipDetails.getRoutes();
        boolean flag = true;
//        System.out.println("all routes for given ship id : " + routes);
        if( routes != null)
            if (! routes.isEmpty()){
    //            routes.forEach(System.out::println);
                for (RouteDetails rd : routes){
                    if (rd.getRoute_id() != rId) {
                        flag = false;
                        break;
                    }
                }
            }


//        System.out.println("\n flag : " + flag);

        if (flag){
            routeDetails.getShips().add(shipDetails);
            routesRepo.save(routeDetails);
        }else {
            throw new RuntimeException("Ship already mapped to other route");
        }
        return routeDetails;
    }


    public RouteDetails removeShipFromRoute(Long rId, Long sId) {
        RouteDetails routeDetails = routesRepo.findById(rId).orElseThrow();
        ShipDetails shipDetails = shipsRepo.findById(sId).orElseThrow();

        // 1st check whether the given ship is present in routes
//        boolean flag = false;
        Set<ShipDetails> ships = routeDetails.getShips();
//        if(! ships.isEmpty()){
//            for(ShipDetails sd : ships){
//                if(sd.getSd_id() == sId){
//                    flag = true;
//                    break;
//                }
//            }
//        }

        boolean contains = ships.contains(shipDetails);

        if(!contains){
            throw new RuntimeException("Ship is not assigned to this Route");
        }else{
            routeDetails.getShips().remove(shipDetails);
            routesRepo.save(routeDetails);
        }

        return routeDetails;
    }

    public List<List<String>> getRoutesForSrcAndDist(String source, String destination, LocalDateTime datetime) {
        List<List<String>> all = routesRepo.findAllBySourceAndDestinationAndTime(source, destination, datetime);
        return all;
    }
}
