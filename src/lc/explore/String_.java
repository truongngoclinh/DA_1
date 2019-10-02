package lc.explore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 8/25/18 - 22:01.
 * @organization VED
 */

public class String_ {
/*    // Add Binary
    public int solution() {
        String a = "1", b = "1";

        int la = a.length() - 1, lb = b.length() - 1;

        StringBuilder builder = new StringBuilder();

        int carrier = 0;
        while (la >= 0 || lb >= 0) {
            int x = la >= 0 ? a.charAt(la--) - '0' : 0;
            int y = lb >= 0 ? b.charAt(lb--) - '0' : 0;
            int total = x + y + carrier;

            builder.append(total % 2);
            carrier = total/2;
        }

        if (carrier != 0) {
            builder.append(carrier);
        }

        String r = builder.reverse().toString();
        System.out.println(r);

        return 0;
    }*/

/*    public int solution (){
        String a = "1111";

        int i = a.charAt(0);
        int j = '1' - '0';

        System.out.println(i);
        System.out.println(j);


        return 0;
    }*/

 /*   // Haystack & Needle
    public int solution() {
        String haystack = "mississippi", needle = "issip";

        int hl = haystack.length(), nl = needle.length();
        if (needle.isEmpty() || haystack.equalsIgnoreCase(needle)) return 0;
        if (haystack.isEmpty() || nl > hl) return -1;

        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == nl) return i;
                if (i + j == hl) return -1;

                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }*/

/*    // Longest Common Prefix - use sorting
    public int solution() {

//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"c", "c"};

       // if (strs.length == 0) return "";
       // if (strs.length == 1) return strs[0];

        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : strs) {
            arrayList.add(str);
        }

        Collections.sort(arrayList);

        String first = arrayList.get(0);
        String last = arrayList.get(arrayList.size() - 1);
        if (first.length() == 0) {
            System.out.println("");
            return 0;
        }

        int i = 0;
        while (i < first.length()) {
            if (first.charAt(i) == last.charAt(i)) {
                i++;
            } else {
                break;
            }
        }

        System.out.println(first.substring(0 , i));

        return 0;
    }*/

    // Longest Common Prefix
    public int solution() {

        String[] strs = {"abc","abcc","abc","abca","abca"};
//        String[] strs = {"dog","racecar","car"};
//        String[] strs = {"aaa","aa","aaa"};
//        String[] strs = {"c", "c"};

/*        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];*/

        int i = 0, j = 0, k = strs[0].length();
        while (i < strs.length - 1) {
            j = 0;
            while (true) {
                String c = strs[i];
                String n = strs[i+1];
                if (c.isEmpty() || n.isEmpty()) {
                    System.out.println("");
                    return 0;
                }
                if (k > n.length()) k = n.length();
                if (j == k) break;
                if (c.charAt(j) == n.charAt(j)) {
                    j++;
                } else {
                    k = j;
                    break;
                }
            }

            i++;
        }

        System.out.println(strs[0].substring(0, k));

        return 0;
    }
}
