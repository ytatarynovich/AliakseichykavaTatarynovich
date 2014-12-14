
-- Bank
create table IF NOT EXISTS Bank (id bigint IDENTITY(10,1) NOT NULL primary key, name varchar(50));

-- Person

create table IF NOT EXISTS Person (id bigint IDENTITY(10,1) NOT NULL primary key, firstname varchar(50), lastname varchar(50));

-- Account
create table IF NOT EXISTS Account (id bigint IDENTITY(10,1) NOT NULL primary key, bankid integer, personid integer, currency varchar(3), amount decimal);

-- CurrencyRate
create table IF NOT EXISTS CurrencyRate (id bigint IDENTITY(10,1) NOT NULL primary key, currency varchar(3), rate decimal);

-- Bank employees
create table IF NOT EXISTS Employee (id bigint IDENTITY(10,1) NOT NULL primary key, login varchar(50), firstname varchar(50), lastname varchar(50), role varchar(50), password varchar(50));
