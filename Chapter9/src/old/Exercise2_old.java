package old;/*
Exercise 7.6 asked you to read a file, make an alphabetical list of all the words that occur in the file, and write
the list to another file. In that exercise, you were asked to use an ArrayList<String> to store the words. Write a
new version of the same program that stores the words in a binary sort tree instead of in an arraylist. You can use
the binary sort tree routines from SortTreeDemo.java, which was discussed in Subsection 9.4.2.
 */


import com.sun.source.tree.BinaryTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise2_old {

    public static void main(String[] args) {
        String outPath = "Exercise2.txt";
        File file = new File("Exercise2.java");
        BufferedReader br = null;
        ArrayList<String> arr = new ArrayList<>();
        TreeSet set = new TreeSet();
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                StringTokenizer st = new StringTokenizer(line, "\t(),\\[];{}.");
                while (st.hasMoreTokens()) {
                    String word = st.nextToken();
                    System.out.println(word);
                    arr.add(word);
                    set.add(word);
            System.out.println(st.nextToken());
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(" -------------------------------- ");
        System.out.println(Arrays.toString(arr.toArray()));
        String[] arr2 = (String[]) arr.toArray();
        Arrays.sort(arr2);
        Object[] arr3 = set.toArray();
        System.out.println(" -------------------------------- ");
        System.out.println(Arrays.toString(arr2));
        try {
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(outPath), "utf-8"));
            for (int i = 0; i < arr2.length; i++) {
                Object word = arr2[i];
                writer.write(word.toString());
                writer.write("\n");
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("----Set ----");
        System.out.println(Arrays.toString(set.toArray()));
    }
}