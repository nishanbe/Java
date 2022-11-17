public class test9 {
    public static void main(String[] args){
        Student studentOne = new Student("David", "Smith", 2023,
                                           3.4, "Computer Science");
        Student studentTwo = new Student("John", "Lock", 2024,
                                           4.4, "Arts");
        System.out.println("1- " + studentOne);
        System.out.println("2- " + studentTwo);

        System.out.println(studentOne.firstName + " is expected to graduate in " + studentOne.expectedYearToGraduate);
        System.out.println(studentTwo.firstName + " is expected to graduate in " + studentTwo.expectedYearToGraduate);
        int studentOneIncrement = studentOne.incrementExpectedGraduationYear();
        System.out.println("Unfortunately " + studentOne.firstName + " will actually be graduating in "
                            + studentOneIncrement);

    }
}
