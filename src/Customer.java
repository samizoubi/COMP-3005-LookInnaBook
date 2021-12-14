import java.util.Scanner;
import java.sql.*;

public class Customer {

    Statement s;
    String username;
    Connection c;
    ResultSet resultSet1 = null;
    ResultSet resultSet2 = null;
    Scanner input = new Scanner(System.in);
    Scanner option = new Scanner(System.in);


    public Customer(Statement s, Connection c, String s1){
        this.s = s;
        this.c = c;
        username = s1;
    }

    public void mainMenu(){

        System.out.println("Enter 0 to find a book, 1 to purchase a book, 2 to proceed to checkout.");

        switch (option.nextInt()){
            case 0:
                searchBar();
                break;
            case 1:
                purchaseFunction();
                break;
            case 2:
                checkoutMethod(username);
                break;
        }
    }

    public void searchBar(){

        System.out.println("Enter 0 to search by ISBN, 1 to search by title, 2 to search by genre, 3 to search by publisher name, 4 to return to main menu");

        switch (option.nextInt()){
            case 0:
                System.out.println("Enter the book's ISBN");
                isbnFilter(option.nextInt());
                break;
            case 1:
                System.out.println("Enter the book's title");
                titleFilter(input.nextLine());
                break;
            case 2:
                System.out.println("Enter the book's genre");
                genreFilter(input.nextLine());
                break;
            case 3:
                System.out.println("Enter the publisher name");
                publisherNameFilter(input.nextLine());
                break;
            case 4:
                System.out.println("Main Menu: ");
                mainMenu();
                break;
        }
    }

    public void titleFilter(String title){
        try  {
            resultSet1 = s.executeQuery(
                        "select isbn, title, num_of_pages, price, genre, publisher_name from project.book where title = '" + title + "';");

            while(resultSet1.next()) {
                System.out.println("Isbn: " + resultSet1.getString("isbn"));
                System.out.println("Title: " + resultSet1.getString("title"));
                System.out.println("Number of Pages: " + resultSet1.getString("num_of_pages"));
                System.out.println("Price: $" + resultSet1.getString("price"));
                System.out.println("Genre:" + resultSet1.getString("genre"));
                System.out.println("Publisher: " + resultSet1.getString("publisher_name") + "\n");
            }

            System.out.println("Enter 0 to add to cart, 1 to continue browsing, 2 for the main menu");

            switch (option.nextInt()){
                case 0:
                    purchaseFunction();
                    break;
                case 1:
                    searchBar();
                    break;
                case 2:
                    mainMenu();
                    break;
            }
        }
        catch (SQLException e) {
            System.out.println("Sorry, we could not find what you are looking for " + e);
        }

    }

    public void isbnFilter(int isbn){

        try  {
            resultSet1 = s.executeQuery(
                    "select isbn, title, num_of_pages, price,genre, publisher_name from project.book where isbn = '" + isbn + "';");

            while(resultSet1.next()) {
                System.out.println("Isbn: " + resultSet1.getString("isbn"));
                System.out.println("Title: " + resultSet1.getString("title"));
                System.out.println("Number of Pages: " + resultSet1.getString("num_of_pages"));
                System.out.println("Price: $" + resultSet1.getString("price"));
                System.out.println("Genre:" + resultSet1.getString("genre"));
                System.out.println("Publisher: " + resultSet1.getString("publisher_name") + "\n");
            }
            System.out.println("Enter 0 to purchase book, 1 to continue browsing, 2 for main menu");
            switch (option.nextInt()){
                case 0:
                    purchaseFunction();
                    break;
                case 1:
                    searchBar();
                    break;
                case 2:
                    mainMenu();
                    break;
            }
        }
        catch (SQLException e) {
            System.out.println("Sorry, we could not find what you are looking for " + isbn);
        }
    }

    public void publisherNameFilter(String publisherName){

        try  {
            resultSet1 = s.executeQuery(
                    "select isbn, title, num_of_pages, price, genre, publisher_name from project.book where publisher_name  = '" + publisherName + "';");

            while(resultSet1.next()) {
                System.out.println("Isbn: " + resultSet1.getString("isbn"));
                System.out.println("Title: " + resultSet1.getString("title"));
                System.out.println("Number of Pages: " + resultSet1.getString("num_of_pages"));
                System.out.println("Price: $" + resultSet1.getString("price"));
                System.out.println("Genre:" + resultSet1.getString("genre"));
                System.out.println("Publisher: " + resultSet1.getString("publisher_name") + "\n");
            }
            System.out.println("Enter 0 to purchase book, 1 to continue browsing, 2 for main menu");
            switch (option.nextInt()){
                case 0:
                    purchaseFunction();
                    break;
                case 1:
                    searchBar();
                    break;
                case 2:
                    mainMenu();
                    break;
            }
        }
        catch (SQLException e) {
            System.out.println("Sorry, we could not find what you are looking for " + e);
        }
    }



    public void genreFilter(String genre){

        try  {
            resultSet1 = s.executeQuery(
                    "select isbn, title, num_of_pages, price,genre, publisher_name from project.book where genre  = '" + genre + "';");

            while(resultSet1.next()) {
                System.out.println("Isbn: " + resultSet1.getString("isbn"));
                System.out.println("Title: " + resultSet1.getString("title"));
                System.out.println("Number of Pages: " + resultSet1.getString("num_of_pages"));
                System.out.println("Price: $" + resultSet1.getString("price"));
                System.out.println("Genre:" + resultSet1.getString("genre"));
                System.out.println("Publisher: " + resultSet1.getString("publisher_name") + "\n");
            }
            System.out.println("Enter 0 to purchase book, 1 to continue browsing, 2 for main menu");
            switch (option.nextInt()){
                case 0:
                    purchaseFunction();
                    break;
                case 1:
                    searchBar();
                    break;
                case 2:
                    mainMenu();
                    break;
            }
        }
        catch (SQLException e) {
            System.out.println("Sorry, we could not find what you are looking for " + e);
        }
    }

    public void purchaseFunction() {

        System.out.println("What is the book ISBN?");
        Scanner s = new Scanner(System.in);
        String isbn = s.nextLine();
        System.out.println("How many would you like to purchase?");
        int x = s.nextInt();

        try {
            resultSet1 = this.s.executeQuery("select isbn from project.book where isbn = '" + isbn + "';");
            if(resultSet1.next()){
                resultSet1 = this.s.executeQuery("select stock from project.book where isbn = '" + isbn + "'");
                if(resultSet1.next()){
                    int y = resultSet1.getInt("stock");

                    if(x <= y && y != 0){
                        resultSet1 = this.s.executeQuery("select isbn, title, price from book where isbn = '" + isbn + "';");
                        if(resultSet1.next()) {
                            resultSet2 = this.s.executeQuery("select basket_id from project.basket where user_name = " + username + "';");
                            this.s.executeUpdate("insert into addTo values (" + resultSet2.getString("basket_id") + "', '" + isbn + "',"  + x + "')");
                        }
                    } else {
                        System.out.println("We do not have " + x + " of this book. " + " Only " + y + " available in stock");
                        purchaseFunction();
                    }
                }
            }else{
                System.out.println("Sorry, we could not find what you are looking for. ");
                purchaseFunction();
            }

            mainMenu();

        } catch (SQLException e) {
            System.out.println("Sorry, we could not find what you are looking for " + e);
        }
    }


    public void checkoutMethod(String username){
        try{
            resultSet1 = s.executeQuery("select * from project.checkout natural join project.basket where user_name = '" + username + "') ;");


            System.out.println("Enter 0 to continue shopping, 1 to remove items from cart");

            switch (option.nextInt()){
                case 0:
                    mainMenu();
                case 1:
                    System.out.println("Enter isbn of the book you would like to remove from cart");
                    String isbn = input.nextLine();
                    deleteFunction(isbn);
                    break;

            }

        }  catch (SQLException e) {
            System.out.println("Sorry, we could not find what you are looking for " + e);
        }
    }

    public void deleteFunction(String isbn){
        try{
           s.executeUpdate("delete from addTo where isbn = '" + isbn + "';");
           checkoutMethod(username);

        }  catch (SQLException e) {
            System.out.println("Sorry, we could not find what you are looking for " + e);
            checkoutMethod(username);
        }
    }


}
