-- Bank
insert into Bank(id, name) values(1, 'Some bank');

-- Person
insert into Person(id, firstname, lastname) values(1, 'Ivan', 'Ivanov');
insert into Person(id, firstname, lastname) values(2, 'Petr', 'Petrov');
insert into Person(id, firstname, lastname) values(3, 'Ivan', 'Sidorov');

-- Account
insert into Account(id, bankid, personid, currency, amount) values(1, 1, 1, 'BY', 1000);
insert into Account(id, bankid, personid, currency, amount) values(2, 1, 2, 'EU', 2000);
insert into Account(id, bankid, personid, currency, amount) values(3, 1, 3, 'USD', 3000);

-- CurrencyRate
insert into CurrencyRate (id, currency, rate) values(1, 'BY', 1);
insert into CurrencyRate (id, currency, rate) values(2, 'USD', 10000);
insert into CurrencyRate (id, currency, rate) values(3, 'EU', 14000);

-- Bank employees
insert into Employee(id, login, firstname, lastname, role, password) values(1, 'AdmLogin', 'Joe', 'Smith', 'ADMIN', '/H1iP5q/nKYDzs8oHyFFJg=='); -- AdmPass
insert into Employee(id, login, firstname, lastname, role, password) values(2, 'AccLogin', 'Tom', 'Jones', 'ACCOUNTANT', 'q7vpC+0AEUgqC4CbOQF/ZQ=='); -- AccPass