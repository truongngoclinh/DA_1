package rakuten;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 5/9/19 - 21:45.
 * @organization VED
 */

public class Outer {
    private String name = "just my name";

    class Inner {
        public Inner(String test){}

        private void printName() {
            System.out.println(name);
        }
    }
}
