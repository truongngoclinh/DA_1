package grab;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 4/7/19 - 11:05.
 * @organization VED
 */

public class Test2 {
    public int solution(int[] A, int K, int L) {
        int n = A.length;
        if (K + L > n) return -1;
        int l2r = left2Right(A, K, L);
        reverse(A);
        int r2l = left2Right(A, K, L);
        return Math.max(l2r, r2l);
    }

    private int left2Right(int[] a, int k, int l) {
        int n = a.length;

        int[] maxKSum = new int[n];

        int cur = 0;
        for (int i = 0; i < k; i++) cur += a[i];
        maxKSum[k-1] = cur;
        for (int i = k; i < n; i++) {
            cur = cur + a[i] - a[i-k];
            maxKSum[i] = Math.max(maxKSum[i-1], cur);
        }


        cur = 0;
        for (int i = k; i <= k + l - 1; i++) cur += a[i];

        int res = maxKSum[k-1] + cur;

        for (int i = k + l; i < n; i++) {
            cur = cur + a[i] - a[i-l];
            res = Math.max(res, maxKSum[i-l] + cur);
        }

        return res;
    }

    private void reverse(int[] a) {
        int n = a.length;
        for (int i = 0; i < n/2; i++) {
            int temp = a[i];
            a[i] = a[n-1-i];
            a[n-1-i] = temp;
        }
    }
}
