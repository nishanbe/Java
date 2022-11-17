import java.util.Scanner;

public class Exercise4_2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter: ");
        String line = input.nextLine();

        boolean didPlaceLine = false;
        for(char ch : line.toCharArray()){
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                System.out.println(ch);
                didPlaceLine = false;
            }
            else{
                if (!didPlaceLine) {
                    System.out.println();
                    didPlaceLine = true;
                }
            }

        }
    }
}
