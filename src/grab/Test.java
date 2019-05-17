package grab;

import java.lang.reflect.Array;
import java.util.*;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 4/7/19 - 09:44.
 * @organization VED
 */

public class Test {
    public static void main(String[] args) {
        System.out.println("ok");

//        int A[] = {6, 1, 4, 6, 3, 2, 7, 4};
        int A[] = {6, 1, 4, 6, 3, 2, 7, 4};
        int K = 3;
        int L = 2;

//        System.out.println(solution(A, K, L));
        System.out.println(new Test2().solution(A, K, L));
    }

    public static int solution(int[] A, int K, int L) {
        // write your code in Java SE 8
        int l = A.length;
        if (K + L >= l) return -1;

        Map<Integer, ArrayList<Integer>> kMap = new HashMap<>();
        Map<Integer, ArrayList<Integer>> lMap = new HashMap<>();
        ArrayList<Integer> kArray = new ArrayList<>();
        ArrayList<Integer> lArray = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            if (i + K < l) {
                int val = sum(A, i, K);
                kArray.add(val);
                ArrayList<Integer> list = kMap.getOrDefault(val, new ArrayList<>());
                list.add(i);
                kMap.put(val, list);
            }
            if (i + L < l) {
                int val = sum(A, i, L);
                lArray.add(val);

                ArrayList<Integer> list = lMap.getOrDefault(val, new ArrayList<>());
                list.add(i);
                lMap.put(val, list);
            }
        }


        Collections.sort(kArray, Collections.reverseOrder());
        Collections.sort(lArray, Collections.reverseOrder());

        int i = 0;
        while (i < l) {
            int tmpk = kArray.get(i);
            int tmpl = lArray.get(i);
            if (validated(tmpk, tmpl, kMap, lMap, K, L)) {
                return tmpk + tmpl;
            }
        }

        return -1;
    }

    private static boolean validated(int k, int l, Map<Integer, ArrayList<Integer>> kMap, Map<Integer, ArrayList<Integer>> lMap, int K, int L) {
        boolean isValidated = false;
        ArrayList<Integer> kIndexs = kMap.get(k);
        ArrayList<Integer> lIndexs = lMap.get(l);

        for (int i : kIndexs) {
            for (int j : lIndexs) {
                if (i + K <= l - L || i - K >= l + L) isValidated = true;
            }
        }

        return isValidated;
    }

    private static int sum(int[] A, int i, int K) {
        int sum = 0;
        for (int j = i; j < i + K; j++) {
            sum += A[j];
        }

        return sum;
    }
}
