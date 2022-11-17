/**
 * A PairOfDice object represents an ordinary pair of six-sided dice.
 */
public class PairOfDice2 {

    private int die1;   // Number showing on the first die.
    private int die2;   // Number showing on the second die.

    public PairOfDice2() {
            // Constructor.  Rolls the dice, so that they initially
            // show some random values.
        roll();  // Call the roll() method to roll the dice.
    }

    public void roll() {
            // Roll the dice by setting each of the dice to be
            // a random number between 1 and 6.
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
    }

    public int getDie1(){
        return die1;
    }

    public void setDie1(int number){
        if (number < 1 || number > 6){
            throw new IllegalArgumentException("Cannot be less than 1 or bigger than 6");
        }
            die1 = number;
    }

    public int getDie2(){
        return die2;
    }

    public void setDie2(int number){
        if (number < 1 || number > 6){
            throw new IllegalArgumentException("Cannot be less than 1 or bigger than 6");
        }
            die2 = number;
    }
    public int getTotal(){return die1 + die2;}

    public String toString(){
        if(die1 == die2){
            return "Matching dice of " + die1;
        }
        else {
            return die1 + " and " + die2;
        }
    }

    public static int rollFor( int N ) {
        if ( N < 2 || N > 12 )
            throw new IllegalArgumentException("Impossible total for a pair of dice.");
        int die1, die2;  // Numbers between 1 and 6 representing the dice.
        int roll;        // Total showing on dice.
        int rollCt;      // Number of rolls made.
        rollCt = 0;
        do {
            die1 = (int)(Math.random()*6) + 1;
            die2 = (int)(Math.random()*6) + 1;
            roll = die1 + die2;
            rollCt++;
        } while ( roll != N );
        return rollCt;
    }

} // end class PairOfDice
