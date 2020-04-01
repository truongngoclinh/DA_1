package lc.onemonthchallenge;

public class OneMonth {

    public int solution() {

        int a[] = {4, 1, 2, 1, 2};
        System.out.print(singleNumber(a));

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
}
