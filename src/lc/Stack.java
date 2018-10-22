package lc;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 10/1/18 - 09:46.
 * @organization VED
 */

public class Stack {
/*
    public int solution() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
//        stack.pop();
        stack.print();
        System.out.println("");
        System.out.println(stack.top());
        System.out.println(stack.getMin());

        return 0;
    }*/

    class MinStack {
        int[] data;
        int head;

        public void print() {
            for (int i = 0; i <= head; i++) {
                System.out.print(data[i] + " ");
            }
        }

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new int[10000];
            head = -1;
        }

        public void push(int x) {
            data[++head] = x;
        }

        public void pop() {
            head--;
        }

        public int top() {
            return data[head];
        }

        public int getMin() {
            int min = data[0];
            for (int i = 1; i <= head; i++) {
                if (min > data[i]) {
                    min = data[i];
                }
            }

            return min;
        }
    }

    // VALID PARENTHESES
   /* int solution() {
        String s = "()[]{}";
//        if (s.isEmpty()) return true;

       *//* java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else if (stack.isEmpty() || c != stack.pop()) {
                System.out.println("false");
                break;
            }
        }

//        return stack.isEmpty();
        System.out.println(stack.isEmpty());
*//*
       char[] sa = new char[s.toCharArray().length];
       int head = 0;
       for (char c : s.toCharArray()) {

           if (c == '{') sa[head++] = '}';
           else if (c == '[') sa[head++] = ']';
           else if (c == '(') sa[head++] = ')';
           else if (head == 0|| c != sa[--head]) {
               System.out.println("false");
               break;
           }
       }

        System.out.println(head == 0);

       *//* char[] sarray = s.toCharArray();
        stack.push(sarray[0]);

        while (!stack.isEmpty()) {
            for (int i = 1; i < sarray.length; i++) {
                char c = sarray[i];
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                char t = stack.peek();
                if (isPaired(t, c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            System.out.println(stack.isEmpty() ? "true" : "false");
        }

        System.out.println("true");*//*

        return 0;
    }*/

    boolean isPaired(char c1, char c2) {
        StringBuilder builder = new StringBuilder();
        builder.append(c1);
        builder.append(c2);
        String str = builder.toString();

        if (str.contains("{") && str.contains("}")) {
            return true;
        }
        if (str.contains("[") && str.contains("]")) {
            return true;
        }
        if (str.contains("(") && str.contains(")")) {
            return true;
        }

        return false;
    }


    // DAILY TEMPs
    int solution() {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73}; // [1, 1, 4, 2, 1, 1, 0, 0].

        int[] r = new int[T.length];
        int[] s = T;
        int i = T.length-1, count = 0;
        for (int j : T) {
            if (j > s[i]) {

            } else {
                count++;
            }
        }

        // TIME LIMIT EXCEEDS
       /* int i = 0, c = T[i], l = T.length, count = 0;

        for (int j = i; j < l; j++) {
            if (i == l - 1) {
                T[i] = 0;
                break;
            }
            if (T[j] <= c) {
                if (j == l - 1) {
                    T[i] = 0;
                    count = 0;
                    j = i;
                    c = T[++i];
                } else {
                    count++;
                }
            } else {
                T[i] = count;
                count = 0;
                j = i;
                c = T[++i];
            }
        }

        for (int j : T) {
            System.out.println(j + " ");
        }
*/
        return 0;
    }
}
