package rakuten;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 4/18/19 - 20:33.
 * @organization VED
 */

public class q1 {
    public String solution(int A, int B) {
        // write your code in Java SE 8
        System.out.println("A = " + A + ", B = " + B);

        String result = "";
        if (A >= B) {
            result = generate(A, B, "a", "b");
        } else {
            result = generate(B, A, "b", "a");
        }

        System.out.println("===>>> result is: " + result);
        return result;
//        return "";
    }

    private String generate(int l1, int l2, String s1, String s2) {
        StringBuilder result = new StringBuilder();

        int i = 0, j = 0;
        String _s1 = s1 + s1;
        String _s2 = s2 + s2;
        String last = "";
        while (true) {
            if (i < l1 - 1) {
                result.append(s1);
                result.append(s1);
                i += 2;
                last = _s1;
            }

            if (j < l2 - 1) {
                result.append(s2);
                result.append(s2);
                j += 2;
                last = _s2;
            }

            if (i == l1 - 1 && !last.equals(_s1)) {
                result.append(s1);
                i += 1;
            }

            if (j == l2 - 1 && !last.equals(_s2)) {
                result.append(s2);
                j += 1;
            }

            if (j == l2 || i == l1) {
                _s1 = "";
                _s2 = "";
            }

            if (i >= l1 && j >= l2) {
                return result.toString();
            }
        }
    }
}
