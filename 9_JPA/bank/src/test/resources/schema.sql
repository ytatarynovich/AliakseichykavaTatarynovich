-- Only for tests
SET REFERENTIAL_INTEGRITY FALSE;

-- Bank
create table Bank (id bigint primary key, name varchar(50));

-- Person
create table Person (id bigint primary key, firstname varchar(50), lastname varchar(50));

-- Account
create table Account (id bigint primary key, bankid integer, personid integer, currency varchar(3), amount decimal);

-- CurrencyRate
create table CurrencyRate (id bigint primary key, currency varchar(3), rate decimal);

-- Bank employees
create table Employee (id bigint primary key, login varchar(50), firstname varchar(50), lastname varchar(50), role varchar(50), password varchar(50));
