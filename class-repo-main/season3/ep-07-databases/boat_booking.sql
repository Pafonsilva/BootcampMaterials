drop database if exists boat_booking;
create database boat_booking;
use boat_booking;

create table sailors(
    sailor_id integer,
    sailor_name char(15),
    rating numeric(4,2),
    age int,
    primary key (sailor_id)
);

create table boats(
    boat_id integer,
    boat_name char(15),
    color char(15),
    primary key (boat_id)
);

create table reserves(
    sailor_id integer, boat_id integer, day date,
    primary key (boat_id, day),
    foreign key (sailor_id) references sailors(sailor_id),
    foreign key (boat_id) references boats(boat_id)
);

insert into sailors(sailor_id, sailor_name, rating, age) values (1, 'Manuel', 44.44, 24);
insert into sailors(sailor_id, sailor_name, rating, age) values (2, 'Nuno', 55.44, 23);
insert into sailors(sailor_id, sailor_name, rating, age) values (3, 'Soraia', 44.44, 44);
insert into sailors(sailor_id, sailor_name, rating, age) values (4, 'Manuela', 60.44, 26);
insert into sailors(sailor_id, sailor_name, rating, age) values (5, 'Rodrigo', 60.44, 28);
insert into sailors(sailor_id, sailor_name, rating, age) values (6, 'Ana', 20.44, 28);


insert into boats(boat_id, boat_name, color) values (1, 'Santana', 'red');
insert into boats(boat_id, boat_name, color) values (2, 'Titanic', 'white');
insert into boats(boat_id, boat_name, color) values (3, 'Mermaid', 'blue');
insert into boats(boat_id, boat_name, color) values (4, 'O Velejador', 'green');
insert into boats(boat_id, boat_name, color) values (5, 'O Esquecido', 'grey');
insert into boats(boat_id, boat_name, color) values (100, 'The One', 'yellow');


insert into reserves(sailor_id, boat_id, day) values (1,1, '2012-01-01');
insert into reserves(sailor_id, boat_id, day) values (1,2, '2013-02-01');
insert into reserves(sailor_id, boat_id, day) values (1,3, '2014-03-01');
insert into reserves(sailor_id, boat_id, day) values (2,4, '2015-04-01');
insert into reserves(sailor_id, boat_id, day) values (3,1, '2011-05-01');
insert into reserves(sailor_id, boat_id, day) values (5,100, '2010-06-01');
insert into reserves(sailor_id, boat_id, day) values (6,100, '2012-06-01');
