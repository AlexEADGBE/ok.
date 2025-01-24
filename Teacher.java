package practice;

public class Teacher extends User{
    private String subject;

    Teacher(String name, String subject ) {
        super(name);
        this.subject = subject;
        setBorrowLimit(30);
    }

    @Override
    public String toString() {
        return super.toString() + "\nSubject: " + this.subject + "\nBorrow limit: " + getBorrowLimit();
    }
}
