
# route-details

CREATE DEFINER=`root`@`%` TRIGGER `delete-routedetails-routes_ships` BEFORE DELETE ON `route-details` FOR EACH ROW BEGIN
DELETE FROM routes_ships rs WHERE rs.route_id = OLD.route_id;
END



# route_ships

CREATE DEFINER=`root`@`%` TRIGGER `delete-routedetails-schedule_ships` AFTER DELETE ON `routes_ships` FOR EACH ROW BEGIN
DELETE from schedules_ships ss WHERE ss.ship_id = OLD.ship_id;
END




# schedule_ships

CREATE DEFINER=`root`@`%` TRIGGER `delete-routedetails-shipschedule` AFTER DELETE ON `schedules_ships` FOR EACH ROW BEGIN
DELETE FROM `ship-schedule` ss where ss.sch_id = OLD.schedule_id;
END



# ship-schedule


CREATE DEFINER=`root`@`%` TRIGGER `delete-routedetails-schedule_passengers` BEFORE DELETE ON `ship-schedule` FOR EACH ROW BEGIN
DELETE FROM schedules_passengers sp where sp.schedule_id = OLD.sch_id;
END




# ship-details

CREATE DEFINER=`root`@`%` TRIGGER `delete-shipdetails-routes_ships` BEFORE DELETE ON `ship-details` FOR EACH ROW BEGIN
DELETE FROM routes_ships rs where rs.ship_id = OLD.sd_id;
END




