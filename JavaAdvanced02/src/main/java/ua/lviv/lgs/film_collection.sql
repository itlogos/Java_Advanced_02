drop database if exists film_collection;
create database film_collection char set utf8;

use film_collection;

create table user (
    id int not null primary key auto_increment,
    first_name varchar(45) not null,
    last_name varchar(45) not null,
    email varchar(50) not null,
    password varchar(10) not null,
    access_level varchar(15) not null
);

create table film (
	id int not null primary key auto_increment,
    title varchar(45) not null,
    description text not null,
    date date not null,
    price double not null
);

create table subscribe (
	id int not null primary key auto_increment,
    user_id int not null,
    film_id int not null,
    subscribe_status boolean default true,
    subscribe_date date not null,
    subscribe_period int not null
);

alter table subscribe add foreign key (user_id) references user (id);
alter table subscribe add foreign key (film_id) references film (id);