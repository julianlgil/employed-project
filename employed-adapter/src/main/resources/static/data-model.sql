create database employed_db;
use employed_db;
create table employed (
                          id int not null auto_increment,
                          name varchar(100) null,
                          surname varchar(100) null,
                          document_type varchar(2) null,
                          document_number varchar(12) not null,
                          birthdate date,
                          hiring_date date,
                          position varchar(25) not null,
                          pay double,
                          primary key(id)
);
alter table employed
    add constraint uq_employed unique(document_type, document_number);
