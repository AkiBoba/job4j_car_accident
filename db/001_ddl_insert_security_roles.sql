insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');

insert into users (username, enabled, password, authority_id)
values ('root', true, '$2a$10$7Dmn3CsvGVQypngTCBDWVun2fIKlza/FUZ8Aen5qhNe/XGBs/hlhu',
(select id from authorities where authority = 'ROLE_ADMIN'));