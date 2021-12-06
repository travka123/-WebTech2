drop database if exists HOTEL;
create database if not exists HOTEL;

use HOTEL;

create table USERS
(
	id int primary key auto_increment,
    name varchar(50) not null,
    email varchar(50) not null,
	pass_hash varchar(100) not null,
	role varchar(50) not null
);

/* admin admin */
insert into USERS (name, email, pass_hash, role)
values ('admin', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin');

/* user user */
insert into USERS (name, email, pass_hash, role)
values ('user', 'user', 'ee11cbb19052e40b07aac0ca060c23ee', 'user');

create table ROOMS
(
	id int primary key auto_increment,
    hidden boolean not null,
    name varchar(50) not null,
    picture varchar(200) not null,
    price int not null,
    beds_count int not null
);

insert into ROOMS (hidden, name, picture, price, beds_count)
values (false, 'room1', '', 100, 2);

insert into ROOMS (hidden, name, picture, price, beds_count)
values (false, 'room2', '', 300, 4);

insert into ROOMS (hidden, name, picture, price, beds_count)
values (false, 'room3', '', 70, 1);

create table RESERVATIONS
(
	id int primary key auto_increment,
    user_id int not null,
    room_id int not null,
    start date not null,
    end date not null
);

