package practice;

import java.util.*;

public class Library {

   private static int numberOfBooks = 0;


   public void setNumberOfBooks() { numberOfBooks++; }  // Для підрахунку книг
   public int getNumberOfBooks() { return numberOfBooks; }

   public String toString() {
       return "Number of books: " + numberOfBooks;
   }



   public User registration() { // Для реєстрації користувача
       System.out.println("\n\n\t\t********Registration********\n");

       User user;
       Scanner scanner = new Scanner(System.in);
       String type;
       user = new Student("notExist", 0);

       while (true) { // Уточнюємо, чи є користувач вчителем, чи учнем
           System.out.print("You are: (s - student, t - teacher): ");
           type = scanner.nextLine();
           if (type.equals("s") || type.equals("t")) {
               break;
           } else { // Обробка некоректного вводу
               System.out.println("Wrong input!");
           }
        }

       if (type.equals("s")) { // Реєстрація студента

           System.out.print("Enter your name: ");
           String name = scanner.nextLine();
           int grade;

           try {
               System.out.print("Enter your grade: ");
               grade = scanner.nextInt();
               user = new Student(name, grade);
               System.out.println("\n"+user);
           } catch (InputMismatchException e) { // Обробка некоректного вводу
               System.out.println("If you don`t know, how to input a number, you are a first greader then!");
               grade = 1;
               user = new Student(name, grade);
               System.out.println("\n"+user);
           }

       } else if (type.equals("t")) { // Реєстрація вчителя

           System.out.print("Enter your name: ");
           String name = scanner.nextLine();
           System.out.print("Enter your subject: ");
           String subject = scanner.nextLine();
           user = new Teacher(name, subject);
           System.out.println("\n"+user);

       }

       return user;
   }

   // Перевіряємо, чи користувач зареєструвався
   public User login(ArrayList<User> users, User mainUser, Library mainLibrary) {

       Scanner scanner = new Scanner(System.in);
       System.out.println("\n\n\t\t******** Welcome to the library management system! ********\n");
       System.out.println("Are you a registered user? (y/n)");
       boolean registered = false;

       while(true) {


           System.out.print("Enter 'y' for yes and 'n' for no: ");
           String answer = scanner.nextLine();


           if(answer.equals("y")) { // Користувач відповів "так"

               System.out.print("Enter your name: ");
               String name = scanner.nextLine();


               for (User user : users) {

                   if (user.getName().equals(name)) { // Якщо користувач справді вже зареєстрований
                       System.out.println("You are already registered.\n");
                       registered = true;
                       mainUser = user;
                       break;

                   } else { // Якщо користувач збрехав
                       System.out.println("Please register.\n");
                   }
               }

               if (registered){ // Якщо користувач зареєстрований, виходимо з циклу
                   break;

               } else { // Якщо користувач не зареєстрований, змушуємо його зараєструватися
                   mainUser = mainLibrary.registration();
                   users.add(mainUser);
                   System.out.println("Thank you for the registration.\n");
                   break;
               }


           } else if(answer.equals("n")) { // Якщо користувач відповів "ні"
               System.out.println("Please register.\n");
               mainUser = mainLibrary.registration();
               users.add(mainUser);
               System.out.println("Thank you for the registration.\n");
               break;

           } else { // Обробка некоректного вводу
               System.out.println("Wrong input!");
           }

       }

       return mainUser;
   }


   public void findBook(ArrayList<Book> books, User user) { // Для позичування книги
       System.out.println("\n\n\t\t******** Book Borrowing ********\n");
       boolean breaker = false;

       while(!breaker) {

           Scanner scanner = new Scanner(System.in);
           System.out.print("Enter title or author of a book: "); // Просимо користувача ввести назву або
           String title = scanner.nextLine();                     // автора книги

           for (int i = 0; i < books.size(); i++) {

               // Якщо така книга є в бібліотеці
               if (books.get(i).getTitle().equals(title) || books.get(i).getAuthor().equals(title)) {

                   System.out.println(books.get(i).toString()+"\n");
                   System.out.print("Do you want to borrow this book? (y/n): ");
                   String answer = scanner.nextLine();

                   if (answer.equals("y")) { // Якщо користувач хоче позичити цю книгу

                       // Якщо книгу можна позичити
                       if (books.get(i).getAvailability() && user.getBorrowLimit() > 0) {
                           System.out.println("\nThank you for borrowing the book!\n");
                           user.setBorrowedBooks(books.get(i));
                           books.get(i).setAvailability(false);
                           user.setBorrowLimit(user.getBorrowLimit() - 1);
                           breaker = true;
                           break;

                           // Якщо книгу не можна позичити
                       } else if (!books.get(i).getAvailability()) {
                           System.out.println("Sorry, this book is not available.\n");
                           break;
                       }

                   } else if (answer.equals("n")) { // Якщо користувач не хоче позичати книгу

                       System.out.print("Do you want to find another book? (y/n): ");
                       String answer2 = scanner.nextLine();

                       if (answer2.equals("y")) { // Якщо користувач хоче знайти іншу книгу
                           break;

                       } else if(answer2.equals("n")) { // Якщо користувач не хоче знаходити іншу книгу
                           breaker = true;
                           break;
                       }
                   }
               } else if ( i == (books.size() - 1)) { // Якщо такої книги немає у бібліотеці
                   System.out.println("Book is not found.\n");
                   String answer3;

                   while(true) {
                       System.out.print("Do you want to find another book? (y/n): ");
                       answer3 = scanner.nextLine();

                       if(answer3.equals("y") || answer3.equals("n")) {
                           break;
                       }
                       else {
                           System.out.println("Wrong input!");
                       }

                   }



                   if (answer3.equals("y")) { // Якщо користувач хоче знайти іншу книгу
                       break;

                   } else if(answer3.equals("n")) { // Якщо користувач не хоче знаходити іншу книгу
                       breaker = true;
                       break;
                   }

               }
           }
       }
   }


   public void returnBook(ArrayList<Book> books, User user) { // Для повернення книг
       System.out.println("\n\n\t\t******** Book Returning ********\n");
       boolean breaker = false;

       while(!breaker) {
           System.out.print("Which book would you like to return? "); // Просимо ввести назву книги для повернення
           Scanner scanner = new Scanner(System.in);
           String title = scanner.nextLine();

           for (int i = 0; i < books.size(); i++) {

               // Якщо така книга є в бібліотеці та вона вже кимось позичена
               if (books.get(i).getTitle().equals(title) && !books.get(i).getAvailability()) {
                   if (user.getBorrowedBooks().contains(books.get(i))) {
                       System.out.println("Thank you for returning the book!\n");
                       user.setBorrowedBooks(books.get(i));
                       user.deleteBorrowedBooks(books.get(i));
                       books.get(i).setAvailability(true);
                       breaker = true;
                       break;
                   } else { // Якщо книга позичена іншим користувачем
                       System.out.println("You don`t have this book!");
                       break;
                   }

                   // Якщо книга ніким не позичена
               } else if (books.get(i).getTitle().equals(title) && books.get(i).getAvailability()) {
                   System.out.println("This book is still in the library!\n");
                   break;

               } else if(i == (books.size() - 1)) { // Якщо такої книги немає
                   System.out.println("Book is not found.\n");
                   break;
               }
           }

           while(true) {
               System.out.print("Do you want to return another book? (y/n): ");
               String answer2 = scanner.nextLine();
               if (answer2.equals("y")) {
                   break;
               } else if (answer2.equals("n")) {
                   breaker = true;
                   break;
               } else {
                   System.out.println("Wrong input!");
               }
           }


       }

   }

   public void bookList(ArrayList<Book> books) {
       System.out.println("\n\n\t\t******** Book List ********\n");
       for (Book book : books) {
           System.out.print(book.toString()+", ");
           if (book.getAvailability()) {
               System.out.print("Available\n");
           } else {
               System.out.print("Not available\n");
           }
       }
       System.out.println("\nThere are "+getNumberOfBooks()+" books in the library!");
   }
}
