import java.util.Scanner;
import java.sql.*;
// complete

public class Bookstore {


    public static void main(String[] args){

        // Login: check to see if a user is a customer (new or existing) or bookstore owner

        Scanner login = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        System.out.println("Hello! Welcome to Look Inna Book.");
        System.out.println("Are you a new or existing user?");
        System.out.println("Enter 1 if you are an existing user ");
        System.out.println("Enter 2 to create a new user account");


        switch (input.nextInt()){
            case 0:
                System.out.println("Username: \n");
                String username = login.nextLine();
                System.out.println("Password: \n");
                String password = login.nextLine();
                loginSystem(username, password);
                break;
            case 1:
                createNewCustomer();
                break;
        }
    }

    public static void loginSystem(String username, String password){ // creates a new user, or logs in to an existing profile (customer/ manager)


        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "kellykelly");
             Statement s = c.createStatement();
        ) {

            if(username.equals("samsara")){ //if it's a manager (Managers are given set credentials)
                System.out.println("Welcome back, manager. \n");
                Owner manager = new Owner(s, c, username);
                manager.mainMenu();
            }
            else { // otherwise it's not a manager user, so customer
                System.out.println("Welcome Customer! \n");
                Customer customer = new Customer(s, c, username);
                customer.mainMenu();
            }

        } catch (Exception e){
                System.out.println("Exception found: " + e);
        }

    }


    public static void createNewCustomer() {
        Scanner input = new Scanner(System.in);
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "kellykelly");
             Statement s = connection.createStatement();
        ) {
            try {
                System.out.println("Enter a username:");
                String username = input.nextLine();
                System.out.println("Enter a password:");
                String password = input.nextLine();
                System.out.println("Enter first name:");
                String firstName = input.nextLine();
                System.out.println("Enter last name");
                String lastName = input.nextLine();
                System.out.println("Enter email address:");
                String email = input.nextLine();

                s.executeUpdate("insert into project.users values ('" + username + "', '" + password + "','" + firstName + "','" + lastName + "','" + email + "');");
                System.out.println("\nWelcome " + username + "to Look Inna Book. Enjoy your shopping!\n");
                loginSystem(username, password); // calling the login system to authenticate the credentials

            } catch (SQLException e) {
                System.out.println("Sorry, something went wrong. " + e);
            }

        } catch (Exception e){
            System.out.println("Exception found: " + e);
        }


    }



}
