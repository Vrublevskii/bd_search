create schema db_for_isd;

create table db_for_isd.driver(
	id_driver int primary key auto_increment,
    name_driver varchar (20) not null,
    last_name_driver varchar (20)
);

insert into db_for_isd.driver (name_driver, last_name_driver) values ('Driver', 'Last');
insert into db_for_isd.driver (name_driver, last_name_driver) values ('Driver1', 'Last1');
insert into db_for_isd.driver (name_driver, last_name_driver) values ('Driver2', 'Last1');
insert into db_for_isd.driver (name_driver) values ('Driver3');
insert into db_for_isd.driver (name_driver, last_name_driver) values ('Driver4', 'Last3');
insert into db_for_isd.driver (name_driver, last_name_driver) values ('Driver4', 'Last4');

select * from db_for_isd.driver;

create table db_for_isd.car(
	id_car int primary key auto_increment,
    name varchar (20) not null,
    color varchar(20),
    year int,
    id_driver_fk int,
    constraint id_car_fk foreign key (id_driver_fk) references db_for_isd.driver (id_driver)
);

insert into db_for_isd.car (name, color, year, id_driver_fk) values ('car1', 'red', 2000, 1);
insert into db_for_isd.car (name, color, year, id_driver_fk) values ('car1', 'blue', 2013, 1);
insert into db_for_isd.car (name, color, year, id_driver_fk) values ('car1', 'orange', 2017, 1);
insert into db_for_isd.car (name, year, id_driver_fk) values ('car2', 2020, 2);
insert into db_for_isd.car (name, color, year, id_driver_fk) values ('car3', 'blue', 1991, 2);
insert into db_for_isd.car (name, color, year, id_driver_fk) values ('car4', 'orange', 1987, 3);
insert into db_for_isd.car (name, color, year, id_driver_fk) values ('car4', 'lightblue', 1957, 3);
insert into db_for_isd.car (name, color, year, id_driver_fk) values ('car4', 'blue', 1999, 3);
insert into db_for_isd.car (name, color, year, id_driver_fk) values ('car5', 'red', 2002, 4);
insert into db_for_isd.car (name, color, year, id_driver_fk) values ('car6', 'blue', 2016, 4);
insert into db_for_isd.car (name, year, id_driver_fk) values ('car7', 2022, 5);
insert into db_for_isd.car (name, id_driver_fk) value ('car7', 5);
insert into db_for_isd.car (name, id_driver_fk) value ('car8', 5);
insert into db_for_isd.car (name, color, id_driver_fk) values ('car9', 'blue', 5);
insert into db_for_isd.car (name, color, year, id_driver_fk) values ('car10', 'yellow', 2001, 6);
insert into db_for_isd.car (name, color, year, id_driver_fk) values ('car11', 'lightblue', 1998, 6);

select * from db_for_isd.car;