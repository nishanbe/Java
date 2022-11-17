
public class Exercise4 {



    static class StrTreeNode {
        String item;  // The item
        StrTreeNode left;  // Pointer to left subtree.
        StrTreeNode right; // Pointer to right subtree.
        StrTreeNode( String str ) {
            // Constructor.  Make a node to contain str.
            item = str;
        }
    } // end class StrTreeNode


    static class TreeQueue {


        private static class Node {
            StrTreeNode item;
            Node next;
        }

        private Node head = null;  // Points to first Node in the queue.
        // The queue is empty when head is null.

        private Node tail = null;  // Points to last Node in the queue.


        void enqueue( StrTreeNode tree ) {
            Node newTail = new Node();  // A Node to hold the new item.
            newTail.item = tree;
            if (head == null) {
                // The queue was empty.  The new Node becomes
                // the only node in the list.  Since it is both
                // the first and last node, both head and tail
                // point to it.
                head = newTail;
                tail = newTail;
            }
            else {
                // The new node becomes the new tail of the list.
                // (The head of the list is unaffected.)
                tail.next = newTail;
                tail = newTail;
            }
        }


        StrTreeNode dequeue() {
            if ( head == null)
                throw new IllegalStateException("Can't dequeue from an empty queue.");
            StrTreeNode firstItem = head.item;
            head = head.next;  // The previous second item is now first.
            if (head == null) {
                // The queue has become empty.  The Node that was
                // deleted was the tail as well as the head of the
                // list, so now there is no tail.  (Actually, the
                // class would work fine without this step.)
                tail = null;
            }
            return firstItem;
        }


        boolean isEmpty() {
            return (head == null);
        }

    } // end class TreeQueue


    //-------------------- END OF NESTED CLASSES ---------------------------


    static StrTreeNode root;  // A pointer to the root of the binary tree.




    static void levelOrderPrint(StrTreeNode root) {
        if (root == null)
            return;  // There is nothing to print in an empty tree.
        TreeQueue queue;   // The queue, which will only hold non-null nodes.
        queue = new TreeQueue();
        queue.enqueue(root);
        while ( queue.isEmpty() == false ) {
            StrTreeNode node = queue.dequeue();
            System.out.println( node.item );
            if ( node.left != null )
                queue.enqueue( node.left );
            if ( node.right != null )
                queue.enqueue( node.right );
        }
    } // end levelOrderPrint()


    static void treeInsert(String newItem) {
        if ( root == null ) {
            // The tree is empty.  Set root to point to a new node
            // containing the new item.
            root = new StrTreeNode( newItem );
            return;
        }
        StrTreeNode runner; // Runs down the tree to find a place for newItem.
        runner = root;   // Start at the root.
        while (true) {
            if ( newItem.compareTo(runner.item) < 0 ) {
                // Since the new item is less than the item in runner,
                // it belongs in the left subtree of runner.  If there
                // is an open space at runner.left, add a node there.
                // Otherwise, advance runner down one level to the left.
                if ( runner.left == null ) {
                    runner.left = new StrTreeNode( newItem );
                    return;  // New item has been added to the tree.
                }
                else
                    runner = runner.left;
            }
            else {
                // Since the new item is greater than or equal to the
                // item in runner, it belongs in the right subtree of
                // runner.  If there is an open space at runner.right,
                // add a new node there.  Otherwise, advance runner
                // down one level to the right.
                if ( runner.right == null ) {
                    runner.right = new StrTreeNode( newItem );
                    return;  // New item has been added to the tree.
                }
                else
                    runner = runner.right;
            }
        } // end while
    }  // end treeInsert()

    public static void main(String[] args) {
        treeInsert("judy");
        treeInsert("bill");
        treeInsert("fred");
        treeInsert("mary");
        treeInsert("dave");
        treeInsert("jane");
        treeInsert("alice");
        treeInsert("joe");
        treeInsert("tom");
        levelOrderPrint(root);
    } // end main()


} // end class TreePrintNonRecursive