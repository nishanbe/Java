import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class test4 {
    public static void main(String[] args) throws IOException {
//        int studentAge = 22;
        double studentGPA = 3.45;
        boolean perfectAttendance = true;

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your first name: ");
        String studentFirstName = scan.nextLine();

        System.out.println("Enter your last name: ");
        String studentLastName = scan.nextLine();

        System.out.println("Enter your age: ");
        int studentAge = scan.nextInt();

//        String studentFirstName = "Hammon";
//        String studentLastName = "Hammon";
        char studentFirstInitial = studentFirstName.charAt(0);
        char studentLastInitial = studentLastName.charAt(0);

        System.out.println(studentAge);
        System.out.println(studentGPA);
        System.out.println(studentFirstInitial);
        System.out.println(studentLastInitial);
        System.out.println(perfectAttendance);
        System.out.println("Hey " + studentFirstName + " " + studentLastName + ", you're " + studentAge + " and in a decade you'll be " + (studentAge + 10) );

        System.out.println("Say something: ");
        Scanner scando = new Scanner(System.in);
        String sasa = scando.nextLine();
        System.out.println("You just said, " + sasa);

//        File temp = new File("info.txt")
//        Scanner file = new Scanner(temp);

//        Scanner file = new Scanner(new File("info.txt"));
//        System.out.println(file.nextLine());
//        System.out.println(file.nextLine());
//        System.out.println(file.nextLine());


    }


}
