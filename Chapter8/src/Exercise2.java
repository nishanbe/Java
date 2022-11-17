import java.math.BigInteger;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your big number: ");
        String s = in.nextLine();
        System.out.println("You entered : "+ s);
        BigInteger x = null;
        try {
            x = new BigInteger(s);
            System.out.println("Biginteger = " + x);
            double d = Double.parseDouble(s);
            System.out.println("Number = " + d);
        } catch(Exception e) {
            System.out.printf("ERROR");
            return;
        }
        System.out.print("Enter N: ");
        s = in.nextLine();
        System.out.println("You entered: " + s);
        int n = Integer.parseInt(s);
        BigInteger c3 = new BigInteger("3");
        BigInteger c1 = new BigInteger("1");
        for (int i = 0; i < n; i++){
            x = x.multiply(c3).add(c1);
            System.out.println("x = 3 * x + 1 = " + x);
        }
    }
}
