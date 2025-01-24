package practice;

public class TechnicalBook extends Book{
    private String difficulty;
    TechnicalBook(String title, String author, int year, String difficulty) {
        super(title, author, year);
        this.difficulty = difficulty;
        setNumberOfBooks();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
