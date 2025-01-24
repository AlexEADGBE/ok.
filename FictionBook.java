package practice;

public class FictionBook extends Book{
   private String concept;
    FictionBook(String title, String author, int year, String concept) {
        super(title, author, year);
        this.concept = concept;
        setNumberOfBooks();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
