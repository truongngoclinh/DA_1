package algoda;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 3/2/19 - 12:32.
 * @organization VED
 */

public final class Test4 {
    private boolean flag = true;
    public static void main(String[] args) {
        new Test4();
    }

    public void sample() {
        System.out.println("Sample");
    }

    public Test4() {
        (new Inner()).test();
    }

    class Inner {
        void test() {
            if (Test4.this.flag) {
                sample();
            }
        }
    }
}
