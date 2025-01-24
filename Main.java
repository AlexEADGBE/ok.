package practice;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>(); // Створюємо масив користувачів
        Librarian librarian = new Librarian("Andrew"); // Створюємо бібліотекаря
        users.add(librarian);
        User mainUser = librarian;

        Library mainLibrary = new Library(); // Створюємо бібліотеку



        // Створюємо декілька книг
        FantasyBook fantasyBook1 = new FantasyBook("The Lord of the Rings", "John Tolkien",
                    1954, "Middle-earth");
        FantasyBook fantasyBook2 = new FantasyBook("Harry Potter and the Philosopher's Stone", "J.K. Rowling",
                  1997, "World of wizards");
        FantasyBook fantasyBook3 = new FantasyBook("A Song of Ice and Fire: A Game of Thrones",
                "George R.R. Martin", 1996, "Westeros");


        FictionBook sciFiBook1 = new FictionBook("1984", "George Orwell", 1949,
                "Totalitarian control systems");
        FictionBook sciFiBook2 = new FictionBook("Dune", "Frank Herbert", 1965,
                "Interplanetary travel and spice-based mind enhancement");
        FictionBook sciFiBook3 = new FictionBook("Childhood's End", "Arthur C. Clarke", 1953,
                "Contact with a highly advanced alien civilization");


        TechnicalBook technicalBook1 = new TechnicalBook("Clean Code", "Robert Martin",
                2008, "Intermediate");
        TechnicalBook technicalBook2 = new TechnicalBook("Introduction to Algorithms",
                "Thomas Cormen, Charles Leiserson, Ronald Rivest, Clifford Stein", 1990, "Expert");
        TechnicalBook technicalBook3 = new TechnicalBook("Java: The Complete Reference",
                "Herbert Schildt", 2018, "Beginner");

        // Додаємо книги у масив
        ArrayList<Book> books = new ArrayList<>();
        books.add(fantasyBook1);
        books.add(fantasyBook2);
        books.add(fantasyBook3);
        books.add(sciFiBook1);
        books.add(sciFiBook2);
        books.add(sciFiBook3);
        books.add(technicalBook1);
        books.add(technicalBook2);
        books.add(technicalBook3);


        mainUser = mainLibrary.login(users, mainUser, mainLibrary);

        Scanner scanner = new Scanner(System.in);
        boolean breaker = false;



        while(!breaker) {
            System.out.println("\n\n\t\t******** Main Menu ********\n");
            System.out.println("What are you want to do?");
            System.out.println("'b' for borrowing a book\n'r' for returning a book\n" +
                    "'l' for listing all books\n'q' for quitting\n");
            System.out.print("Your answer is: ");
            String choice = scanner.nextLine();


            switch (choice) {

                case ("b"):
                    if (mainUser.getBorrowLimit() != 0) {
                        mainLibrary.findBook(books, mainUser);
                    } else {
                        System.out.println("Sorry, you have reached the limit of books you can borrow!");
                    }
                    break;

                case ("r"):
                    mainLibrary.returnBook(books, mainUser);
                    break;
                case("l"):
                    mainLibrary.bookList(books);
                    break;
                case("q"):
                    System.out.println("\n\n\t\t******** Goodbye! ********\n");
                    breaker = true;
                    break;
                default:
                    System.out.println("Durak?");
                    break;
            }
        }


















    }



}
