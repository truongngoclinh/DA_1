package test;

import java.util.*;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 4/11/18 - 12:02.
 * @organization VED
 */

public class TestSets {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 1, 2, 3, 2, 3, 1, 2, 3, 4, 20};
        arrayTest(a);
        System.out.println("");
        setTest(a);
        System.out.println("");
        sortTest(a);
    }

    private static void arrayTest(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) max = a[i];
        }

        int b[] = new int[max + 1];


        for (int i = 0; i < a.length; i++) {
            b[a[i]] = 1;
        }

        for (int i = 0; i < b.length; i++) {
            if (b[i] == 1) {
                System.out.print(i + " ");
            }
        }
    }

    private static void setTest(int[] a) {
        HashSet<Integer> b = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            b.add(a[i]);
        }

        Iterator<Integer>  iterator = b.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

    private static void sortTest(int[] a) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }

        Collections.sort(list);

        int tmp = list.get(0);
        System.out.print(tmp + " ");
        for (Integer i : list) {
            if (i.intValue() != tmp)  {
                tmp = i.intValue();
                System.out.print(i + " ");
            }
        }
    }
}
