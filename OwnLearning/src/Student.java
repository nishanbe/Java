public class Student {
    String firstName;
    String lastName;
    int expectedYearToGraduate;
    double gpa;
    String declaredMajor;

    public Student(String firstName, String lastName, int expectedYearToGraduate, double gpa, String declaredMajor){
        this.firstName = firstName;
        this.lastName = lastName;
        this.expectedYearToGraduate = expectedYearToGraduate;
        this.gpa = gpa;
        this.declaredMajor = declaredMajor;
    }

    public int incrementExpectedGraduationYear(){
        this.expectedYearToGraduate++;
        return this.expectedYearToGraduate;
    }
}
