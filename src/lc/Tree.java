package lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 9/30/18 - 22:56.
 * @organization VED
 */

public class Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

   /* // TREE TRAVERSAL - PRE, IN, POST - INTERATIVE, RECURSIVE
    int solution() {
        *//*
              1
            /   \
         null    2
               /   \
              3     4
            /
           5

         pre: 1 2 3 5 4
         in: 1 5 3 2 4
         post: 5 3 4 2 1
         *//*
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(5);

//        List<Integer> result = preorderTraversal(root);
//        List<Integer> result = inorderTraversal(root);
        List<Integer> result = postorderTraversal(root);
        for (Integer i : result) {
            System.out.print(i + " ");
        }


        return 0;
    }*/

    /* PRE-ORDER */
    // stack
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<>();
//        pre(root, r);
        Stack<TreeNode> s = new Stack<>();
        TreeNode c = root;
        while (c != null || !s.isEmpty()) {
            if (c != null) {
                s.push(c);
                r.add(c.val); // print firstly while traversal
                c = c.left;
            } else {
                c = s.pop();
                c = c.right;
            }
        }

        return r;
    }

    // recursive
    private void pre(TreeNode root, List<Integer> r) {
        r.add(root.val);
        if (root.left != null) pre(root.left, r);
        if (root.right != null) pre(root.right, r);
    }

    /* IN-ORDER */
    // stack
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<>();
//        in(root, r);
        Stack<TreeNode> s = new Stack<>();
        TreeNode c = root;
        while (c != null || !s.isEmpty()) {
            if (c != null) {
                s.push(c);
                c = c.left;
            } else {
                c = s.pop();
                r.add(c.val); // just print the stack
                c = c.right;
            }
        }

        return r;
    }

    // recursive
    private void in(TreeNode root, List<Integer> r) {
        if (root.left != null) in(root.left, r);
        r.add(root.val);
        if (root.right != null) in(root.right, r);
    }


    /* POST-ORDER */
    // stack
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> r = new LinkedList<>(); // reversal pre-order (use linkedlist to addFirst())
//        post(root, r);
        Stack<TreeNode> s = new Stack<>();
        TreeNode c = root;
        while (c != null || !s.isEmpty()) {
            if (c != null) {
                s.push(c); // so go right first
                r.addFirst(c.val);
                c = c.right;
            } else {
                c = s.pop();
                c = c.left;
            }
        }

        return r;
    }

    // recursive
    private void post(TreeNode root, List<Integer> r) {
        if (root.left != null) post(root.left, r);
        if (root.right != null) post(root.right, r);
        r.add(root.val);
    }


   /* // BFS - TREE LEVEL ORDER
    int solution() {
        *//*
              1
            /   \
         null    2
               /   \
              3     4
            /
           5

        [[1], [2], [3,4], [5]]
         *//*
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(5);

        List<List<Integer>> r = levelOrder(root);

        for (List<Integer> l : r) {
            System.out.print("[");
            for (int i : l) {
                System.out.print(i + ",");
            }
            System.out.print("], ");
        }


        return 0;
    }*/

    public List<List<Integer>> levelOrder(TreeNode r) {
        int size;
        List<List<Integer>> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(r);
        while (!q.isEmpty()) {
            List<Integer> lv = new ArrayList<>();
            size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode c = q.poll();
                lv.add(c.val);
                if (c.left != null) q.offer(c.left);
                if (c.right != null) q.offer(c.right);
            }
            l.add(lv);
        }


        return l;
    }


    // TOP-DOWN, BOTTOM-UP
    /*int solution() {
     *//*
              1
            /   \
         null    2
               /   \
              3     4
            /
           5

        [[1], [2], [3,4], [5]]
         *//*
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(5);

//        System.out.println(topdown(root, 0));
//        System.out.println(bottomup(root));
        System.out.println(isSymmetric(root));

        return 0;
    }*/

    public int topdown(TreeNode root, int depth) {
        if (root == null) return depth;
        return (Math.max(topdown(root.left, depth + 1), topdown(root.right, depth + 1)));
    }

    public int bottomup(TreeNode root) {
        if (root == null) return 0;
        int left = bottomup(root.left);
        int right = bottomup(root.right);
        return Math.max(left, right) + 1;
    }

    // SYMMETRIC
    /*  int solution() {
     *//*
              1
            /   \
           2     2
          / \   / \
         3   4 4   3

        *//*

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
//
//        List<Integer> pl = new ArrayList<>(), il = new ArrayList<>();
//        List<Integer> pr = new ArrayList<>(), ir = new ArrayList<>();
//        traversalLeft(root, pl, il);
//        traversalRight(root, pr, ir);
//        if (pl.size() != pr.size()) {
//            System.out.println("false");
//            return 0;
//        }
//        for (int i = 0; i < pl.size(); i++) {
//            if (pl.get(i) != pr.get(i)) {
//                System.out.println("false");
//                return 0;
//            }
//
//            if (il.get(i) != ir.get(i)) {
//                System.out.println("false");
//                return 0;
//            }
//        }
//
//        System.out.println("true");

//        System.out.println(isSymmatric(root.left, root.right));


        System.out.println(isSymmatric(root));
        return 0;
    }*/

    boolean isSymmatric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        int size;
        while (!q.isEmpty()) {
            size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode l = q.poll();
                TreeNode r = q.poll();
                if (l == null || r == null) {
                    if (l != r) return false;
                    else continue;
                }
                if (l.val != r.val) return false;
                q.offer(l.left);
                q.offer(r.right);
                q.offer(l.right);
                q.offer(r.left);
            }
        }

        return true;
    }


    boolean isSymmatric(TreeNode r, TreeNode l) {
        if (r == null || l == null) {
            return r == l;
        }
        if (r.val == l.val) {
            return isSymmatric(r.left, l.right) && isSymmatric(r.right, l.left);
        }
        return false;
    }

    public void traversalLeft(TreeNode root, List<Integer> pl, List<Integer> il) {
        if (root != null) pl.add(root.val);
        if (root.left != null) traversalLeft(root.left, pl, il);
        if (root != null) il.add(root.val);
        if (root.right != null) traversalLeft(root.right, pl, il);
    }

    public void traversalRight(TreeNode root, List<Integer> pl, List<Integer> il) {
        if (root != null) pl.add(root.val);
        if (root.right != null) traversalRight(root.right, pl, il);
        if (root != null) il.add(root.val);
        if (root.left != null) traversalRight(root.left, pl, il);
    }

    // HAS PATH SUM
    int solution() {
        hasPathSum();
        return 0;
    }

    public boolean hasPathSum() {
        /*
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
         */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        int sum = 0;
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> p = new Stack<>();
        TreeNode cur = root;
        while (!s.empty() || cur != null) {
            if (cur != null) {
                s.push(cur);
                p.add(cur.val);
                if (sum(p) == 22 && cur.left == null && cur.right == null) System.out.println("BINGO");
                cur = cur.left;
            } else {
                cur = s.pop();
                if (p.peek() == cur.val) {
                    p.pop();
                }
                cur = cur.right;
            }
        }

//        System.out.println(treeSum(root, 22, 0));
        return true;
    }

    private int sum(Stack<Integer> l) {
        int t = 0;
        for (int i : l) {
            t += i;
        }

        return t;
    }


    public boolean treeSum(TreeNode root, int sum, int cur) {
        if (root != null) cur += root.val;
        if (sum == cur) {
            System.out.println("BINGO");
        }

        return treeSum(root.left, sum, cur) && treeSum(root.right, sum, cur);
    }
}
