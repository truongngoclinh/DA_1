package lc.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 10/28/18 - 09:51.
 * @organization VED
 */

public class contest_108 {

    int solution() {
        String emails[] = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        int r;

        r = numUniqueEmails(emails);

        return 0;
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> result = new HashSet<>();
        for (String e : emails) {
            String domain = e.substring(e.indexOf("@"));
            String name = e.substring(0, e.indexOf("@"));
            name = name.replaceAll("\\.", "");
            if (name.contains("+")) name = name.substring(0, name.indexOf("+"));
            result.add(name + domain);
        }

        return result.size();
    }
}
