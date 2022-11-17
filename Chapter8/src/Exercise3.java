import java.util.HashMap;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Romans: ");
        String s = scanner.nextLine();
        System.out.println("You entered: " + s);
        String origStr = s;

        HashMap<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
        String[] keys = {"M", "CM", "D", "CD", "C", "XC", "L", "X", "IX", "V", "IV", "I"};
        int res = 0;
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            int val = map.get(key);
            System.out.println("Looking for key = " + key);
            int len = key.length();
            while (s.length() > 0) {
                len = Math.min(len, s.length());
                String tag = s.substring(0, len);
                System.out.println("tag = " + tag);
                if (key.equals(tag)) {
                    res += val;
                    if (s.length() == tag.length()) {
                        s = "";
                        break;
                    } else {
                        s = s.substring((len));
                    }

                    System.out.println("new int = " + res);
                    System.out.println("new rom = " + s);

                } else {
                    break;
                }

            }

        }
        System.out.println("Roman = " + origStr);
        System.out.println("Int = " + res);
    }
}
