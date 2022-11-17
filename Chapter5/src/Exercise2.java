import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args){
        StatCalcWithMinMax calc = new StatCalcWithMinMax();

//        testing the code
//        calc.enter(1);
//        calc.enter(2);
//        calc.enter(13);
//        calc.enter(64);
//        calc.enter(2);



        Scanner input = new Scanner(System.in);


        double item;

        System.out.println("Enter your numbers.  Enter 0 to end.");
        System.out.println();

        do {
            System.out.print("Add a number: ");
            item = input.nextDouble();
            if (item != 0)
                calc.enter(item);
        } while (item != 0);

        System.out.println("The max is: " + calc.getMax());
        System.out.println("The min is: " + calc.getMin());
        System.out.println("The count is: " + calc.getCount());
        System.out.println("The average is: " + calc.getMean());
        System.out.println("The standard deviation is:" + calc.getStandardDeviation());
    }
}
