package lc.onemonthchallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OneMonth {

    public int solution() {

//        int a[] = {4, 1, 2, 1, 2};
//        System.out.print(singleNumber(a));

//        int a[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int a[] = {-2, 1, -3, 6, -9, 2, 1, -5, 4};
//        int a[] = {-2, -1};
//        int a[] = {-1,1,2,1};
//        System.out.print("Result: " + maxSubArray(a));

//        int a[] = {0, 1, 0, 3, 12};
//        int a[] = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
//        moveZeroes(a);

//        int a[] = {7, 1, 5, 3, 6, 4};
//        int a[] = {7,6,4,3,1};
//        int a[] = {1, 2, 3, 4, 5};
//        int a[] = {1, 2};
//        System.out.print(maxProfit(a));

        String a[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(a);

        return 0;
    }

    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];

        int r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            r ^= nums[i];
        }

        return r;
    }


    //        int a[] = {4, 1, 2, 1, 2};
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = nums[0], sum = nums[0], r = nums[0], l = nums.length;

        for (int i = 1; i < l; i++) {
            sum += nums[i];
            if (nums[i] > max) {
                max = nums[i];
            }
            if (sum > r) r = sum;
            if (nums[i] > 0) {
                if (sum - nums[i] < 0) sum = nums[i];
            } else {
                if (i + 1 < l && nums[i + 1] > 0 && sum < 0) sum = 0;
            }
        }

        return Math.max(max, r);
    }


    public void moveZeroes(int[] nums) {
       /* int p1 = -1, l = nums.length;

        for (int i = 0; i < l; i++) {
            if (nums[i] == 0) {
                if (p1 == -1) {
                    p1 = i;
                }
            } else {
                if (p1 != -1) {
                    nums[p1] = nums[i];
                    nums[i] = 0;
                    if (p1 + 1 < l && nums[p1 + 1] == 0) {
                        p1++;
                    }
                }
            }
        }*/

        int i = -1, j = 0, l = nums.length;
        while (++i < l) if (nums[i] != 0) nums[j++] = nums[i];
        while (j < l) nums[j++] = 0;


        System.out.println("Result: ");
        for (int k = 0; k < nums.length; k++) {
            System.out.print(nums[k] + " ");
        }
    }


    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int s = 0, i = 0, l = prices.length;
        while (++i < l) {
            s += Math.max((prices[i] - prices[i - 1]), 0);
        }

        return s;

       /* int profit = 0, entry = -1, i = 0, l = prices.length;

        while (++i < l) {
            if (prices[i] > prices[i - 1]) {
                if (entry == -1) {
                    entry = prices[i - 1];
                }
                if (i == l - 1) {
                    profit += prices[i] - entry;
                }
            } else {
                if (entry != -1) {
                    profit += prices[i - 1] - entry;
                    entry = prices[i];
                }
            }
        }*/

      /*  while (++i < l) {
            if (prices[i] > prices[j]) {
                while (++i < l) {
                    if (prices[i] < prices[i - 1]) {
                        p += prices[i - 1] - prices[j];
                        j = i;
                    }
                    if (i == l - 1) {
                        p += prices[i] - prices[j];
                    }
                }
            } else {
                j = i;
            }
        }
        return p;

       */
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> r = new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();

        for (String str : strs) {
            String hash = hash(str);
            List<String> v = m.getOrDefault(hash, new ArrayList<>());
            v.add(str);
            m.put(hash, v);
        }

        for (List<String> list : m.values()) {
            r.add(list);
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println("");
        }

        return r;
    }

    private String hash(String str) {
        int i = 0, s = 0, m = 1;
        while (i++ < str.length()) {
            int t = str.charAt(i - 1);
            m *= t;
            s += t;
        }

        return String.valueOf(s + m);
    }

 /*   //  hash with prime array
    private String hash(String str) {

    }*/

  /*   //  hash with flag count charactes in array: c - 'a'
    private String hash(String str) {

    }*/
}
