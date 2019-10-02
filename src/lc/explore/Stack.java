package lc.explore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 10/1/18 - 09:46.
 * @organization VED
 */

public class Stack {
/*
    public int solution() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
//        stack.pop();
        stack.print();
        System.out.println("");
        System.out.println(stack.top());
        System.out.println(stack.getMin());

        return 0;
    }*/

    class MinStack {
        int[] data;
        int head;

        public void print() {
            for (int i = 0; i <= head; i++) {
                System.out.print(data[i] + " ");
            }
        }

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new int[10000];
            head = -1;
        }

        public void push(int x) {
            data[++head] = x;
        }

        public void pop() {
            head--;
        }

        public int top() {
            return data[head];
        }

        public int getMin() {
            int min = data[0];
            for (int i = 1; i <= head; i++) {
                if (min > data[i]) {
                    min = data[i];
                }
            }

            return min;
        }
    }

    // VALID PARENTHESES
   /* int solution() {
        String s = "()[]{}";
//        if (s.isEmpty()) return true;

       *//* java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else if (stack.isEmpty() || c != stack.pop()) {
                System.out.println("false");
                break;
            }
        }

//        return stack.isEmpty();
        System.out.println(stack.isEmpty());
*//*
       char[] sa = new char[s.toCharArray().length];
       int head = 0;
       for (char c : s.toCharArray()) {

           if (c == '{') sa[head++] = '}';
           else if (c == '[') sa[head++] = ']';
           else if (c == '(') sa[head++] = ')';
           else if (head == 0|| c != sa[--head]) {
               System.out.println("false");
               break;
           }
       }

        System.out.println(head == 0);

       *//* char[] sarray = s.toCharArray();
        stack.push(sarray[0]);

        while (!stack.isEmpty()) {
            for (int i = 1; i < sarray.length; i++) {
                char c = sarray[i];
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                char t = stack.peek();
                if (isPaired(t, c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            System.out.println(stack.isEmpty() ? "true" : "false");
        }

        System.out.println("true");*//*

        return 0;
    }*/

    boolean isPaired(char c1, char c2) {
        StringBuilder builder = new StringBuilder();
        builder.append(c1);
        builder.append(c2);
        String str = builder.toString();

        if (str.contains("{") && str.contains("}")) {
            return true;
        }
        if (str.contains("[") && str.contains("]")) {
            return true;
        }
        if (str.contains("(") && str.contains(")")) {
            return true;
        }

        return false;
    }


/*    // DAILY TEMPs
    int solution() {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73}; // [1, 1, 4, 2, 1, 1, 0, 0].

        int l = T.length, r[] = new int[l], s[] = new int[l], top = -1;
        for (int i = 0; i < l; i++) {
            while (top > -1 && T[i] > T[s[top]]) {
                int idx = s[top--];
                r[idx] = i - idx;
            }

            s[++top] = i;
        }


        for (int i : r) {
            System.out.print(i + " ");
        }

        return 0;
    }*/


    // TARGET SUM
    /*
    -1+1+1+1+1 = 3
    +1-1+1+1+1 = 3
    +1+1-1+1+1 = 3
    +1+1+1-1+1 = 3
    +1+1+1+1-1 = 3
     */
   /* int solution() {
//        int[] nums = {1, 1, 1, 1, 1};
        long t = System.currentTimeMillis();
//        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
//        int[] nums = {1, 0};
        int[] nums = {42,24,30,14,38,27,12,29,43,42,5,18,0,1,12,44,45,50,21,47, 38};
        int S = 38, r;

        Set<String> v = new HashSet<>();
        r = DFS('+', S, v, "", nums) + DFS('-', S, v, "", nums);

        System.out.println("r = " + r + "\nt = " + (System.currentTimeMillis() - t));

        return 0;
    }

    int DFS(char n, int S, Set v, String cur, int[] nums) {
        int c = cur.length();
        while (c < nums.length) {
            if (nums[c] == 0) {
                cur += '^';
                c++;
            } else {
                break;
            }
        }

        if (c < nums.length) {
            cur += n;
            c++;
        }

        if (!v.contains(cur)) {
            v.add(cur);
            if (cur.length() == nums.length) {
                if (sum(cur, nums) == S) return mul(cur);
                else return 0;
            }

            return DFS('+', S, v, cur, nums) + DFS('-', S, v, cur, nums);
        }

        return 0;
    }

    int mul(String cur) {
        int r = 1;
        for (char s : cur.toCharArray()) {
            if (s == '^') {
                r *= 2;
            }
        }

        return r;
    }

    int sum(String cur, int[] nums) {
        int sum = 0;
        char[] ops = cur.toCharArray();
        for (int i = 0; i < nums.length; i++) {
            if (ops[i] == '+') {
                sum += nums[i];
            } else if (ops[i] == '-') {
                sum -= nums[i];
            } else {
                continue;
            }
        }

        return sum;
    }*/

 /*   int solution() {
        long t1 = System.currentTimeMillis();
        int[] nums = {42,24,30,14,38,27,12,29,43,42,5,18,0,1,12,44,45,50,21,47, 38};
//        int[] nums = {1, 0};
        int S = 38, r;
        r = dfs(nums, 0, S, 0);
        System.out.println("r = " + r + "\nt = " + (System.currentTimeMillis() - t1));

        return 0;
    }

    private int dfs(int[] nums, int sum, int target, int k) {
        if (nums.length == k) {
            return sum == target ? 1 : 0;
        }
        return dfs(nums, sum + nums[k], target, k + 1) +
                dfs(nums, sum - nums[k], target, k + 1);
    }*/
    /*

     */

    public Stack() {
    }

    // TRAVERSAL
    int solution() {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);


        List<Integer> r = new ArrayList<>();
        Set<TreeNode> v = new HashSet<>();
        java.util.Stack<TreeNode> s = new java.util.Stack<>();
        // IN
//        inorder(root, r);
  /*      s.push(root);
        while (!s.empty()) {
            TreeNode c = s.peek();
            if (c.left != null && !v.contains(c.left)) s.push(c.left);
            else {
                TreeNode n = s.pop();
                v.add(n);
                r.add(n.val);

                if (n.right != null) {
                    s.push(n.right);
                }
            }
        }*/
//        s.push(root);
//        TreeNode cur = root;
//        while (cur != null || !s.isEmpty()) {
//            while (cur != null) {
//                s.push(cur);
//                cur = cur.left;
//            }
//
//            cur = s.pop();
//            r.add(cur.val);
//            cur = cur.right;
//        }

        // PRE
//        preorder(root, r);
     /*   s.push(root);
        while (!s.empty()) {
            TreeNode n = s.peek();
            if (!v.contains(n)) {
                r.add(n.val);
                v.add(n);
            }

            if (n.left != null && !v.contains(n.left)) s.push(n.left);
            else {
                n = s.pop();
                if (n.right != null) s.push(n.right);
            }
        }*/
   /*     TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                r.add(cur.val);
                cur = cur.left;
            }

            cur = s.pop();
            cur = cur.right;
        }*/


        // POST ORDER
//        postorder(root, r);
        LinkedList<Integer> rl = new LinkedList<>();
        TreeNode cur = root;
        while (!s.isEmpty() && cur != null) {
            if (cur != null) {

            }
        }

        for (int i : rl) {
            System.out.print(i + " ");
        }

//        for (int i : r) {
//            System.out.print(i + " ");
//        }

        return 0;
    }

    private void inorder(TreeNode c, List<Integer> r) {
        if (c.left != null) inorder(c.left, r);
        r.add(c.val);
        if (c.right != null) inorder(c.right, r);
    }

    private void preorder(TreeNode n, List<Integer> r) {
        r.add(n.val);
        if (n.left != null) preorder(n.left, r);
        if (n.right != null) preorder(n.right, r);
    }

    private void postorder(TreeNode n, List<Integer> r) {
        if (n.left != null) postorder(n.left, r);
        if (n.right != null) postorder(n.right, r);
        r.add(n.val);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }


}
