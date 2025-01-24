package practice;

public class Student extends User{
    private int grade;

    Student(String name, int grade) {
        super(name);
        this.grade = grade;
        setBorrowLimit(7);
    }

    @Override
    public String toString() {
        return super.toString() + "\nGrade: " + this.grade + "\nBorrow limit: " + getBorrowLimit();
    }
}
