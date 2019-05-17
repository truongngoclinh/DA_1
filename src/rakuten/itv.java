package rakuten;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 5/9/19 - 13:48.
 * @organization VED
 */

public class itv {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
//        inner.printName();
    }
}
