/*
Write a function that simulates rolling a pair of dice until the total on the dice comes up to be a given number.
The number that you are rolling for is a parameter to the function.
The number of times you have to roll the dice is the return value of the function.
The parameter should be one of the possible totals: 2, 3, ..., 12.
The function should throw an IllegalArgumentException if this is not the case.
Use your function in a program that computes and prints the number of rolls it takes to get snake eyes.
(Snake eyes means that the total showing on the dice is 2.)
 */

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
//        try {
            System.out.print("Choose the total number of rolling two dice (2-12): ");
            Scanner input = new Scanner(System.in);
            int userChoice = input.nextInt();
            if (userChoice < 2 || userChoice > 12){
                throw new IllegalArgumentException("We cannot get " + userChoice + " by rolling to dice");
            }
            else {
                int attempts = rollToGet(userChoice);
                System.out.println("\nIt took " + attempts + " attempts to get your chosen number: " + userChoice);
                System.out.println("Let's try to get a snake eye...");
                attempts = rollToGet(2);
                System.out.println("\nTo get the snake eye we rolled the pair of dice " + attempts + " times.");
            }
//        } catch (Exception IllegalArgumentException){
//            System.out.println("Invalid entry");
//        }

    }


    public static int rollToGet(int userChoice) {

        int count = 0;
        int match;
        do {
            match = rollTheDice();
            count++;
            System.out.print(match + "\t"); // to view each result
        } while (userChoice != match);
        return count;
    }

    public static int rollTheDice() {
        int diceOne = (int) (Math.random() * 6 + 1);
        int diceTwo = (int) (Math.random() * 6 + 1);
        return diceOne + diceTwo;
    }
}
