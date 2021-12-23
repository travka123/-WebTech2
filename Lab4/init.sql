drop database if exists HOTEL;
create database if not exists HOTEL;

use HOTEL;

create table USERS
(
	id int primary key auto_increment,
    name varchar(50) not null,
    login varchar(50) not null,
	pass_hash varchar(100) not null,
	role varchar(50) not null
);

/* admin admin */
insert into USERS (name, login, pass_hash, role)
values ('admin', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin');

/* user user */
insert into USERS (name, login, pass_hash, role)
values ('user', 'user', 'ee11cbb19052e40b07aac0ca060c23ee', 'user');

create table ROOMS
(
	id int primary key auto_increment,
    hidden boolean not null,
    name varchar(50) not null,
    description varchar(50) not null,
    price int not null,
    beds_count int not null
);

insert into ROOMS (hidden, name, description, price, beds_count)
values (false, 'room1', 'desc1', 9100, 1);

insert into ROOMS (hidden, name, description, price, beds_count)
values (true, 'room2', 'desc2', 10400, 2);

insert into ROOMS (hidden, name, description, price, beds_count)
values (false, 'room3', 'desc3', 10400, 2);

insert into ROOMS (hidden, name, description, price, beds_count)
values (true, 'room4', 'desc4', 15500, 2);

insert into ROOMS (hidden, name, description, price, beds_count)
values (false, 'room5', 'desc5', 17600, 2);

create table RESERVATIONS
(
	id int primary key auto_increment,
    user_id int not null,
    room_id int not null,
    start date not null,
    end date not null
);

