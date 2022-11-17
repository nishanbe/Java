import java.util.Scanner;

public class test5 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Playing");
        boolean isOnRepeat = true;

        while(isOnRepeat){
            System.out.println("Playing the next song");
            System.out.println("Repeat?");
            String input = scan.nextLine();
            System.out.println("You just said " + input + " therefore isOnRepeat is "+ isOnRepeat);
            if(input.equals("no")) {
                isOnRepeat = false;
                System.out.println("It's over buddy.");
            }
            System.out.println("Playing the next song");
        }


    }
}
