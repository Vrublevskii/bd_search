create schema db_for_isd;

create table db_for_isd.car(
	id int primary key auto_increment,
    name varchar (20) not null,
    color varchar(20),
    year int
);

insert into db_for_isd.car (name, color, year) values ('car1', 'red', 2000);
insert into db_for_isd.car (name, color, year) values ('car1', 'blue', 2013);
insert into db_for_isd.car (name, color, year) values ('car1', 'orange', 2017);
insert into db_for_isd.car (name, year) values ('car2', 2020);
insert into db_for_isd.car (name, color, year) values ('car3', 'blue', 1991);
insert into db_for_isd.car (name, color, year) values ('car4', 'orange', 1987);
insert into db_for_isd.car (name, color, year) values ('car4', 'lightblue', 1957);
insert into db_for_isd.car (name, color, year) values ('car4', 'blue', 1999);
insert into db_for_isd.car (name, color, year) values ('car5', 'red', 2002);
insert into db_for_isd.car (name, color, year) values ('car6', 'blue', 2016);
insert into db_for_isd.car (name, year) values ('car7', 2022);
insert into db_for_isd.car (name) value ('car7');
insert into db_for_isd.car (name) value ('car8');
insert into db_for_isd.car (name, color) values ('car9', 'blue');
insert into db_for_isd.car (name, color, year) values ('car10', 'yelow', 2001);
insert into db_for_isd.car (name, color, year) values ('car11', 'lightblue', 1998);

select * from db_for_isd.car;