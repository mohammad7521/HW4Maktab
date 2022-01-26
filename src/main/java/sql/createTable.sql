CREATE TABLE IF NOT EXISTS admin(
    adminID serial primary key,
    username varchar (20),
    password varchar (20)

);

CREATE TABLE IF NOT EXISTS cinema(
    cinemaID serial primary  key,
    name varchar (20),
    username varchar (30) unique,
    password varchar (20),
    validation boolean
);

CREATE TABLE IF NOT EXISTS ticket (
    id serial primary key,
    ticketDate Date,
    startTime Time,
    endingTime Time,
    movie varchar(20),
    cinemaID int,
    foreign key (cinemaID) references cinema(CinemaID),
    quantity int ,
    price int
);

create table if not exists viewer
(
    viewerID  serial unique primary key,
    userName  varchar(20) unique,
    password  varchar(20),
    firstName varchar(20),
    lastName  varchar(20)
);


CREATE TABLE IF NOT EXISTS viewer_ticket(
    id serial primary key,
    ticketID int,
    viewerID int,
    quantity int,
    foreign key (ticketID) references ticket(id),
    foreign key (viewerID) references viewer(viewerID)

)



insert into viewer_ticket(ticketID, viewerID, quantity) values (?,?,?);
