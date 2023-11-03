create table users (
  id bigint not null auto_increment,
  name varchar(255) not null,
  address varchar(255) not null,
  primary key(id)
);

create table pracuser (
    id bigint not null auto_increment,
    userId varchar(100) not null,
    password varchar(255) not null,
    name varchar(255) not null,
    primary key(id)
);