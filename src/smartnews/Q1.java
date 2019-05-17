package smartnews;

import java.util.*;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 3/7/19 - 15:22.
 * @organization VED
 */

public class Q1 {
    public int solution(int[] a) {
//        int[] A = {1, 4, 7, 3, 3, 5};
        int[] A = {1, 4, 7, 3, 3, 5};
        int n = A.length;

        Map<Integer, List<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            List<Integer> posList = posMap.getOrDefault(a[i], new ArrayList<>());
            posList.add(i);
            posMap.put(a[i], posList);
        }

        Arrays.sort(a);
        for (int i = 0; i < n;) {
            int tmp = a[i];
            int start = i;
            int end = start;
            while (end + 1 < n && a[end+1] == tmp) end++;


        }


        return 0;
    }

    private int findMaxDistance(int i, int j) {

        return 0;

    }
}
