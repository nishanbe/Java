import textio.TextIO;

import java.util.Scanner;
/*
To "capitalize" a string means to change the first letter of each word in the string to upper case (if it is not already upper case).
For example, a capitalized version of "Now is the time to act!" is "Now Is The Time To Act!".
Write a subroutine named printCapitalized that will print a capitalized version of a string to standard output.
The string to be printed should be a parameter to the subroutine.
Test your subroutine with a main() routine that gets a line of input from the user and applies the subroutine to it.
 */
/*
Note that a letter is the first letter of a word if it is not immediately preceded in the string by another letter.
Recall from Exercise 3.4 that there is a standard boolean-valued function Character.isLetter(char) that can be used to test whether its parameter is a letter. There is another standard char-valued function, Character.toUpperCase(char), that returns a capitalized version of the single character passed to it as a parameter. That is, if the parameter is a letter, it returns the upper-case version. If the parameter is not a letter, it just returns a copy of the parameter.
*/

public class Exercise1 {

    public static void main(String[] args){
        System.out.print("Enter your text: ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        System.out.println(text.toUpperCase());
//        boolean isAFirstLetter;
        for(int i = 0; i < text.length(); i++) {
            char cha = text.charAt(i);
            if(Character.isLetter(cha) && (i == 0 || !Character.isLetter(text.charAt(i-1)) )){
                    printCapitalized(cha);
                }
            else {
                    System.out.print(cha);
                }
        }
        }
    private static void printCapitalized(char ch){
        char cha = Character.toUpperCase(ch);
        System.out.print(cha);
    }
}

// Attempts as I was testing
//
//        char letter = text.charAt(n);
//        char precedingLetter = text.charAt(n-1);
//        isAFirstLetter = Character.isLetter(precedingLetter);
//
//            if(isFirstLetter(text, ch)){
//                printCapitalized(letter);
//                System.out.println();
//
//            System.out.print(text.charAt(i));
//
//        printCapitalized(text);


//    private static void isFirstLetter(String text, int n){
//
//
//        }
//    }


