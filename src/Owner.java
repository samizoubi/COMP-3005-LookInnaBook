import java.util.Scanner;
import java.sql.*;


public class Owner {

    Statement s;
    Connection c;
    String username;
    ResultSet r = null;
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);



    public Owner(Statement s,Connection c, String user){
        this.s = s;
        this.c = c;
        username = user;
    }

    public void mainMenu(){

        System.out.println("Enter 0 to add books to the store, enter 1 to delete books from store");

        switch (sc1.nextInt()){
            case 0:
                System.out.println("Enter book isbn: ");
                int isbn = sc.nextInt();
                System.out.println("Enter amount to add: ");
                int stock = sc.nextInt();
                addBookFunction(isbn, stock);
                break;
            case 1:
                System.out.println("Enter book isbn: ");
                isbn = sc.nextInt();
                System.out.println("Enter amount to remove: ");
                stock = sc.nextInt();
                deleteFunction(isbn, stock);
                break;

        }
    }

    public void addBookFunction(int isbn, int books){

        ResultSet result1;

        try  {
            r = s.executeQuery(
                    "select * from project.book where isbn = '" + isbn + "';");

            if(r.next()){
                result1 = s.executeQuery("select stock from project.book where isbn = '" + isbn + "';");
                if(result1.next()){
                    int stock = result1.getInt("stock") + books;
                    s.executeUpdate("update project.book set stock = '" + stock + "' where isbn = '" + isbn + "';");
                }


            } else{
                System.out.println("\nPlease enter the book's title, isbn, number of pages, price, publisher earnings, stock, genre, and publisher name");
                System.out.println("\nSeparated by commas ','");
                String [] arrayOfBookInfo = sc.nextLine().split(",");
                s.executeUpdate("insert into project.book values ('" + Integer.parseInt(arrayOfBookInfo[0]) + "', '" + Integer.parseInt(arrayOfBookInfo[1]) + "'," + Integer.parseInt(arrayOfBookInfo[2]) + "," + Integer.parseInt(arrayOfBookInfo[3]) + ", '" + arrayOfBookInfo[4] + "'," + Integer.parseInt(arrayOfBookInfo[5]) + "," + arrayOfBookInfo[6] + "'," + arrayOfBookInfo[7] + ");" );

                System.out.println("\nWhat is the author of the books first name and last name?");
                System.out.println("\nSeparated by commas ','");
                String [] arrayOfAuthorInfo = sc.nextLine().split(",");
                s.executeUpdate("insert into project.author values ('" + arrayOfAuthorInfo[0] + "','" +arrayOfAuthorInfo[1] +"');");

                System.out.println("Enter publisher name, email, phone number, account number, address id");
                System.out.println("\nSeparated by commas ','");
                String [] arrayOfPublisherInfo = sc.nextLine().split(",");
                s.executeUpdate("insert into project.publisher values ('" + arrayOfPublisherInfo[0] + "','" + arrayOfPublisherInfo[1]+ "', '" + Integer.parseInt(arrayOfPublisherInfo[2]) + "','" + Integer.parseInt(arrayOfPublisherInfo[3]) + "'," + Integer.parseInt(arrayOfPublisherInfo[4]) + "',"+Integer.parseInt(arrayOfPublisherInfo[5]) + "');");

                s.executeUpdate("insert into project.writes values ('" + arrayOfAuthorInfo[0] + "', '"+arrayOfAuthorInfo[1]+"'," + arrayOfBookInfo[0] +");");
                mainMenu();
            }

        }
        catch (SQLException e) {
            System.out.println("Sorry, something went wrong. " + e);
            mainMenu();
        }



    }

    public void deleteFunction(int isbn, int deletedBooks){

        try{

            r = s.executeQuery("select stock from project.book where isbn = '" + isbn + "';");
            if(r.next()){
                int existingStock = r.getInt("Stock");
                if(existingStock >= deletedBooks) {
                    int newStock = existingStock - deletedBooks;
                    s.executeUpdate("update project.book set existingStock = " + newStock + ";");
                } else{
                    s.executeUpdate("update project.book set existingStock = " + 0 + ";");
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Sorry, something went wrong. " + e);
            mainMenu();
        }

    }





}
