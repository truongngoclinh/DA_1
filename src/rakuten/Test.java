package rakuten;

import java.util.Random;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 4/18/19 - 20:34.
 * @organization VED
 */

public class Test {
    public static void main(String[] args) {
//        q1_h test = new q1_h();
//        test.solution(6, 3);
//        test.solution(7, 3);
//        test.solution(3, 3);
//        test.solution(1, 4);
//        test.solution(5, 6);
//        test.solution(10, 5);
//        test.solution(10, 6);
//        new q1().solution(20, 21);
////        new q1().solution(96, 99);
//
        Random random = new Random();
//        q1_temp test = new q1_temp();
//        q1 test = new q1();
        q1_h test = new q1_h();

        for (int i = 0; i < 1000; i++) {
            int a = random.nextInt(10);
            int b = 0;
            int min = a % 2 == 0 ? a / 2 - 1 : a / 2;
            while (b > a || b < min) {
                b = random.nextInt(10);
            }
            String res = test.solution(a, b);
            boolean checksize = a + b == res.length();
            boolean check = check(res);
            if (!check || !checksize) {
                System.out.println("checksize = " + checksize + " - check = " + check + " - a = " + a + " - b = " + b + ": " + res);
            }
        }
//        int a = 9;
//        int b = 9;
//        System.out.println("a = " + a + " - b = " + b + ": " + test.solution(a, b));
    }

    private static boolean check(String a) {
        for (int i = 0; i < a.length() - 3; i++) {
            char c = a.charAt(i);
            boolean res = false;
            for (int j = i; j < i + 4; j++) {
                if (a.charAt(j) != c) {
                    res = true;
                    break;
                }
            }
            if (!res) return false;
        }
        return true;
    }
}
