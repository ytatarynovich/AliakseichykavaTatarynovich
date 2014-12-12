
-- Bank
create table Bank (id bigint IDENTITY(10,1) NOT NULL primary key, name varchar(50));

-- Person

-- CREATE SEQUENCE PERSON_PK_SEQ;

create table Person (id bigint IDENTITY(10,1) NOT NULL primary key, firstname varchar(50), lastname varchar(50));

-- Account
create table Account (id bigint IDENTITY(10,1) NOT NULL primary key, bankid integer, personid integer, currency varchar(3), amount decimal);

-- CurrencyRate
create table CurrencyRate (id bigint IDENTITY(10,1) NOT NULL primary key, currency varchar(3), rate decimal);

-- Bank employees
create table Employee (id bigint IDENTITY(10,1) NOT NULL primary key, login varchar(50), firstname varchar(50), lastname varchar(50), role varchar(50), password varchar(50));
