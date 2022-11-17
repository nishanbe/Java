import textio.TextIO;
import java.util.Scanner;

public class ex_2_4 {
    public static void main(String[] args){
        System.out.print("How many 5 cents do you have? ");
        int fiveCents = TextIO.getInt();

        System.out.print("How many 10 cents do you have ");
        int tenCents = TextIO.getInt();

        System.out.print("How many 20 cents do you have ");
        int twentyCents = TextIO.getInt();

        System.out.print("How many 50 cents do you have ");
        int fiftyCents = TextIO.getInt();

        System.out.print("How many 1 dollars do you have ");
        int oneDollars = TextIO.getInt();

        System.out.print("How many 2 dollars cents do you have ");
        int twoDollars = TextIO.getInt();


//        System.out.println("You have " + fiveCents + " five cents");
//        System.out.println("You have " + tenCents + " ten cents");
//        System.out.println("You have " + twentyCents + " twenty cents");
//        System.out.println("You have " + fiftyCents + " fifty cents");
//        System.out.println("You have " + oneDollars + " one dollars");
//        System.out.println("You have " + twoDollars + " two dollars");

        double total = fiveCents * 0.05 + tenCents * 0.10 + twentyCents * 0.2 + fiftyCents * 0.5 + oneDollars + twoDollars * 2;
        System.out.println("You have a total of $" + total);
    }
}
