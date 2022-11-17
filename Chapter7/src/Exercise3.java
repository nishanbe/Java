/*
In Subsection 7.4.4, it is mentioned that the standard sorting method Arrays.sort() is much faster and efficient than
selection sort. Write a program to test this claim. To be specific, your program should create a large array filled
with random real numbers. It should use both Arrays.sort() and selectionSort() to sort the array, and it should time
how long it takes to perform each sort. Furthermore, it should do the same thing for a large array of random Strings.
To find the times, you can use System.nanoTime() (see Subsection 2.3.1 and the example TimedComputation.java).
 */


import java.util.Arrays;

public class Exercise3 {

    final static int SIZE = 100_000;
    public static void main(String[] args) {

        long startTime; 
        long endTime;   
        long duration;

        double[] numberList1;  
        double[] numberList2;  

        String[] stringList1;  
        String[] stringList2;  



        System.out.println("First, test that selection sort works on doubles.");
        System.out.println("The 10 output numbers should be in increasing order.");
        numberList1 = randomDigits(10);
        selectionSort(numberList1);
        for (double n : numberList1)
            System.out.println( "   " + n );
        System.out.println();

        System.out.println("Next, test that selection sort works on strings.");
        System.out.println("The 10 output strings should be in alphabetical order.");
        System.out.println("(Also tests that random strings are made correctly.");
        stringList1 = aSetOfRandomStrings(10);
        selectionSort(stringList1);
        for (String str : stringList1)
            System.out.println( "   " + str );
        System.out.println();

        System.out.println();
        System.out.println("Times for sorting arrays of size " + SIZE + ":");
        System.out.println();

        /* Create the arrays. */

        numberList1 = randomDigits(SIZE);
        numberList2 = Arrays.copyOf(numberList1, SIZE);
        stringList1 = aSetOfRandomStrings(SIZE);
        stringList2 = Arrays.copyOf(stringList1, SIZE);

        /* Do the sorts and output the times. */

        startTime = System.nanoTime();
        selectionSort(numberList1);
        endTime = System.nanoTime();
        duration = endTime - startTime;;

        System.out.printf("The duration to sort %d numbers with selectionSort: %1.6g%n", SIZE, duration / 1e9);

        startTime = System.nanoTime();
        Arrays.sort(numberList2);
        endTime = System.nanoTime();
        System.out.printf("The duration to sort %d numbers with Arrays.sort(): %1.6g%n", SIZE,
                (endTime - startTime) / 1e9);


        startTime = System.nanoTime();
        selectionSort(stringList1);
        endTime = System.nanoTime();
        System.out.printf("The duration to sort %d numbers with selectionSort: %1.6g%n", SIZE, duration / 1e9);


        startTime = System.nanoTime();
        Arrays.sort(stringList2);
        endTime = System.nanoTime();
        System.out.printf("The duration to sort %d numbers with Arrays.sort(): %1.6g%n", SIZE,
                (endTime - startTime) / 1e9);
        System.out.println();

    }
    private static String randomString() {
        int length = 5 + (int)(21*Math.random());
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char ch = (char)('A' + (int)(26*Math.random()));
            str.append(ch);
        }
        return str.toString();
    }


    private static double[] randomDigits(int count) {
        double[] numbers = new double[count];
        for (int i = 0; i < count; i++)
            numbers[i] = Math.random();
        return numbers;
    }

    private static String[] aSetOfRandomStrings(int count) {
        String[] strings = new String[count];
        for (int i = 0; i < count; i++)
            strings[i] = randomString();
        return strings;
    }


    private static void selectionSort(double[] numbers) {
        for (int top = numbers.length-1; top > 0; top-- ) {
            int maxloc = 0;
            for (int i = 1; i <= top; i++) {
                if (numbers[i] > numbers[maxloc])
                    maxloc = i;
            }
            double temp = numbers[top];
            numbers[top] = numbers[maxloc];
            numbers[maxloc] = temp;
        }
    }

    private static void selectionSort(String[] numbers) {
        for (int top = numbers.length-1; top > 0; top-- ) {
            int maxloc = 0;
            for (int i = 1; i <= top; i++) {
                if (numbers[i].compareTo(numbers[maxloc]) > 0)
                    maxloc = i;
            }
            String temp = numbers[top];
            numbers[top] = numbers[maxloc];
            numbers[maxloc] = temp;
        }
    }



}