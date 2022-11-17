import java.util.Locale;
import java.util.Scanner;

public class test6 {

    public static void main(String args[]) {
        String question = "What is your gender";
        String choiceOne = "male";
        String choiceTwo = "female";
        String choiceThree = "gay";

        String correctAnswer = choiceTwo;

        // Write a print statement asking the question
        System.out.println(question);
        // Write a print statement giving the answer choices
        System.out.println("1. " + choiceOne);
        System.out.println("1. " + choiceTwo);
        System.out.println("1. " + choiceThree);

        // Have the user input an answer
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();
        // Retrieve the user's input
        System.out.println("You chose " + userInput);

        // If the user's input does not match the correctAnswer...
        while(!(correctAnswer.equals(userInput.toLowerCase()))){
        // then the user is incorrect and we want to print out a message saying that the user is incorrect as well as what the correct choice was.
            System.out.println("Incorrect answer, try again.");
            System.out.println(question);
            userInput = scan.nextLine();
        }
        // If the user's input matches the correctAnswer...
        // then the user is correct and we want to print out a congrats message to the user.
        if(correctAnswer.equals(userInput.toLowerCase())){
            System.out.println("Congratulations! your answer is correct.");
        }


    }

}
