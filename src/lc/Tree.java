package lc;

import java.util.ArrayList;
import java.util.List;

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

    int solution() {
        // PRE-ORDER
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = preorderTraversal(root);
        for (Integer i : result) {
            System.out.print(i + " ");
        }


        return 0;
    }

    // PRE-ORDER
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        while (true) {
            if (root != null) {
                r.add(root.val);
            }

            while (root.left != null) {
                root = root.left;
                while (root.left != null) {

                    root = root.left;
                }
            }


            return r;
        }
    }
}
