package lc;

import java.util.*;

public class TwoArray {

    public int solution() {
//        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
/*
        int[] nums1 = {3, 1, 2}, nums2 = {1, 1};
        int[] result = intersect(nums1, nums2);
        for (int i : result) {
            System.out.print(i + " ");
        }
*/

        int nums[] = {99, 99}, k = 2;
        System.out.print(containsNearbyDuplicate(nums, k));

        return 0;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0, l = Math.min(nums1.length, nums2.length);
        int r[] = new int[l];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[i]) {
                r[k] = nums1[i];
                i++;
                j++;
                k++;
            } else if (nums1[i] < nums2[i]) {
                i++;
            } else {
                j++;
            }
        }

        int nr[] = new int[k];
        for (int t = 0; t < k; t++) {
            nr[t] = r[t];
        }

        return nr;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) + k >= i) return true;
            map.put(nums[i], i);
        }


        return false;
    }
}
