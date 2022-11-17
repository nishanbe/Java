/*
Write a program that will read a sequence of positive real numbers entered by the user and will print the same numbers
in sorted order from smallest to largest. The user will input a zero to mark the end of the input.
Assume that at most 100 positive numbers will be entered. Do not use any built-in function such as Arrays.sort().
Do the sorting yourself.

 */

import java.util.Scanner;

public class Exercise5 {

    public static void main(String[] args) {
        int count = 0;
        double[] nums = new double[100];

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a real positive number: ");
        double userEntry = input.nextDouble();

        while (userEntry > 0) {
            System.out.print("Enter a real positive number: ");
            userEntry = input.nextDouble();
            nums[count] = userEntry;
            count++;
        }
        System.out.print("\n");
        System.out.println("The numbers you entered are:");

        printNums( nums, count);

        System.out.println("\nAfter sorting they are:");
        sourNums(nums, count);
        printNums( nums, count);

    }

    static void printNums(double nums[], int count){
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            System.out.print(" " + nums[i] + " ");
        }
        System.out.print("]\n");
    }

    static void sourNums(double nums[], int count) {
        for ( int lastPlace = count - 1; lastPlace > 0; lastPlace-- ) {
            int end = 0;
            for (int k = 1; k <= lastPlace; k++) {
                if (nums[k] > nums[end]) {
                    end = k;
                }
            }
            double numHolder = nums[end];
            nums[end] = nums[lastPlace];
            nums[lastPlace] = numHolder;
        }
    }
}
