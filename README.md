# COMP 3005 Look Inna Book

## 👥 Authors and Acknowledgement 
Sara Shikhhassan 101142208 and Sam Zoubi 101140949

## 🚀 General Usage Notes
This online book store application is console based. To start the program, download the Java files and use an operating system of your choice
that supports Java and connects to SQL to interact via text input (i.e IntelliJ IDEA Edu). 

## Design Decisions
This online book store was developed using JDBC. The program uses a relational database to store data and access data. Intailly the databse is empty and can be filled with values once a connection is made when running the program. Data can be inserted through the program, or an inserts.sql file is provided in this repository to insert data. The online book store is functional with three classes. Classes "Customer" and "Manager" are the two interfaces for the BookStore system and the Class "BookStore" is considered to be the main interface of the bookstore because it is where the main method for the program is located and is the programs intial state. 

Details on specfic functionalites of the system have been mentined in section 3 of the "Look Inna Book" Project Report document that is provided in this repository. When a user runs the program, they will be given the option to either sign in as an existing user or to create a new account in the system. Once the system has identified whether you the user are a "Manager" or a "Customer" you will be redirected to the corresponding interface and will be given directions through console outputs such as a Main Menu that contains multiple functionalities. Functionalities contain and are not limited to, searching for a book as a cutomer or removing a book (from the database) as a manager.





