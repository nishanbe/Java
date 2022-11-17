import textio.TextIO;


public class Exercise2 {

    private static TreeNode root;  // Pointer to the root node in a binary tree.
    // This tree is used in this program as a
    // binary sort tree.  When the tree is empty,
    // root is null (as it is initially).



    public static void main(String[] args) {

        System.out.println("\n\nThis program will ask you to select an input file");
        System.out.println("It will read that file and make an alphabetical");
        System.out.println("list of all the words in the file.  After reading");
        System.out.println("the file, the program asks you to select an output");
        System.out.println("file.  If you select a file, the list of words will");
        System.out.println("be written to that file; if you cancel, the list");
        System.out.println("be written to standard output.  All words are converted");
        System.out.println("lower case, and duplicates are eliminated from the list.\n\n");
        System.out.print("Press return to begin.");
        TextIO.getln();  // Wait for user to press return.

        try {
            if (TextIO.readUserSelectedFile() == false) {
                System.out.println("No input file selected.  Exiting.");
                System.exit(1);
            }
            // ArrayList<String> wordList = new ArrayList<String>(); DELETED LINE
            String word = readNextWord();
            while (word != null) {
                word = word.toLowerCase();  // convert word to lower case
                if ( treeContains(root,word) == false ) {
                    // This is a new word, so add it to the tree
                    treeInsert(word);
                }
                word = readNextWord();
            }
            int wordsInTree = countNodes(root);
            System.out.println("Number of different words found in file:  "
                    + wordsInTree);
            System.out.println();
            if (wordsInTree == 0) {
                System.out.println("No words found in file.");
                System.out.println("Exiting without saving data.");
                System.exit(0);
            }
            // selectionSort(wordList);  DELETED LINE
            TextIO.writeUserSelectedFile(); // If user cancels, output automatically
            // goes to standard output.
            System.out.println(wordsInTree + " words found in file:\n");
            treeList(root);
            System.out.println("\n\nDone.\n\n");
        }
        catch (Exception e) {
            System.out.println("Sorry, an error has occurred.");
            System.out.println("Error Message:  " + e.getMessage());
        }
        System.exit(0);  // Might be necessary, because of use of file dialogs.
    }



    private static String readNextWord() {
        char ch = TextIO.peek(); // Look at next character in input.
        while (ch != TextIO.EOF && !Character.isLetter(ch)) {
            TextIO.getAnyChar();  // Read the character.
            ch = TextIO.peek();   // Look at the next character.
        }
        if (ch == TextIO.EOF) // Encountered end-of-file
            return null;
        // At this point, we know that the next character, so read a word.
        String word = "";  // This will be the word that is read.
        while (true) {
            word += TextIO.getAnyChar();  // Append the letter onto word.
            ch = TextIO.peek();  // Look at next character.
            if ( ch == '\'' ) {
                // The next character is an apostrophe.  Read it, and
                // if the following character is a letter, add both the
                // apostrophe and the letter onto the word and continue
                // reading the word.  If the character after the apostrophe
                // is not a letter, the word is done, so break out of the loop.
                TextIO.getAnyChar();   // Read the apostrophe.
                ch = TextIO.peek();    // Look at char that follows apostrophe.
                if (Character.isLetter(ch)) {
                    word += "\'" + TextIO.getAnyChar();
                    ch = TextIO.peek();  // Look at next char.
                }
                else
                    break;
            }
            if ( ! Character.isLetter(ch) ) {
                // If the next character is not a letter, the word is
                // finished, so bread out of the loop.
                break;
            }
            // If we haven't broken out of the loop, next char is a letter.
        }
        return word;  // Return the word that has been read.
    }


    /**
     * An object of type TreeNode represents one node in a binary tree of strings.
     */
    private static class TreeNode {
        String item;      // The data in this node.
        TreeNode left;    // Pointer to left subtree.
        TreeNode right;   // Pointer to right subtree.
        TreeNode(String str) {
            // Constructor.  Make a node containing the specified string.
            // Note that left and right pointers are initially null.
            item = str;
        }
    }  // end nested class TreeNode



    private static void treeInsert(String newItem) {
        if ( root == null ) {
            // The tree is empty.  Set root to point to a new node containing
            // the new item.  This becomes the only node in the tree.
            root = new TreeNode( newItem );
            return;
        }
        TreeNode runner;  // Runs down the tree to find a place for newItem.
        runner = root;   // Start at the root.
        while (true) {
            if ( newItem.compareTo(runner.item) < 0 ) {
                // Since the new item is less than the item in runner,
                // it belongs in the left subtree of runner.  If there
                // is an open space at runner.left, add a new node there.
                // Otherwise, advance runner down one level to the left.
                if ( runner.left == null ) {
                    runner.left = new TreeNode( newItem );
                    return;  // New item has been added to the tree.
                }
                else
                    runner = runner.left;
            }
            else {
                // Since the new item is greater than or equal to the item in
                // runner it belongs in the right subtree of runner.  If there
                // is an open space at runner.right, add a new node there.
                // Otherwise, advance runner down one level to the right.
                if ( runner.right == null ) {
                    runner.right = new TreeNode( newItem );
                    return;  // New item has been added to the tree.
                }
                else
                    runner = runner.right;
            }
        } // end while
    }  // end treeInsert()


    static boolean treeContains( TreeNode root, String item ) {
        if ( root == null ) {
            // Tree is empty, so it certainly doesn't contain item.
            return false;
        }
        else if ( item.equals(root.item) ) {
            // Yes, the item has been found in the root node.
            return true;
        }
        else if ( item.compareTo(root.item) < 0 ) {
            // If the item occurs, it must be in the left subtree.
            return treeContains( root.left, item );
        }
        else {
            // If the item occurs, it must be in the right subtree.
            return treeContains( root.right, item );
        }
    }  // end treeContains()


    private static void treeList(TreeNode node) {
        if ( node != null ) {
            treeList(node.left);             // Print items in left subtree.
            System.out.println("  " + node.item);  // Print item in the node.
            treeList(node.right);            // Print items in the right subtree.
        }
    } // end treeList()



    private static int countNodes(TreeNode node) {
        if ( node == null ) {
            // Tree is empty, so it contains no nodes.
            return 0;
        }
        else {
            // Add up the root node and the nodes in its two subtrees.
            int leftCount = countNodes( node.left );
            int rightCount = countNodes( node.right );
            return  1 + leftCount + rightCount;
        }
    } // end countNodes()

}