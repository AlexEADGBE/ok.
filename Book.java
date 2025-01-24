package practice;

public abstract class Book extends Library {

    private String title;
    private String author;
    private int year;
    private boolean availability = true;

    public String getTitle() {
        return title;
    }
    public String getAuthor() { return author; }


    public void setAvailability(boolean availability) {this.availability = availability;}
    public boolean getAvailability() { return this.availability;}



    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.availability = availability;
    }

    @Override
    public String toString() {
        return this.title + ", " + this.author + ", " + this.year;
    }


}
