package wovn;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 9/20/18 - 15:28.
 * @organization VED
 */

public class Test3 {
 /*   function flatten (arr)

    flatten([0, [1, 2]]) => [0, 1, 2]

    flatten(['a', {b: 1}, [2]]) => ['a', {b: 1}, 2]

    flatten([[[[[[[[[0]]]]]]]]]]) => [0]

    flatten([]) => []

    flatten([[0], 1, [2, [3, 4], 5], [6, 7]]) => [0, 1, 2, 3, 4, 5, 6, 7]*/
    public static void main(String[] args) {

    }

 /*   private ArrayList<String> refineArray(ArrayList<String> arr) {
       if (arr.isEmpty()) return new ArrayList<>();
       ArrayList<String> result = new ArrayList<>();


       for (String str : arr) {
           try {
               Integer intValue = Integer.parseInt(str);
               result.add(intValue.toString());
           } catch (NumberFormatException e) {
               String numberPattern = "[0-9]";
               if (str.matches(numberPattern)) {
                   result.add(str.replaceAll("^[0-9]", str));
               } else if (str.contains("]") || str.contains("[")) {
                   result.add(str.replaceAll("]") })
               } else {
                   // json type
               }
           }
       }


       return result;
    }*/
}
