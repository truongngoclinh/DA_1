package lc.onemonthchallenge;

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
        int a[] = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes(a);

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

}
