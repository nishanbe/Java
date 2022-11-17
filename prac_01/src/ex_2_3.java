import textio.TextIO;

import java.util.Scanner;

public class ex_2_3 {
    public static void main(String[] args){

        //Using TextIO
        System.out.print("Enter name: ");
        String name = TextIO.getln();

        System.out.println("Hello, " + name + ", nice to meet you!");

        //Using Scanner
        System.out.print("Enter name: ");
        Scanner scanThis = new Scanner(System.in);
        String yourName = scanThis.nextLine();

        System.out.println("Please enter you name");

        System.out.println("Hello, " + yourName + ", nice to meet you!");

    }
}
