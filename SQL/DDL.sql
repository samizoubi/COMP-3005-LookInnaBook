-- Schema Project

CREATE schema project;

-- Entities

CREATE TABLE project.book (
    isbn 	                numeric(10,0),
    title 	                varchar(30),
    num_of_pages                numeric(4,0),
    price 	                numeric(5,2),
    publisher_percentage 	numeric(4,2),
    stock 	                integer,
    genre                       varchar(10),
    publisher_name              varchar(30),
    
    primary key(isbn),
    
    foreign key (publisher_name) referen
);

CREATE TABLE project.users (
    username 	varchar(15),
    pass_word 	varchar(20),
    first_name 	varchar(10),
    last_name 	varchar(20),
    email 	varchar(30),
    primary key(username)
);


CREATE TABLE project.address (
    address_id 	        numeric(5,0),
    street_number 	numeric(6,0),
    street_name         varchar(20),
    apartment_number 	numeric(6),
    city 	        varchar(20),
    province 	        varchar(20),
    country 	        varchar(20),
    postal_code         varchar(6),
    primary key(address_id)
);

CREATE TABLE project.publisher (
    publisher_name 	varchar(30),
    email	        varchar(30) UNIQUE,
    phone_number 	numeric(10,0) UNIQUE,
    account_number 	numeric(15,0) UNIQUE,
    address_id          numeric(5,0),
    primary key(publisher_name),
    foreign key (address_id) references project.address (address_id)
);


CREATE TABLE project.author (
    first_name 	varchar(10) unique,
    last_name 	varchar(20)unique,
    primary key(first_name,last_name)
);

CREATE TABLE project.basket (
    basket_id 	numeric(5,0) NOT NULL,
    user_name   varchar(15),
    primary key(basket_id),
    foreign key (user_name) references project.users(username)
);

CREATE TABLE project.order (
    order_number 	 numeric(10,0),
    date_of_order 	varchar(30),
    primary key(order_number)
);

-- Relations

CREATE TABLE project.writes (
    author_firstName 	varchar(20) unique,
    author_lastName 	varchar(40)unique,
    isbn    	        numeric(10,0),
    primary key(author_firstName, author_lastName, isbn),
    foreign key (author_firstName) references project.author (first_name),
    foreign key (author_lastName) references project.author (last_name),
    foreign key (isbn) references project.book (isbn) ON DELETE CASCADE

);


CREATE TABLE project.addTo (
    basket_id 	numeric(5,0),
    isbn 	numeric(10,0),
    quantity 	integer,

    primary key(basket_id, isbn),
    foreign key (basket_id) references project.basket (basket_id),
    foreign key (isbn) references project.book (isbn) 
);

CREATE TABLE project.checkout (
    basket_id 	    numeric(5,0),
    order_number    numeric(10,0),
	
    primary key (order_number),
    foreign key (basket_id) references project.basket (basket_id),
    foreign key (order_number) references project.order (order_number)
	);

CREATE TABLE project.orderTo (
    address_id 	    numeric(5,0),
    order_number    numeric(10,0),
    primary key (order_number,address_id),
    foreign key (address_id) references project.address (address_id),
    foreign key (order_number) references project.order (order_number)
);

CREATE TABLE project.shippingAddress (
    address_id 	    numeric(5,0),
    user_name       varchar(15),

    primary key (address_id),
    foreign key (address_id) references project.address (address_id),
    foreign key (user_name) references project.users (username)
);


CREATE TABLE project.billingAddress (
    address_id 	    numeric(5,0),
    user_name       varchar(15),
    primary key (address_id),
    foreign key (address_id) references project.address (address_id),
    foreign key (user_name) references project.users (username)
);














