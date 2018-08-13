package test;

/**
 * Shift the 0 elements
 *
 * @author linhtruong
 * @date 4/12/18 - 10:03.
 * @organization VED
 */

public class Test1 {
    public static void main(String[] args) {
        int a[] = {1, 0, 0, 0, 9, 8, 5, 1, 0, 8, 0, 1, 9, 0};
        int zezoCount = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == 0) zezoCount++;
            if (a[i] == 0 && a[i + 1] != 0) {
                a[i - zezoCount + 1] = a[i + 1];
                a[i + 1] = 0;
                zezoCount--;
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
