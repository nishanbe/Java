import java.util.ArrayList;
import java.util.Scanner;

public class Exercise4 {
    /*
    Write a program that reads one line of input text and breaks it up into words. The words should be output one per line. A word is defined to be a sequence of letters. Any characters in the input that are not letters should be discarded. For example, if the user inputs the line

He said, "That's not a good idea."
then the output of the program should be

He
said
That
s
not
a
good
idea
An improved version of the program would list "that's" as a single word. An apostrophe can be considered to be part of a word if there is a letter on each side of the apostrophe.

To test whether a character is a letter, you might use (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'). However, this only works in English and similar languages. A better choice is to call the standard function Character.isLetter(ch), which returns a boolean value of true if ch is a letter and false if it is not. This works for any Unicode character.
 */

    /*
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        System.out.println("");
        while (scanner.hasNext()){
            String s = scanner.next();
            s = keepLetters(s);
            System.out.println(s);
        }

    }

    private static String keepLetters(String s){
        char[] arr = s.toCharArray();
//        ArrayList<Character> ret = new ArrayList<>();
        String ret = "";
        for(int i = 0; i < arr.length; i++){
            char c = arr[i];
            if (Character.isAlphabetic(c)){
                ret = ret + c;
            }
        }
    }

     */
}
