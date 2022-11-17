import java.util.Scanner;

public class ZombieKiller {
    public static void main(String[] args) {
        System.out.println("Welcome");
        String[] backpack = new String[3];
        backpack[] = {"Shotgun", "Assault Rifle", "Sniper"};
        String zombies[] = {"Close-range zombie", "Mid-range zombie", "Long-range zombie"};

        System.out.println();
        System.out.println(backpack[0]);
        Scanner input = new Scanner(System.in);

        System.out.println("Choose your weapon");
        int weapon = input.nextInt();
//        if ( int i = 0; i < backpack.length ; i++){
//
//        }
        System.out.println(weapon);

    }
}
