package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 8/25/18 - 13:28.
 * @organization VED
 */

public class Array_String {
    // Find Pivot Index
  /*  public int pivotIndex(int[] nums) {
        int total = 0;
        int length = nums.length;

        if (length == 0) return -1;

        if (length == 1) return 0;

        for (int i = 0; i < length; i++) {
            total += nums[i];
            nums[i] = total;
        }

        for (int i = 0; i < length - 1; i++) {
            if (total - nums[0] == 0) return 0;
            if (nums[i] + nums[i+1] == total) {
                return i + 1;
            }
        }

        return -1;
    }*/

    // Largest Number At Least Twice of Others
   /* public int solution() {
        int nums[] = {3, 6, 1, 0};

        int max = 0;
        int length = nums.length;

        if (length == 0) return -1;
        if (length == 1) return 0;

        max = nums[0];
        int result = 0;
        for (int i = 1; i < length; i++) {
            if (max < nums[i]) {
                if (max * 2 <= nums[i]) {
                    max = nums[i];
                    result = i;
                } else {
                    result = -1;
                }
            } else {
                if (max < nums[i] * 2) {
                    result = -1;
                }
            }
        }

        return result;
    }*/

    // Plus One
/*    public int solution() {
        int result[] = execute();

        for (int i : result) {
            System.out.print(i + " ");
        }

        return 0;
    }*/

  /*  public int[] execute() {
        int digits[] = {4, 3, 2, 1};
        int length = digits.length;
        int result[];
        int lastElement = digits[length-1];

        if (length == 1) {
            if (lastElement == 0) {
                digits[0] = 1;

                return digits;
            }

            if (lastElement == 9) {
                result = new int[length+1];
                result[0] = 1;
                result[1] = 0;

                return result;
            }
        }

        if (lastElement < 9) {
            digits[length - 1] = lastElement + 1;
            return digits;
        }

        boolean isAllNineDigits = true;
        result = new int[length+1];
        result[0] = 1;
        for (int i = 0; i < length; i ++) {
            result[i+1] = 0;
            if (digits[i] != 9) {
                isAllNineDigits = false;
                break;
            }
        }

        if (isAllNineDigits) {
            result[length] = 0;
            return result;
        }

        if (lastElement == 9) {
            result = new int[length];
            result[length-1] = 0;
            boolean assignMode = false;
            for (int i = length-2; i >= 0; i--) {
                if (assignMode) {
                    result[i] = digits[i];
                } else {
                    if (digits[i] == 9) {
                        result[i] = 0;
                    } else {
                        result[i] = digits[i] + 1;
                        assignMode = true;
                    }
                }
            }
        }

        return result;
    }*/

    // Diagoal Traverse
 /*   public int[] execute() {
        int matrix[][] = {
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {4, 5, 6, 7},
        };

        if (matrix.length == 0) return new int[0];
        int r = 0, c = 0, m = matrix.length, n = matrix[0].length, result[] = new int[m * n];
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[r][c];

            // moving up
            if ((r + c) % 2 == 0) {
                if (c == n - 1) {
                    r++;
                } else if (r == 0) {
                    c++;
                } else {
                    r--;
                    c++;
                }
            }
            // moving down
            else {
                if (r == m - 1) {
                    c++;
                } else if (c == 0) {
                    r++;
                } else {
                    c--;
                    r++;
                }
            }
        }

        return result;
    }*/

    // Spiral Matrix
 /*   public int solution() {
        List<Integer> result = execute();
        for (Integer i : result) {
            System.out.print(i + " ");
        }

        return 0;
    }

    public List<Integer> execute() {
        int matrix[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {9, 10, 11, 12},
                {9, 10, 11, 12},
        };

        if (matrix.length == 0) return new ArrayList<>();

        int r = 0, c = 0, m = matrix.length, n = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        int level = 0;
        while (result.size() < m * n) {
            result.add(Integer.valueOf(matrix[r][c]));

            // left to right
            if (r == level && c < n - 1 - level) {
                c++;
            }

            // top to bottom
            else if (r < m - 1 - level && c == n - 1 - level) {
                r++;
            }

            // right to left
            else if (r == m - 1 - level && c > level) {
                c--;
            }

            // bottom to top
            else {
                r--;
                if (r == level + 1) {
                    level++;
                }
            }
        }


        return result;
    }*/

    // Pascal Triangle
    public int solution() {
        int N = 5;

        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    row.add(1);
                } else if (j < i && j > 0) {
                    List<Integer> upperRow = results.get(i - 1);
                    row.add(upperRow.get(j - 1) + upperRow.get(j));
                } else {
                    row.add(1);
                }
            }

            results.add(row);
        }

        for (int i = 0; i < results.size(); i++) {
            List<Integer> row = results.get(i);
            System.out.println("");
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(row.get(j) + " ");
            }
        }

        return 0;
    }
}

