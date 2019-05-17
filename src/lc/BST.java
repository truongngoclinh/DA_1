package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 1/15/19 - 10:41.
 * @organization VED
 */

public class BST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int solution() {
//        System.out.println(isValidBST());
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
//        System.out.println(isValidBST(root));
//        interator(root);
        searchBST(root, 6);
        return 0;
    }

    // VALID BST

    public boolean isValidBST(TreeNode root) {
        List<Integer> order = new ArrayList<>();
//        inorder(order, root);
        Stack<TreeNode> s = new Stack<>();
        TreeNode c = root;
        while (c != null || !s.empty()) {
            if (c != null) {
                s.push(c);
                c = c.left;
            } else {
                c = s.pop();
                System.out.println("add value: " + c.val);
                order.add(c.val);
                c = c.right;
            }
        }

        System.out.println("in-order traversal output: " + order.size());
        for (int i = 0; i < order.size() - 1; i++) {
            System.out.print(" " + order.get(i));
        }

        for (int i = 0; i < order.size() - 1; i++) {
            if (order.get(i) > order.get(i + 1)) return false;
        }


        return true;
    }

    private void inorder(List<Integer> r, TreeNode root) {
        if (root.left != null) inorder(r, root.left);
        r.add(root.val);
        if (root.right != null) inorder(r, root.right);
    }

    public boolean isValidBST() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
//        isValid(root, null, null);
        List<Integer> order = new ArrayList<>();
//        inorder(root, order);

        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        while (root != null && !s.empty()) {
//            while (root != null) {
//               s.push(root);
//               root = root.left;
//            }
//            root = s.pop();
//            order.add(root.val);
//            if (pre != null && pre.val >= root.val) return false;
//            pre = root;
//            root = root.right;
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                root = s.pop();
//                order.add(root.val);
//                if (pre != null) {
//                    order.add(pre.val);
//                    System.out.print(pre.val + " ");
//                }
//                if (pre != null && root.val <= pre.val) return false;
                pre = new TreeNode(root.val);
                root = root.right;
            }
        }

        for (int i : order) {
            System.out.print(i + " ");
        }

        for (int i = 0; i < order.size() - 1; i++) {
            if (order.get(i) > order.get(i + 1)) return false;
        }


        return true;
    }


    private boolean isValid(TreeNode node, Integer l, Integer h) {
        if (l != null && node.val <= l) return false;
        if (h != null && node.val >= h) return false;

        boolean leftValid = node.left == null ? true : isValid(node.left, node.val, h);
        if (leftValid) {
            boolean rightValid = node.right == null ? true : isValid(node.right, l, node.val);
            return rightValid;
        } else {
            return false;
        }
    }

    private void inorder(TreeNode node, List<Integer> r) {
        if (node.left != null) inorder(node.left, r);
        r.add(node.val);
        if (node.right != null) inorder(node.right, r);
    }

    private int interator(TreeNode root) {
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next());
        }

        return 0;
    }


    class BSTIterator {
        private Stack<TreeNode> s;

        public BSTIterator(TreeNode root) {
            s = new Stack<>();
            pushAll(root);
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = s.pop();
            pushAll(node.right);
            return node.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !s.isEmpty();
        }

        private void pushAll(TreeNode node) {
            for (; node != null; s.push(node), node = node.left);
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null && cur.val != val) {
            if (val > cur.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        System.out.println(cur != null ? cur.val : "NULL");

        return cur;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (val > cur.val) {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    break;
                }

                cur = cur.right;
            } else {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                }

                cur = cur.left;
            }
        }

        return root;
    }
}
