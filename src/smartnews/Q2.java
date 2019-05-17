package smartnews;

import java.util.HashSet;
import java.util.Set;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 3/7/19 - 14:19.
 * @organization VED
 */

public class Q2 {

    public int solution(int[] a) {
//        int[] A = {5, 4, 4, 5, 0, 12};
//        int[] A = {5, 4, 4, 5, 3, 3, 3, 5, 4, 12};
//        int[] A = {1, 1, 1, 2, 2, 2, 1, 1, 2, 2, 6, 2, 1, 8};
//        int[] A = {5};
//        int[] A = {5, 5, 5, 4};
        int[] A = {1, 2, 2, 4, 2, 4, 4, 1};
//        int[] A = {1, 2, 2, 2, 4, 4};
//        int[] A = {1, 2, 3};
//        int[] A = {5, 4, 4, 5, 0, 12};
//        int[] A = {5, 4, 4, 5, 0, 12};
        int N = A.length;
        int count = 0;
        int max = 0;
        int pivot = 0;
        int pivot2 = 0;


        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (!temp.add(A[i])) {
               count++;
            } else {
                if (temp.size() <= 2) {
                    pivot = i;
                    count++;
                } else {
                    temp.clear();
                    pivot2 = i - 1;
                    temp.add(A[pivot]);
                    i = pivot2;
                    count = 1 + pivot2 - pivot;
                }
            }

            if (count > max) {
                max = count;
            }

        }

        System.out.println("max = " + max);
        return 0;
    }
}
