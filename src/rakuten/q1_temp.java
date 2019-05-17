package rakuten;

import java.util.Random;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 4/18/19 - 21:04.
 * @organization VED
 */

public class q1_temp {
    public String solution(int a, int b) {
        char ca = 'a';
        char cb = 'b';
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
            char ctemp = ca;
            ca = cb;
            cb = ctemp;
        }

        StringBuilder sb = new StringBuilder();
        int acount = 0;
        int ended = cb;
        while (a > b) {
            if (acount < 3) {
                sb.append(ca);
                acount++;
                a--;
                ended = ca;
            } else {
                sb.append(cb);
                b--;
                acount = 0;
                ended = ca;
            }
        }

        String next = ended == ca ? "" + cb + ca : "" + ca + cb;
        for (int i = 0 ; i < a; i++) {
            sb.append(next);
        }


        return sb.toString();
    }
}
