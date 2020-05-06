package lc.explore;

public class Recursion {

    public int solution() {
        // reverseString
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(s);
        return 0;
    }

    public void reverseString(char[] s) {
        reverse(s, 0);
    }

    private void reverse(char[] s, int i) {
        if (i >= s.length - i - 1) return;
        char tmp = s[i];
        s[i] = s[s.length - i - 1];
        s[s.length - i - 1] = tmp;
        reverse(s, i + 1);
    }

}
