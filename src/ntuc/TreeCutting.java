package ntuc;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 1/31/19 - 14:27.
 * @organization VED
 */

public class TreeCutting {

    public int solution() {
        int[] a = {1,2,5,4} ;

        System.out.println("ways: " +solution(a));
        return 0;
    }

 /*   private int cutOneTree(int A[]) {
        if (A.length == 0) return 0;
        int l = A.length;

        int idx = 1;
        while (idx < l && A[idx] >= A[idx-1]) idx++;

        if (idx >= l - 1) {
            if (A[l-1] < A[l-2]) {
                return 2;
            } else {
                return l;
            }
        }
        if (A[idx+1] < A[idx-1] && A[idx+1] < A[idx]) return 0;

        int dip = idx;
        int prev = -1;
        if (idx >= 2) {
            prev = A[idx-2];
        }

        while (idx < l && A[idx] >= A[idx-1]) idx++;
        if (idx != l) return 0;

        if (prev != -1 || A[dip] >= A[prev]) {
            return 2;
        } else {
            return 1;
        }
    }

    private int max(int a[]) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max <= a[i]) max = a[1];
        }

        return max;
    }
*/

    public int solution(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (a[i] < a[i-1]) {
                int res = 0;
                if (checkNonDecreasing(a, i)) res++;
                if (checkNonDecreasing(a, i-1)) res++;
                return res;
            }
        }

        return a.length;
    }

    private boolean checkNonDecreasing(int[] a, int skipIdx) {
        int n = a.length;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i == skipIdx) continue;
            if (a[i] < prev) return false;
            prev = a[i];
        }
        return true;
    }
}
