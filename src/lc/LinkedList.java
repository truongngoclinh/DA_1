package lc;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 9/25/18 - 10:22.
 * @organization VED
 */

public class LinkedList {
  /*  public int solution() {
        */

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     *//*

        MyLinkedList linkedList = new MyLinkedList();
 *//*       for (int i = 1; i < 6; i++) {
            linkedList.addAtTail(i);
        }

//        linkedList.addAtHead(99);
//        linkedList.addAtIndex(1, 999);
//        linkedList.addAtIndex(0, 111);
        linkedList.deleteAtIndex(1);*//*

//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
//        System.out.println(linkedList.get(1));            // returns 2
//        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
//        System.out.println(linkedList.get(1));            // returns 3

        linkedList.addAtHead(1);
        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(3));

        linkedList.print();

        return 0;
    }*/


    class MyLinkedList {
        int length;
        Node head;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            length = 0;
            head = null;
        }

        public MyLinkedList(boolean initial) {
            if (initial) {
                length = 0;
                head = new Node(0);
            } else {
                length = 0;
                head = null;
            }
        }

        public void print(Node head) {
            int nodeIdx = 0;
            Node node = head;
            System.out.print("[HEAD] ");

            while (node.next != null) {
                System.out.print("(" + nodeIdx + ", val = " + node.value + ") -> ");
                nodeIdx++;
                node = node.next;
            }

            if (node.next == null) {
                System.out.print("(" + nodeIdx + ", val = " + node.value + ") -> [TAIL](NULL)");
            }

        }

        public void print() {
            int nodeIdx = 0;
            Node node = head;
            System.out.print("[HEAD] ");

            while (node.next != null) {
                System.out.print("(" + nodeIdx + ", val = " + node.value + ") -> ");
                nodeIdx++;
                node = node.next;
            }

            if (node.next == null) {
                System.out.print("(" + nodeIdx + ", val = " + node.value + ") -> [TAIL](NULL)");
            }

        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (head == null || index >= length || index < 0) return -1;

            int nodeIdx = 0;
            Node node = head;
            while (node.next != null) {
                if (nodeIdx == index) {
                    return node.value;
                }

                nodeIdx++;
                node = node.next;
            }

            if (nodeIdx == index) {
                return node.value;
            }

            return -1;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            if (head == null) {
                head = new Node(val);
                length++;
                return;
            }

            Node newNode = new Node(val);
            Node tmp = head;
            head = newNode;
            newNode.next = tmp;
            length++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            if (head == null) {
                head = new Node(val);
                length++;
                return;
            }

            Node node = head;
            while (node.next != null) {
                node = node.next;
            }

            Node newNode = new Node(val);
            node.next = newNode;
            length++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list.
         * If index equals to the length of linked list, the node will be appended to the end of linked list.
         * If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (head == null) {
                head = new Node(val);
                return;
            }

            if (index == 0) {
                addAtHead(val);
                return;
            }

            if (index == length) {
                addAtTail(val);
                return;
            }

            Node newNode = new Node(val);
            Node node = head;
            int nodeIdx = 0;
            while (node.next != null) {
                if (nodeIdx == index - 1) {
                    newNode.next = node.next;
                    node.next = newNode;
                    length++;
                    return;
                }

                nodeIdx++;
                node = node.next;
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (head == null) {
                return;
            }

            int nodeIdx = 0;
            Node node = head;
            while (node.next != null) {
                if (nodeIdx == index - 1) {
                    node.next = node.next.next;
                    length--;
                    break;
                }

                nodeIdx++;
                node = node.next;
            }
        }

        public void makeCycle() {
            Node node = head;
            while (node.next != null) node = node.next;
            node.next = head;
        }


        class Node {
            int value;
            Node next;

            public Node() {
                value = 0;
                next = null;
            }

            public Node(int val) {
                this.value = val;
            }
        }
    }

    // CYCLIC
/*    public int solution() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtTail(1);
        linkedList.addAtTail(2);
//        linkedList.makeCycle();

        MyLinkedList.Node head1 = linkedList.head, head2 = linkedList.head;

        while (head2.next != null && head2.next.next != null) {
            if (head2.next.next == head1 || head2.next == head1) {
                System.out.println("hasCycle");
                return 0;
            }

            head2 = head2.next.next;
            head1 = head1.next;
        }

        System.out.println("not hasCycle");



        return 0;
    }*/

    // DELETE FROM END
/*    public int solution() {
        MyLinkedList linkedList = new MyLinkedList();
        for (int i = 1; i < 3; i++) {
            linkedList.addAtTail(i);
        }


        linkedList.print();
        System.out.println("");

        int n = 2;
        MyLinkedList.Node node = linkedList.head;
        if (linkedList.head == null) {
//            return null;
        }

        int idx = 0, l = 0;
        while (true) {
            if (node == null) {
                node = linkedList.head;
                l = idx;
                idx = 0;
            } else {
                node = node.next;
                idx++;
            }

            if (idx == l - n - 1) {
                node.next = node.next.next;
                break;
            }
        }

        linkedList.print();

        return 0;
    }*/


    // TEMPLATE
    // Initialize slow & fast pointers

   /* int solution() {

        ListNode slow = head;
        ListNode fast = head;
        */

    /**
     * Change this condition to fit specific problem.
     * Attention: remember to avoid null-pointer error
     **//*
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;           // move slow pointer one step each time
            fast = fast.next.next;      // move fast pointer two steps each time
            if (slow == fast) {         // change this condition to fit specific problem
                return true;
            }
        }
        return false;   // change return value to fit specific problem

    }*/

    // REVERSE
   /* int solution() {
//        testObjectRef();
        testArrayListRef();
        MyLinkedList linkedList = new MyLinkedList();
        for (int i = 1; i <= 5; i++) {
            linkedList.addAtTail(i);
        }
        linkedList.print();
        System.out.println("");

//        MyLinkedList.Node newHead = reverse(linkedList.head, linkedList.head);
//        linkedList.print(newHead);
        MyLinkedList.Node b = linkedList.head;
        while (linkedList.head.next != null) {
            MyLinkedList.Node tmp = linkedList.head.next;
            linkedList.head.next = linkedList.head.next.next;
            tmp.next = b;
            b = tmp;
        }



        linkedList.print(b);

        return 0;
    }
*/
 /*   MyLinkedList.Node reverse(MyLinkedList.Node head, MyLinkedList.Node newHead) {
        if (head.next == null) return newHead;
        MyLinkedList.Node tmp = head.next;
        head.next = head.next.next;
        tmp.next = newHead;
        newHead = tmp;

        return reverse(head, newHead);
    }*/
    private void testObjectRef() {
        Integer A = new Integer(1);
        Integer B = A;
        Integer C = new Integer(2);
        A = C;
//        B = C;
        System.out.println(B);
    }

    private void testArrayListRef() {
        ArrayList<String> A = new ArrayList<>();
        A.add("1");
        ArrayList<String> C = new ArrayList<>();
        C.add("10)");

        ArrayList<String> B = A;
        A = C;
//        B.add("2");
        System.out.println(B.toString());
    }

    // REMOVE ELEMENTS WITH SAME VAL
 /*   int solution() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtTail(1);
        linkedList.addAtTail(2);
        linkedList.addAtTail(6);
        linkedList.addAtTail(3);
        linkedList.addAtTail(4);
        linkedList.addAtTail(5);
        linkedList.addAtTail(6);
        linkedList.print();
        System.out.println("");

        int val = 6;
        MyLinkedList.Node head = linkedList.head;
        while (head != null && head.next != null) {
            if (head.value == val) {
                head = head.next;
            }
            else break;
        }
        if (head == null || head.next == null && head.value == val) linkedList.head = null;
        MyLinkedList.Node p = head;
        while (p.next != null) {
            if (p.next.value == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        linkedList.print();

        return 0;
    }*/

    //ODD EVEN
   /* int solution() {
        MyLinkedList linkedList = new MyLinkedList();
        for (int i = 1; i <= 5; i++) {
            linkedList.addAtTail(i);
        }

        linkedList.print();
        System.out.println("");
        MyLinkedList.Node head = linkedList.head;

*//*
        MyLinkedList.Node s = head, hs = s, f = head.next, hf = f;
        while (f != null && f.next != null) {
            MyLinkedList.Node tmp = f.next;
            s.next = tmp;
            f.next = f.next.next;
            tmp.next = hf;

            s = s.next;
            f = f.next;
        }

        linkedList.print(hs);
*//*

        MyLinkedList.Node o = head, ho = o, e = head.next, he = e;
        while (e != null && e.next != null) {
            o.next = o.next.next;
            e.next = e.next.next;

            o = o.next;
            e = e.next;
        }

        o.next = he;
        linkedList.print(ho);


        return 0;
    }*/

    // PALINDROME
  /*  int solution() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtTail(1);
        linkedList.addAtTail(2);
        linkedList.addAtTail(2);
//        linkedList.addAtTail(2);
//        linkedList.addAtTail(2);
        linkedList.addAtTail(2);
        linkedList.addAtTail(1);
//        linkedList.addAtTail(4);
        linkedList.print();

        System.out.println("");
//        if (head.next == null) return false;

      *//*  MyLinkedList.Node r = head, h = head;
        while (h.next != null) {
            MyLinkedList.Node tmp = h.next;
            h.next = h.next.next;
            tmp.next = r;
            r = tmp;
        }*//*


        // test reverse function
//        MyLinkedList.Node newHead = reverse(head, head);
//        linkedList.print(newHead);

        MyLinkedList.Node head = linkedList.head;
        MyLinkedList.Node h = head, s = null;

        int l = 1;
        while (head.next != null) {
            head = head.next;
            l++;
        }

        head = h;

        int p = l/2;
        int i = 1;
        while (head.next != null) {
            if (i == p) {
                if (l % 2 == 0) {
                    s = head.next;
                } else {
                    s = head.next.next;
                }
                head.next = null;
                head = reverse(h, h);
            }


            if (s!= null && head.value != s.value) {
                System.out.println("F");
                return 0;
            }

            i++;
            head = head.next;
            if (i > p) s = s.next;
        }

//        System.out.println("T");


        System.out.println(head.value == s.value);

        return 0;
    }

    MyLinkedList.Node reverse(MyLinkedList.Node head, MyLinkedList.Node newHead) {
        if (head.next == null) return newHead;

        MyLinkedList.Node tmp = head.next;
        head.next = head.next.next;
        tmp.next = newHead;

        return reverse(head, tmp);
    }*/

    //  MERGE TWO SORTED-LIST
    int solution() {
        MyLinkedList list1= new MyLinkedList(), list2 = new MyLinkedList();
        list1.addAtTail(1);
        list1.addAtTail(2);
        list1.addAtTail(4);

        list2.addAtTail(1);
        list2.addAtTail(3);
        list2.addAtTail(4);


        list1.print();
        System.out.println("");
        list2.print();
        System.out.println("");

        MyLinkedList mergeList = new MyLinkedList(true);
        MyLinkedList.Node head1 = list1.head;
        MyLinkedList.Node head2 = list2.head;

/*        while (true) {
            if (head1 != null) {
                mergeList.addAtTail(head1.value);
                head1 = head1.next;
            }

            if (head2 != null) {
                mergeList.addAtTail(head2.value);
                head2 = head2.next;
            }

            if (head1 == null && head2 == null) break;
        }*/

        MyLinkedList.Node head = mergeList.head;
        MyLinkedList.Node r = head;
        while (true) {
            if (head1.value < head2.value) {
                head.next = head1;
                head1 = head1.next;
                head = head.next;

                head.next = head2;
                head2 = head2.next;
                head = head.next;
            } else {
                head.next = head2;
                head2 = head2.next;
                head = head.next;

                head.next = head1;
                head1 = head1.next;
                head = head.next;
            }

            if (head1 == null && head2 == null) break;
        }

        mergeList.print(r.next);
        System.out.println("");


        return 0;
    }
}
