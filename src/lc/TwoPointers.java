package lc;

import java.lang.reflect.Array;
import java.util.*;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 9/17/18 - 15:00.
 * @organization VED
 */

public class TwoPointers {
   /* public int solution() {
        String s = "A man, a plan, a canal: Panama";
//        String s = "hello";
        char[] sarr = s.toCharArray();

        int i = 0, j = s.length() - 1;
        while (i < s.length()) {
            sarr = swap(i, j, sarr);
            j--;
            i++;

            if (i >= j) break;
        }

        String result = new String(sarr);
        System.out.println(result);

        return 0;
    }

    private char[] swap(int i, int j, char[] arr) {
        if (arr[i] != arr[j]) {
            char tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }

        return arr;
    }
*/

  /*  public int solution() {
        int[] nums = {1, 4, 3, 2};

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[1];

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        Collections.sort(list);

        // or just Arrays.sort(nums) // change the initial array

        int sum = 0;
        for (int i = 0; i < list.size(); i = i + 2) {
            sum += list.get(i);
        }

        System.out.println(sum);

        return 0;
    }*/

    // FUCKING BUCKET SORT ....
   /* public int solution() {
        int[] nums = {1, 4, 3, 2};
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[1];

        int[] exist = new int[20001];

        for (int i = 0; i < nums.length; i++) {
            exist[nums[i] + 10000]++; // it can be a negative number
        }

        int sum = 0;
        boolean odd = true;
        for (int i = 0; i < exist.length; i ++) {
            while (exist[i] > 0) {
                if (odd) {
                    sum += i - 10000;
                }
                odd = !odd;
                exist[i] --;
            }
        }

        System.out.println(sum);

        return 0;
    }*/
/*
    public int solution() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int l = numbers.length;
        int[] result = new int[2];
*//*
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < l; i++) {
            hashMap.put(target - numbers[i], i);
        }

        for (int i = 0; i < l; i++) {
            int tmp = hashMap.getOrDefault(numbers[i], -1);
            if (tmp > -1) {
                result[0] = ++i;
                result[1] = ++tmp;
                break;
            }
        }*//*


       *//* int i = 0, j = l - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) i++;
            else if(sum > target) j--;
            else return new int[]{++i, ++j};
        }*//*


        System.out.println(Arrays.toString(result));


        return 0;
    }*/


    //REMOVE ELEMENT WITH O(1) EXTRA MEMORY
 /*   public int solution() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2, 2};

   *//*     for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " - ");
        }

        System.out.println("");
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " - ");
        }*//*

        int k = 0, val = 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
              nums[k] = nums[++i];
            }
        }

        System.out.println("");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " - ");
        }


        return k;
    }*/


/*    // MAX CONSECUTIVE ONE
    public int solution() {
//        int[] nums = {1, 1, 0, 1, 1, 1, 0};
//        int[] nums = {1, 1, 0, 1};
//        int[] nums = {1, 1};
        int[] nums = {1};
        int result = 0;

    *//*    for (int i = 0; i < nums.length; i++) {
            int k = 0;
            if (nums[i] == 1) {
                while (nums[i] == 1) {
                    k++;
                    i++;
                    if (i == nums.length) break;
                }
            }

            if (result < k) result = k;
        }

        System.out.println("result = " + result);
        *//*

        int sum = 0, k = 0, l = nums.length;
        for (int i = 0; i < l; i++) {
            sum += nums[i];
            if (nums[i] == 0 || i == l - 1) {
                if (k < sum) k = sum;
                sum = 0;
            }
        }


        System.out.println(k);

        return 0;
    }*/

    // MINIUM SUBARRAY
   /* public int solution () {
//        int s = 7, nums[] = {2,3,1,2,4,3};
        int s = 11, nums[] = {1,2,3,4,5};

     *//*   int result = 0, i = 0, j, l = nums.length;
        int sum;
        while (i < l) {
            j = i;
            sum = 0;
            while (sum < s && j < l) {
                sum += nums[j];
                j++;
            }
            if (sum >=s && (result == 0 || result > j-i)) {
                result = j - i;
            }

            i++;
        }*//*

        int result = 0;
        int k = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                if (result == 0 || result > i-k+1) {
                    result = i - k+1;
                }
                sum -= nums[k++];
            }
        }


        System.out.println(result);

        return 0;
    }*/

    public int solution() {
        int[] input = {4, 3, 7, 5, 2, 4, 3, 8, 6, 0, 9, 5};
//        int[] input = {5, 4, 3, 1, 2};
        int max = 0, l = input.length, i = 0, j = 0, k = Integer.MIN_VALUE;

   /*     while (i < l) {
            j = i + 1;
            while (j < l && input[i] > input[j]) {
                int t = input[j] - input[i];
                if (t > k) max = Math.max(max, j-i+1);
                if (k == 0 || k < t) k = t;

                j++;
            }

            if (j != l) max = Math.max(max, j-i+1);

            i++;
        }*/

        k = input[0];
        max = 0;
        j = 0;
        for (i = 1; i < l; i++) {
            if (input[i] - k >= 0) {
                if (max == 0 || max < i-j+1) max = i-j+1;
                i = j++;
            }
        }


        System.out.println("max = " + max);


        return 0;
    }

}
