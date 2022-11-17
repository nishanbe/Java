import java.util.Scanner;

public class PrintRowFS {

    public static void main(String[] args){
        System.out.print("Enter a line of text: ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println("You entered " + str);
        printRowFromString(str);
    }
    private static void printRow(char ch, int N){
        for( int i = 0; i < N; i++){
            System.out.print(ch);
        }
        System.out.println();
    }
    private static void printRowFromString(String str){
        for(int i = 0; i < str.length(); i++){
            printRow(str.charAt(i), 25);
        }
    }
}
