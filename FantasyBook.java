package practice;

public class FantasyBook extends Book {
    private String world;
    FantasyBook(String title, String author, int year, String world) {
        super(title, author, year);
        this.world = world;
        setNumberOfBooks();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
