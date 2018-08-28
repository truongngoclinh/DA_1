package lc;

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

    // Longest Common Prefix
    public int solution() {

//        String[] input = {"flower", "flow", "flight"};
        String[] strs = {"c", "c"};

        int i, j, l = strs.length;
        int prev = 0, next = 0;
        for (i = 0; i < l - 1; i++) {
            String str = strs[i];
            String nextStr = strs[i + 1];
            for (j = 0; ; j++) {
                next = j;
                if (j == str.length() || j == nextStr.length()) break;

                if (str.charAt(j) != nextStr.charAt(j)) {
                    if (j > prev) next = prev;

                    break;
                }
            }
        }

        System.out.println(strs[l - 1].substring(0, next));

        return 0;
    }

}
