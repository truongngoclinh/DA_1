package lc.explore;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 10/1/18 - 09:46.
 * @organization VED
 */

public class Queue {
    /*int solution() {
     */

    /**
     * Your MyCircularQueue object will be instantiated and called as such:
     * MyCircularQueue obj = new MyCircularQueue(k);
     * boolean param_1 = obj.enQueue(value);
     * boolean param_2 = obj.deQueue();
     * int param_3 = obj.Front();
     * int param_4 = obj.Rear();
     * boolean param_5 = obj.isEmpty();
     * boolean param_6 = obj.isFull();
     *//*
        MyCircularQueue queue = new MyCircularQueue(3);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
//        for (int i = 1; i <= 5; i++) {
//           queue.enQueue(i) ;
//        }
//
//        System.out.println(queue.enQueue(6));
//        System.out.println(queue.Front());
//        System.out.println(queue.enQueue(5));
//        queue.deQueue();
//        System.out.println(queue.Front());
//        System.out.println(queue.Rear());
//        System.out.println(queue.Rear());
//        queue.deQueue();
//        System.out.println(queue.enQueue(5));
//        System.out.println(queue.Rear());
//        queue.deQueue();
//        System.out.println(queue.Front());
//        queue.deQueue();
//        queue.deQueue();
//        System.out.println(queue.enQueue(6));
//        queue.deQueue();
//        queue.deQueue();
//        queue.enQueue(1);

        queue.print();

        return 0;
    }*/

    class MyCircularQueue {
        int[] data;
        int head;
        int tail;
        int size;

        public void print() {
            if (data.length > 0) {
                for (int i = 0; i < data.length; i++) {
                    System.out.print(data[i] + " ");
                }
            }
        }


        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            size = k;
            data = new int[size];
            head = tail = -1;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (isFull()) return false;
            if (isEmpty()) head = 0;
            tail = (tail + 1) % size;
            data[tail] = value;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (isEmpty()) return false;
            if (head == tail) {
                head = tail = 1;
                return true;
            }
            head = (head + 1) % size;
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (isEmpty()) return -1;
            return data[head];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (isEmpty()) return -1;
            return data[tail];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return head == -1;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return (tail + 1) % size == head;
        }
    }

   /* // ISLAND - BFS
    int solution() {
        char grid[][] = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '0', '0', '0', '0'},
        };
        System.out.println(grid.length + " - " + grid[0].length);

        char[][] g = grid;
        if (g == null || g.length == 0) return 0;
        int m = g.length, n = g[0].length, r = 0;

        // DFS recursive
   *//*     for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == '1') {
                    scan(g, i, j);
                    r++;
                }
            }
        }

        System.out.println("Number of islands: " + r);*//*


        java.util.Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == '1') {
                    mark(q, g, i, j);
                    while (!q.isEmpty()) {
                        Node head = q.poll();
                        if (head.y < n - 1) {
                            mark(q, g, head.x, head.y + 1);
                        }
                        if (head.y > 0) {
                            mark(q, g, head.x, head.y - 1);
                        }
                        if (head.x < m - 1) {
                            mark(q, g, head.x + 1, head.y);
                        }
                        if (head.x > 0) {
                            mark(q, g, head.x - 1, head.y);
                        }
                    }

                    r++;
                }

            }
        }

        System.out.println("number of islands = " + r);


        return 0;
    }*/

    private void mark(java.util.Queue q, char[][] g, int i, int j) {
        if (g[i][j] == '1') {
            q.offer(new Node(i, j));
            g[i][j] = 'x';
        }
    }

    private void scan(int[][] g, int i, int j) {
        if (i == g.length || j == g[0].length || i == -1 || j == -1) return;
        if (g[i][j] == '1') {
            g[i][j] = 'x';
            scan(g, i, j + 1);
            scan(g, i, j - 1);
            scan(g, i + 1, j);
            scan(g, i - 1, j);
        }
    }

    private class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    // BFS - Open the Lock - bidirectional seach to optimize
    /*public int solution() {
        String deadends[] = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";

        Set<String> d = new HashSet<>(Arrays.asList(deadends));
        String t = target;
        java.util.Queue<String> q = new LinkedList<>();

        String h = "0000";
        q.offer(h);
        d.add(h);

        // BASIC
        int step = 0, size = 0;
        while (!q.isEmpty()) {
            size = q.size();
            for (int i = 0; i < size; i++) { // to calculate step
                h = q.poll();
                for (int j = 0; j < 4; j++) {
                    int k = h.charAt(j) - '0';   // convert chart to int
                    int pool[] = {(k + 1) % 10, ((k - 1) + 10) % 10};
                    for (int p : pool) {
                        String solution = h.substring(0, j) + p + h.substring(j + 1);
                        if (solution.equals(t)) {
                            step++;
                            System.out.println(step);
                            return step;
                        }

                        if (!d.contains(solution)) {
                            q.offer(solution);
                            d.add(solution);
                        }
                    }
                }
            }
            step++;
        }


        System.out.println(step);

        return 0;
    }*/


    // Perfect Square @TODO
    int solution() {
        int n = 12;




        return 0;
    }
}
