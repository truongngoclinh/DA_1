package algoda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 3/2/19 - 12:23.
 * @organization VED
 */

public class Test {
    public static void main(String[] args) {
//        System.out.println("test");
//
//        int x = 2;
//        x = x << 2;
//        System.out.println(x);
        List<String> dates = new ArrayList<>();
        dates.add("01 Mar 2017");
        dates.add("03 Feb 2017");
        dates.add("15 Jan 1998");

        List<String> result = sortDates(dates);


        for (String str : result) {
            System.out.println(str);
        }
    }

    public static List<String> sortDates(List<String> dates) {
        List<String> result = new ArrayList<>( );
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            Date date1 = dateFormat.parse("01 Mar 2017");
            Date date2 = dateFormat.parse("03 Feb 2017");
            System.out.println(date1.compareTo(date2));

        } catch (ParseException e) {
            e.printStackTrace();
        }


        return result;
    }
}
