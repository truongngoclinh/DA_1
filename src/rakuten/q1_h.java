package rakuten;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 4/18/19 - 21:44.
 * @organization VED
 */

public class q1_h {
    public String solution(int a, int b) {
//        System.out.println("a = " + a + ", b = " + b);
        StringBuilder r = new StringBuilder();

        if (a > 2 * b + 2 || b > 2 * a + 2) return "";

        char t1 = 'a', t2 = 'b';
        int l1 = a, l2 = b, i, j;
        if (a < b) {
            t1 = 'b';
            t2 = 'a';
            l1 = b;
            l2 = a;
        }

        for (i = 0; i < l2; i++) {
            r.append(t1);
            r.append(t2);
        }

        j = 1;
        i = 0;
        while (true) {
            if (i >= l2 || i >= l1 - l2) break;
            r.insert(j + i < r.length() ? j + i : r.length(), t1);
            j = j + i + 1;
            i++;
        }


        for (i = 0; i < l1 - l2 * 2; i++) {
            r.append(t1);
        }


//        System.out.println("result = " + r.toString());

        return r.toString();


        // a = 5
        // b = 3
        // ababab


        // abaabaabaaa

        // aa b aa b aa b aa
    }
}
