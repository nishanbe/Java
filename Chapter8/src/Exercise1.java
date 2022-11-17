import java.util.Scanner;

/*
Write a program that uses the following subroutine, from Subsection 8.3.3, to solve equations specified by the user.

 * Returns the larger of the two roots of the quadratic equation
 * A*x*x + B*x + C = 0, provided it has any roots.  If A == 0 or
 * if the discriminant, B*B - 4*A*C, is negative, then an exception
 * of type IllegalArgumentException is thrown.

static public double root( double A, double B, double C )
        throws IllegalArgumentException {
        if (A == 0) {
        throw new IllegalArgumentException("A can't be zero.");
        }
        else {
        double disc = B*B - 4*A*C;
        if (disc < 0)
        throw new IllegalArgumentException("Discriminant < zero.");
        return  (-B + Math.sqrt(disc)) / (2*A);
        }
        }
Your program should allow the user to specify values for A, B, and C. It should call the subroutine to compute a
solution of the equation. If no error occurs, it should print the root. However, if an error occurs, your program
should catch that error and print an error message. After processing one equation, the program should ask whether
the user wants to enter another equation. The program should continue until the user answers no.

*/

public class Exercise1 {
    public static void main(String[] args) {
//        System.out.println("Hello");
//        Scanner input = new Scanner(System.in);
//        int a = input.nextFloat();
//        System.out.println("You entered Float " + a);
        System.out.println("Hello");
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("A*X*X + B*X + C = 0. Please enter A: ");
            float a = in.nextFloat();
            System.out.println("You entered float " + a);
            System.out.print("A*X*X + B*X + C = 0 . Please enter B:");

            float b = in.nextFloat();
            System.out.println("You entered float  + b");
            System.out.print("*X*X + B*X + C = 0. Please enter C: ");

            float c = in.nextFloat();
            System.out.println("You entered float: " + c);
            try {
                double res = root(a, b, c);
                System.out.println("root =" + res);
            } catch (Exception e) {
                System.out.println("ERROR");

            }
            String ans = in.nextLine();

            System.out.print("Another equation? yes/no ");
            ans = in.nextLine();
            System.out.println("user entered: " + ans);
            if (ans.equals("no")) {
                break;
            }


        }
    }

    static public double root( double A, double B, double C )
            throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        }
        else {
            double disc = B*B - 4*A*C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return  (-B + Math.sqrt(disc)) / (2*A);
        }
    }

    }
