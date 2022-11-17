/*
import javax.crypto.spec.PSource;
import javax.imageio.event.IIOReadProgressListener;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Exercise3_Old {
    public static void main(String[] args) {
        while(true){
            Scanner in = new Scanner(System.in);
            System.out.print("Enter your Arabic OR Roman number: ");
            String s = in.nextLine();
            System.out.println("You entered:" + s);
            if (s.equals("")){
                System.out.println("bye");
                break;
            }
            if (isArabicNumeral(s)){
                String roman = convertArabicToRoman(s);
            }
        }
    }

    private static String convertArabicToRoman(String s) {
        int i = 0;
        try{
             i = Integer.parseInt(s);
            System.out.println("got " + i );
        }catch (Exception e){
            System.out.println("Not Arabic");
            return "";

        }
        HashMap<String , Integer> map = new HashMap<>();
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
        ArrayList<String> keys = new ArrayList<>();
        keys.add("M");
        keys.add("CM");
        keys.add("D");
        keys.add("CD");
        keys.add("C");
        keys.add("XC");
        keys.add("L");
        String roman = "";
        int N = i;
        for(Iterator<String> iterator = keys.iterator(); iterator.hasNext();)
            String nextRoman = iterator.next();
            int val =map.get(nextRoman);
            while (N >= val){
                roman+= nextRoman;
                System.out.println("" + roman);
        }
    }


    private static boolean isArabicNumeral(String s) {
        try{
            BigInteger i = new BigInteger(s);
            System.out.println("got " + i );
            return true;
        }catch (Exception e){
            System.out.println("Not Arabic");
            return false;
        }
    }
}
*/