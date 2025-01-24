package practice;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public abstract class User {
    private String name;
    private int borrowLimit;
    private Set<Book> borrowedBooks;

    public void setBorrowLimit(int borrowLimit) {
        this.borrowLimit = borrowLimit;
    }
    public int getBorrowLimit() {
        return this.borrowLimit;
    }

    public String getName() {
        return name;
    }

    public void setBorrowedBooks(Book borrowedBooks) {
        this.borrowedBooks.add(borrowedBooks);
    }
    public void deleteBorrowedBooks(Book borrowedBooks) { this.borrowedBooks.remove(borrowedBooks); }

    public void printBorrowedBooks() {
        System.out.println("User borrowed books: ");
        for(Book book : this.borrowedBooks) {
            System.out.println(book.toString());
        }
    }

    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    User(String name) {
        this.name = name;
        this.borrowedBooks = new HashSet<>();

    }

    public String toString() {
        return "Name: " + this.name;
    }

}
