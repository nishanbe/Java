//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class Exercise3 {
//    static class ListNode {
//        int item;        // An item in the list.
//        ListNode next;   // Pointer to the next node in the list.
//    }
//
//    public static void main(String[] args) {
//
//        ListNode i1 = new ListNode();
//        i1.item = 1;
//        ListNode i2 = new ListNode();
//        i2.item = 2;
//        ListNode i3 = new ListNode();
//        i3.item = 3;
//        ListNode i4 = new ListNode();
//        i4.item = 4;
//        printMyList(i1);
//        ListNode newList = reverseOrder(origList);
//        System.out.println("---------------------");
//        printMyList(newList);
//
//
//        System.out.println("---------------------");
//        printMyList(origList);
//    }
//
//    private static void printMyList(ListNode i1) {
//    }
//
//    private static ListNode reverseOrder(ListNode node) {
//        ArrayList<ListNode> arr = new ArrayList<>();
//        while (true) {
//            if (node == null) {
//                break;
//            }
//            ListNode newNode = new ListNode();
//            newNode.item = node.item;
//            newNode.next = node.next;
//
//            arr.add(node);
//            System.out.println("item = " + node.item);
//            node = node.next;
//
//        }
//        ListNode first = null;
//        ListNode nextNode = null;
//        for (int i = 0; i < arr.size() - 1; i++) {
//        }
//
//    private static void printMyList(ListNode node) {
//        ArrayList<ListNode> arr = new ArrayList<>();
//        while (true) {
//            if (node == null) {
//                break;
//            }
//            arr.add(node);
//            System.out.println("item = " + node.item);
//            node = node.next;
//
//            ListNode first = null;
//            ListNode nextNode = null;
//
//            for (int i = 0; i < arr.size() - 1; i++) {
//                node = arr.get(arr.size() - i - 1);
//                nextNode = arr.get(arr.size() - (i + 1) - 1);
//                node.next = nextNode;
//                if (first == null) {
//                    first = node;
//                }
//            }
//            return first;
//        }
//            public static void printMylist(ListNode node){
//            }
//            while (true) {
//            }
//            if (node == null) {
//                break;
//            }
//
//            System.out.println("item - " + node.item);
//            node = node.next;
//        }
//    }
//}