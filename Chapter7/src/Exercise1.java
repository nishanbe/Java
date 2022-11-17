import java.util.ArrayList;

public class Exercise1 {

    public static void main(String[] args) {
        System.out.println("5 numbers with the range 1 to 10");
        printArrayList(crateRandomNumbers(5, 10));
        System.out.println();

        System.out.println("10 numbers with the range 1 to 50");
        printArrayList(crateRandomNumbers(10, 50));
        System.out.println();

        System.out.println("10 numbers with the range 1 to 7 (will cause and exception)");
        crateRandomNumbers(10, 1);
    }

    public static ArrayList<Integer> crateRandomNumbers(int count, int max) {
        if (count > max) {
            throw new IllegalArgumentException("Cannot have " + count + " numbers because the range is 1 to " + max);
        }
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        while (numbers.size() < count) {
            int num = (int) (Math.random() * max) + 1;
            if ( numbers.indexOf(num) == -1 ) // if the Arraylist called 'numbers does not contain (num)
                numbers.add(num);
        }
        return numbers;
    }

    private static void printArrayList(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i > 0) // To avoid having a blank number at the start of the ArrayList
                System.out.print(", ");
            System.out.print(numbers.get(i));
        }
        System.out.println("");
    }

}
