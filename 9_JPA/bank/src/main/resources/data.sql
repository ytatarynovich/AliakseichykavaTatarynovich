-- Bank
insert into Bank(name) values('Some bank');

-- Person
insert into Person(firstname, lastname) values('Ivan', 'Ivanov');
insert into Person(firstname, lastname) values('Petr', 'Petrov');
insert into Person(firstname, lastname) values('Ivan', 'Sidorov');

-- Account
insert into Account(bankid, personid, currency, amount) values(1, 1, 'BY', 1000);
insert into Account(bankid, personid, currency, amount) values(1, 2, 'EU', 2000);
insert into Account(bankid, personid, currency, amount) values(1, 3, 'USD', 3000);

-- CurrencyRate
insert into CurrencyRate (currency, rate) values('BY', 1);
insert into CurrencyRate (currency, rate) values('USD', 10000);
insert into CurrencyRate (currency, rate) values('EU', 14000);

-- Bank employees
insert into Employee(login, firstname, lastname, role, password) values('AdmLogin', 'Joe', 'Smith', 'ADMIN', '/H1iP5q/nKYDzs8oHyFFJg=='); -- AdmPass
insert into Employee(login, firstname, lastname, role, password) values('AccLogin', 'Tom', 'Jones', 'ACCOUNTANT', 'q7vpC+0AEUgqC4CbOQF/ZQ=='); -- AccPass