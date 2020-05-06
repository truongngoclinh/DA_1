package lc.maychallenge;

import java.util.HashMap;
import java.util.Map;

public class May {

    public int solution() {
/*
        String J = "aA";
        String S = "aAAbbbb";
        String J = "zz";
        String S = "ZZZ";

        System.out.println(numJewelsInStones(J, S));
*/

/*
        int n = 5;
        System.out.println(firstBadVersion(n));
*/

/*
        findComplement(5);
*/

/*
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
*/

        String r = "aa", m = "ab";
        System.out.println(canConstruct(r, m));

        return 0;
    }

    public int firstBadVersion(int n) {
        int l = 1, r = n, m = 0;
        while (l < r) {
            m = l + (r - l) / 2;
            if (isBadVersion(m)) r = m;
            else l = m + 1;
        }

        return l;
    }

    private boolean isBadVersion(int n) {
        return false;
    }

    public int numJewelsInStones(String J, String S) {
        int r = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (char j : J.toCharArray()) m.put(j, 0);
        for (char s : S.toCharArray()) {
            Integer c = m.get(s);
            if (c != null) {
                c++;
                m.put(s, c);
            }
        }
        for (Integer i : m.values()) r += i;

        return r;
    }

    public int findComplement(int num) {
//        System.out.println(intToBinary(num));
//        System.out.println(binaryToInt(intToBinary(num)));

//        System.out.println(flip(intToBinary(num)));
        System.out.println("Complement: " + binaryToInt(flip(intToBinary(num))));

        return 0;
    }

/*
    // bitwise operator
    public int findComplement(int num) {
        int cp = num;
        int sum = 0;
        while(num > 0){
            sum = (sum << 1) + 1;
            num >>= 1;
        }
        return sum - cp;
    }
*/

    private String intToBinary(int n) {
        StringBuilder r = new StringBuilder();
        while (true) {
            if (n == 1) {
                r.append("1");
                break;
            }
            r.append(n % 2);
            n = n / 2;
        }

        return r.toString();
    }

    private int binaryToInt(String binary) {
        int r = 0, l = binary.length();
        char[] arr = binary.toCharArray();
        for (int i = l - 1; i >= 0; i--) {
            if (arr[i] == '0') r = r * 2;
            else r = (r * 2) + 1;
        }

        return r;
    }

    private String flip(String s) {
        char[] tmp = s.toCharArray();
        char[] r = new char[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == '0') r[i] = '1';
            else r[i] = '0';
        }

        return String.valueOf(r);
    }

    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        char[] crr = s.toCharArray();
//        for (int i = 0; i < 26; i++) arr[i] = 0;
        for (char c : crr) arr[(int) c - 97]++;
        for (int i = 0; i < crr.length; i++)
            if (arr[(int) (crr[i]) - 97] == 1) return i;


        return -1;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] r = new int[26], m = new int[26];
        char[] rc = ransomNote.toCharArray(), mc = magazine.toCharArray();
        int i = 0, rl = rc.length, ml = mc.length;
        while (i < rl || i < ml) {
            if (i < rl) r[(int) rc[i] - 97]++;
            if (i < ml) r[(int) mc[i] - 97]--;
            i++;
        }
//        for (char c : rc) r[(int) c - 97]++;
//        for (char c : mc) r[(int) c - 97]--;
        for (char c : rc) if (r[(int) c - 97] > 0) return false;

        return true;
    }
}

