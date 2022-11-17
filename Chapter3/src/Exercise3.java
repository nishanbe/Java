import java.util.Scanner;

public class Exercise3 {
    public  static void main(String[] args){

        System.out.print("Enter an expression: ");
        Scanner scanThis = new Scanner(System.in);
        double n1 = scanThis.nextDouble();
        System.out.println("n1 = " + n1);

        String op = scanThis.next();
        System.out.println("op = " + op);
        double n2 = scanThis.nextDouble();
        System.out.println("n2 = " + n2);
        double res = 0;

        switch (op){
            case "+":
                res = n1 + n2;
                break;
            case "-":
                res = n1 - n2;
                break;
            case "*":
                res = n1 * n2;
                break;
            case "/":
                res = n1 / n2;
                break;
            default:
                System.out.println("Are you OK?");
//                continue;



        }

    }
}
