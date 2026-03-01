create table Authors(
	id INT auto_increment primary key,
    name VARCHAR(100) not null,
    country VARCHAR(50) not null
);

create table Customers(
	id INT auto_increment primary key,
    name VARCHAR(100) not null,
    email VARCHAR(100) not null,
    address VARCHAR(100) not null,
    gender ENUM("male", "female", "other") not null,
    phoneNumber CHAR(10) not null
);

create table Books(
	id INT auto_increment primary key,
    title VARCHAR(100) not null,
    price DECIMAL(10,2) not null,
    category VARCHAR(100) not null,
    ISBN VARCHAR(50) not null,
    author_id INT,
    constraint foreign key(author_id) references Authors(id)
);

create table Publisher(
	id INT auto_increment primary key,
    name VARCHAR(100) not null,
    country VARCHAR(50) not null
);

alter table Books
drop foreign key books_ibfk_1, drop column author_id;

create table Employees(
	id INT auto_increment primary key,
    name VARCHAR(100) not null,
    books_id INT,
    constraint foreign key(books_id) references Books(id),
    customers_id INT,
    constraint foreign key(customers_id) references Customers(id)
);

create table Account(
	id INT auto_increment primary key,
    userName VARCHAR(100) not null,
    password VARCHAR(100) not null
);

rename table account to accounts;

alter table Employees
add account_id INT, add constraint foreign key(account_id) references Accounts(id);

alter table Customers
add account_id INT, add constraint foreign key(account_id) references Accounts(id);

create table BooksInfo(
	book_id INT, customer_id INT, primary key(book_id, customer_id),
    constraint foreign key(book_id) references Books(id),
    constraint foreign key(customer_id) references Customers(id)
);

alter table BooksInfo
add column takenDate DATE not null, add column returnDate DATE not null;

create table EmployeesBooksInfo(
	book_id INT, employee_id INT, primary key(book_id, employee_id),
    constraint foreign key(book_id) references Books(id),
    constraint foreign key(employee_id) references Employees(id)
);

create table EmployeesCustomersInfo(
	customer_id INT, employee_id INT, primary key(customer_id, employee_id),
    constraint foreign key(customer_id) references Customers(id),
    constraint foreign key(employee_id) references Employees(id)
);