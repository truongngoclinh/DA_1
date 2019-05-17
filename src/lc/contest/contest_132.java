package lc.contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 4/14/19 - 09:39.
 * @organization VED
 */

public class contest_132 {
    int solution() {
        int N = 3;
        System.out.println(divisorGame(N));

//        TreeNode root = new TreeNode(8);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(6);
//        root.left.right.left = new TreeNode(4);
//        root.left.right.right = new TreeNode(7);
//        root.right = new TreeNode(10);
//        root.right.right = new TreeNode(14);
//        root.right.left = new TreeNode(13);
//
//        System.out.println(maxAncestorDiff(root));
        int A[] = {9, 4, 7, 2, 10};
        System.out.println("longest = " + longestArithSeqLength(A));

        return 0;
    }

    public int longestArithSeqLength(int[] A) {
        int k = 0, i, j;
        int l = A.length;
        int diff, s, count = 0;
        List<Integer> result = new ArrayList<>();
        while (k < l - 2) {
            s = A[k];
            i = k + 1;
            while (i < l - 1) {
                diff = A[i] - s;
                count = 1;
                int s1 = A[i];
                j = i + 1;
                while (j < l) {
                    if (A[j] - s1 == diff) {
                        s1 = A[j];
                        count++;
                        System.out.println("increased count = " + count);
                    }

                    j++;
                }
                i++;
                result.add(count);
                System.out.println("add count: " + count);
            }
            k++;
        }

        int max = 0;
        for (int r : result) {
           if (max < r) max = r;
        }

        return max+1;
    }


    public boolean divisorGame(int N) {
        int count = 0;
        return N % 2 == 0;


//        return true;
    }

    private boolean isPrime(int n) {
        if (n > 2) {
            int max = (n % 2);
            for (int i = 2; i <= max; i++) {
                if (n % i == 0) return false;
            }
        }

        return true;
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public int maxAncestorDiff(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        preOrder(root, vals, root.val, root.val);

        int max = 0;
        for (int i : vals) {
            System.out.print(i + " ");
            if (max < i) max = i;
        }

        System.out.println("maxDiff = " + max);
        return 0;
    }

    void preOrder(TreeNode root, List<Integer> vals, int min, int max) {
        if (root != null) {
            vals.add(getMaxDiff(min, max, root.val));
            if (min > root.val) min = root.val;
            if (max < root.val) max = root.val;
        }
        if (root.left != null) preOrder(root.left, vals, min, max);
        if (root.right != null) preOrder(root.right, vals, min, max);
    }

    int getMaxDiff(int min, int max, int val) {
        return Math.max(Math.abs(min - val), Math.abs(max - val));
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
