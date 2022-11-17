public class ex_2_2 {
    public static void main(String[] args) {
        int firstRoll = (int)(Math.random() * 6) + 1;
        System.out.println("First die comes up " + firstRoll);

        int secondRoll = (int)(Math.random() * 6) + 1;
        System.out.println("Second die comes up " + secondRoll);

        System.out.println("Your total roll is " + (firstRoll + secondRoll));
    }
}
