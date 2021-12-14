-- Inserting values of new users --
"insert into project.users values ('" + username + "', '" + password + "','" + firstName + "','" + lastName + "','" + email + "');"

-- Retrieve a book's information based on it's corresponding isbn --
"select * from project.book where isbn = '" + isbn + "';"

-- Retrieve a book's stock based on it's corresponding isbn --
"select stock from project.book where isbn = '" + isbn + "';"

-- Update a book's stock based on it's corresponding isbn --
"update project.book set stock = '" + stock + "' where isbn = '" + isbn + "';"

-- Inserting values of a book into the "book" relation based on the manager's input --
"insert into project.book values ('" + Integer.parseInt(arrayOfBookInfo[0]) + "', '" + Integer.parseInt(arrayOfBookInfo[1]) + "'," + Integer.parseInt(arrayOfBookInfo[2]) + "," + Integer.parseInt(arrayOfBookInfo[3]) + ", '" + arrayOfBookInfo[4] + "'," + Integer.parseInt(arrayOfBookInfo[5]) + "," + arrayOfBookInfo[6] + "'," + arrayOfBookInfo[7] + ");" 

-- Inserting values of an author into the "author" relation based on the manager's input --
"insert into project.author values ('" + arrayOfAuthorInfo[0] + "','" +arrayOfAuthorInfo[1] +"');"

-- Inserting values of a publisher into the "publisher" relation based on the manager's input --
"insert into project.publisher values ('" + arrayOfPublisherInfo[0] + "','" + arrayOfPublisherInfo[1]+ "', '" + Integer.parseInt(arrayOfPublisherInfo[2]) + "','" + Integer.parseInt(arrayOfPublisherInfo[3]) + "'," + Integer.parseInt(arrayOfPublisherInfo[4]) + "',"+Integer.parseInt(arrayOfPublisherInfo[5]) + "');"

-- Inserting values into the "writes" relation based on the manager's input --
"insert into project.writes values ('" + arrayOfAuthorInfo[0] + "', '"+arrayOfAuthorInfo[1]+"'," + arrayOfBookInfo[0] +");"

-- Filtering books by their title --
"select isbn, title, num_of_pages, price, genre, publisher_name from project.book where title = '" + title + "';" 

-- Filtering books by publisher name --
"select isbn, title, num_of_pages, price, genre, publisher_name from project.book where publisher_name  = '" + publisherName + "';"

-- Filtering books by genre --
"select isbn, title, num_of_pages, price,genre, publisher_name from project.book where genre  = '" + genre + "';"

-- Retrieve books based on a specific isbn --
"select isbn from project.book where isbn = '" + isbn + "';"

-- Retrieve a books stock based on its isbn --
"select stock from project.book where isbn = '" + isbn + "'"

-- Retrieve a books isbn, title, and price from it's corresponding isbn --
"select isbn, title, price from book where isbn = '" + isbn + "';"

-- Retrieve a user's basket id from their corresponding username --
"select basket_id from project.basket where user_name = " + username + "';"

-- Inserting values into the "addTo" relation --
"insert into addTo values (" + resultSet2.getString("basket_id") + "', '" + isbn + "',"  + x + "')"

-- Retrieving the users basket to check out based on their username --
"select * from project.checkout natural join project.basket where user_name = '" + username + "') ;"

-- Deleting a book based on it's isbn --
"delete from addTo where isbn = '" + isbn + "';"







