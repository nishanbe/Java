
package Exercise4;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your expression, e.g. \"sin(x)+3*x: ");
        String exprStr = in.nextLine();
        System.out.println("Entered expr = " + exprStr);
        Expr expr = null;
        try {
            expr = new Expr(exprStr);
            while (true) {
                System.out.println("Enter x:");
                String text = in.nextLine();
                double x = Double.parseDouble(text);
                System.out.println(expr.value(x));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }



    }
}
