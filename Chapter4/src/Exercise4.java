/*
This exercise builds on Exercise 4.3.
 Every time you roll the dice repeatedly, trying to get a given total, the number of rolls it takes can be different.
 The question naturally arises, what's the average number of rolls to get a given total?
 Write a function that performs the experiment of rolling to get a given total 10000 times.
 The desired total is a parameter to the subroutine.
 The average number of rolls is the return value.
 Each individual experiment should be done by calling the function you wrote for Exercise 4.
3.
 Now, write a main program that will call your function once for each of the possible totals (2, 3, ..., 12).
 It should make a table of the results, something like:
 Total On Dice     Average Number of Rolls
-------------     -----------------------
       2               35.8382
       3               18.0607
       .                .
       .                .
 */
public class Exercise4 {
    public static void main(String[] args) {
        System.out.println(" Total On Dice     Average Number of Rolls\n---------------     -----------------------");
        for (int n = 2; n <= 12; n++) {
            double av = rollToGetAverage(n, 10000);
            System.out.printf("%8d%26.4f\n", n, av);
        }
    }

    public static double rollToGetAverage(int number, int times) {
        int count = 0;
        int match;
        for (int i = 0; i <= times; i++) {
            do {
                match = rollTheDice();
                count++;
            } while (number != match);
        }
        return (double) count / times;

    }

    public static int rollsToGet(int userChoice) {
        int count = 0;
        int match;
        do {
            match = rollTheDice();
            count++;
//            System.out.print(match + "\t"); // to view each result
        } while (userChoice != match);
        return count;
    }

    public static int rollTheDice() {
        int diceOne = (int) (Math.random() * 6 + 1);
        int diceTwo = (int) (Math.random() * 6 + 1);
        return diceOne + diceTwo;
    }

}