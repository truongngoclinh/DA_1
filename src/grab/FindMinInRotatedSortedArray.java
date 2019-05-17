package grab;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 4/16/19 - 16:12.
 * @organization VED
 */

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * Input: [3,4,5,1,2]
 * Output: 1
 * <p>
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */

public class FindMinInRotatedSortedArray {

    public static void main(String[] args) {
        int[] exampleOne = {3, 4, 5, 1, 2};
        int[] exampleTwo = {4, 5, 6, 7, 0, 1, 2};

        FindMinInRotatedSortedArray solution = new FindMinInRotatedSortedArray();
        System.out.println(solution.findMin(exampleOne));
        System.out.println(solution.findMin(exampleTwo));
    }

    public int findMin(int[] nums) {
        // {3,4,5,1,2};
     /*   int l = nums.length();
        int f = 0;
        int z = l;
        int p = nums[f + z / 2];
        int i = 0, j = 0;
        while (f < z) {
            int mid = f + z / 2;
            i = 0;
            j = mid + 1;
            while (i < mid) {
                if (nums[i] > p) i++
                else {
                    f = 0;
                    z = i;
                    p = nums[i]
                }
            }
            while (j < z) {
                if (nums[j] > p) j++;
                else {
                    f = mid+1;
                }
            }
        }
*/
        return 0;
    }

}
