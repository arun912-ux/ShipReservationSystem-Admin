#  5th

use projects;






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
values ('admin',
        '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a',
        1);

INSERT INTO authorities (username, authority)
values ('admin', 'ROLE_USER');


























insert into `user-credentials` (id, user_name, pass_word) values (1, 'bnyles0', 'pYD4J4puq');
insert into `user-credentials` (id, user_name, pass_word) values (2, 'epurrier1', 'jIKqUH');
insert into `user-credentials` (id, user_name, pass_word) values (3, 'gscowcraft2', 'eLSpL3yd');
insert into `user-credentials` (id, user_name, pass_word) values (4, 'btickel3', 'cjmfLEzx1Efk');
insert into `user-credentials` (id, user_name, pass_word) values (5, 'fbortoletti4', 'MkrNrw');
insert into `user-credentials` (id, user_name, pass_word) values (6, 'egoodright5', 'jVTEXEEZX');
insert into `user-credentials` (id, user_name, pass_word) values (7, 'rdunkerley6', 'fxch4KD');
insert into `user-credentials` (id, user_name, pass_word) values (8, 'wcrumbie7', '87hza8qB');
insert into `user-credentials` (id, user_name, pass_word) values (9, 'rcastelain8', 'LyDWI2syYV');
insert into `user-credentials` (id, user_name, pass_word) values (10, 'sdebanke9', 'y12uljw');

