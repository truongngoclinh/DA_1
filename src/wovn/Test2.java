package wovn;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 9/20/18 - 10:32.
 * @organization VED
 */

public class Test2 {
    public static void main(String[] args) {
        String str = "ababa";

        int i = 0, j = 0, l = str.length();
        if (str.isEmpty() || l == 1) System.out.println("sum: " + 1);

        int[] result = new int[l+1];
        result[l] = 0;

        for (;i < l; i++) {
            String s_str = str.substring(i , l);
            j = 0;
            while (j < s_str.length()) {
                if (str.charAt(j) != s_str.charAt(j)) {
                    break;
                }

                j++;
            }

            result[i] = j;
        }

        for (i = 0; i < result.length; i++) {
           System.out.print(result[i] + " ");
        }

    }
}
