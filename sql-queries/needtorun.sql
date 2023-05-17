
use projects;



# user admin

CREATE TABLE users (
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       enabled TINYINT NOT NULL DEFAULT 1,
                       PRIMARY KEY (username)
);

CREATE TABLE authorities (
                             username VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                             FOREIGN KEY (username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username
    on authorities (username,authority);


-- User user/pass
INSERT INTO users (username, password, enabled)
values ('admin', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a', 1);

INSERT INTO authorities (username, authority)
values ('admin', 'ROLE_USER');



delimiter $$

CREATE  TRIGGER `delete-routedetails-routes_ships`
    BEFORE DELETE ON `route-details`
    FOR EACH ROW
BEGIN
    DELETE FROM routes_ships rs WHERE rs.route_id = OLD.route_id;
END $$

delimiter ;



# route_ships


delimiter $$

CREATE TRIGGER `delete-routedetails-schedule_ships`
    AFTER DELETE ON `routes_ships`
    FOR EACH ROW
BEGIN
    DELETE from schedules_ships ss WHERE ss.ship_id = OLD.ship_id;
END $$

delimiter ;





# schedule_ships
delimiter $$

CREATE  TRIGGER `delete-routedetails-shipschedule`
    AFTER DELETE ON `schedules_ships`
    FOR EACH ROW
BEGIN
    DELETE FROM `ship-schedule` ss where ss.sch_id = OLD.schedule_id;
END $$

delimiter ;



# ship-schedule

delimiter $$

CREATE  TRIGGER `delete-routedetails-schedule_passengers`
    BEFORE DELETE ON `ship-schedule`
    FOR EACH ROW
BEGIN
    DELETE FROM schedules_passengers sp where sp.schedule_id = OLD.sch_id;
END $$

delimiter ;




# ship-details

delimiter $$

CREATE  TRIGGER `delete-shipdetails-routes_ships`
    BEFORE DELETE ON `ship-details`
    FOR EACH ROW
BEGIN
    DELETE FROM routes_ships rs where rs.ship_id = OLD.sd_id;
END $$

delimiter ;




