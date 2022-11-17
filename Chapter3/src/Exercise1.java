public class Exercise1 {
    /*
How many times do you have to roll a pair of dice before they come up snake eyes?
You could do the experiment by rolling the dice by hand. Write a computer program that simulates the experiment.
The program should report the number of rolls that it makes before the dice come up snake eyes.
(Note: "Snake eyes" means that both dice show a value of 1.) Exercise 2.2 explained how to simulate rolling a pair of dice.
*/
    public static void main(String[] args) {

        int countRolls = 0;

        int diceOne;
        int diceTwo;


        do {
            diceOne = (int) (Math.random() * 6) + 1;
            diceTwo = (int) (Math.random() * 6) + 1;
            System.out.println("dice one = " + diceOne + ", dice two = " + diceTwo);
            countRolls++;
        } while (!(diceOne == 1 && diceTwo == 1));

        System.out.println("SNAKE EYE! because " + "dice one = " + diceOne + ", dice two = " + diceTwo);
        System.out.println("We had to roll the dices " + countRolls + " time(s) to get a snake eye.");


    }
}
