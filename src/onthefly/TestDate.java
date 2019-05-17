package onthefly;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 3/9/19 - 00:29.
 * @organization VED
 */

public class TestDate {
    public static void main(String[] args) throws ParseException {
        System.out.println("test date");

        long t = 1552066337418L;
        System.out.println("t = " + t);
        long t2 = System.currentTimeMillis();
        System.out.println("t2 = " + t2);

        TimeUnit unit = TimeUnit.SECONDS;
        System.out.println(unit.convert(t2-t, TimeUnit.MILLISECONDS));
    }
}
