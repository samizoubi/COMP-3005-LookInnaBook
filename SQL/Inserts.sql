-- Inserting values into book relation --
insert into project.book values (14837, 'Deathly Hallows', 400, 30, 0.2, 102, 'Fantasy', 'J. K. Rowling' );
insert into project.book values (14838, 'Half-Blood Prince', 400, 30, 0.2, 102, 'Fantasy', 'Sara Shikh' );
insert into project.book values (14839, 'Order of the Phoenix', 400, 30, 0.2, 102, 'Fantasy', 'Sam Zoubi' );

-- Inserting values into "users" relation --
insert into project.users values ('samsara', 'kellykelly', 'Manager', 'Credentials', 'bookstore@gmail.com');
insert into project.users values ('myamah1', 'hisir!', 'Mya', 'Mahmoud', 'myamhamoud@outlook.ca');
insert into project.users values ('blieber2', 'ilovejustin', 'Justin', 'Bieber', 'justinbieber22@hotmail.com');
insert into project.users values ('tupac', 'loveyou', 'Tupac', 'Jackson', 'tpc@hotmail.com');

-- Inserting values into "address" relation --
insert into project.address values (93283, 516, 'Smith', '0', 'Ottawa', 'Ontario', 'K1T 0H7');
insert into project.address values (63784, 7883, 'Smith', '7B', 'Perth', 'Australia', '8Y7 J8J');
insert into project.address values (93024, 52, 'Sharjah', '12A', 'Ottawa', 'Dubai', 'AED 991');
insert into project.address values (11223, 92, 'SMT', '19', 'Mtl', 'Frankfurt', '893 JIS');

-- Inserting values into "publisher" relation --
insert into project.publisher values ('J.K', 'jk@gmail.com', 6132930221, 9096627384, 93283);
insert into project.publisher values ('Sara', 'sara@gmail.com', 6137283772, 1033627254, 63784);
insert into project.publisher values ('Sam', 'sam@gmail.com', 3436729953, 2830926615, 93024);

-- Inserting values into "author" relation --
insert into project.author values ('Lina', 'Hammar');
insert into project.author values ('Rima', 'Ghadban');
insert into project.author values ('Midia', 'Shikh Hassan');

-- Inserting values into "basket" relation --
insert into project.basket values (85942, 'blieber2');
insert into project.basket values (78351, 'myamah1');
insert into project.basket values (12345, 'tupac');

-- Inserting values into "order" relation --
insert into project.order values (7382588162, '09/10/2021');
insert into project.order values (84916629491, '18/12/2010');
insert into project.order values (1011420753, '20/06/2014');

-- Inserting values into "writes" relation --
insert into project.writes values ('Jackson', 'Smith', 14837);
insert into project.writes values ('Miley', 'Cyrus', 14838);
insert into project.writes values ('Ahmed', 'Ghantoor', 14839);

-- Inserting values into "addTo" relation --
insert into project.addTo values (85942, 14837, 5);
insert into project.addTo values (78351, 14838, 5);
insert into project.addTo values (12345, 14839, 5);

-- Inserting values into "checkout" relation --
insert into project.checkout values (89431, 6637263891);
insert into project.checkout values (82916, 3352901732);
insert into project.checkout values (78942, 3209886251);

-- Inserting values into "orderTo" relation --
insert into project.orderTo values (93283, 6637263891);
insert into project.orderTo values (63784, 3352901732);
insert into project.orderTo values (93024, 3209886251);

-- Inserting values into "shippingAddress" relation --
insert into project.shippingAddress values (93283, 'myamah1');
insert into project.shippingAddress values (63784, 'blieber2');
insert into project.shippingAddress values (93024, 'tupac');


-- Inserting values into "billingAddress" relation --
insert into project.billingAddress values (11223, 'tupac');

