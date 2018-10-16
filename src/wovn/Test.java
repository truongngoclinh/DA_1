package wovn;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 9/9/18 - 15:00.
 * @organization VED
 */


public class Test {
    public static void main(String[] args) {
        String[] origItems = {"rice", "sugar", "wheat", "chees"};
        String items[] = {"rice", "wheat"};
        float[] origPrices = {1, 2, 3, 4};
        float prices[] = {5, 6};

        HashMap<String, Float> result = new HashMap<>();
        for (int i = 0; i < origItems.length; i++) {
           result.put(origItems[i], origPrices[i]) ;
        }

        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (prices[i] != result.get(items[i]).floatValue()) {
                count++;
            }
        }

//        return count;
        System.out.println("count = " + count);
    }
  /*  // Complete the verifyItems function below.
    static int verifyItems(String[] origItems, float[] origPrices, String[] items, float[] prices) {
        System.out.println("origItems size = " + origItems.length);

        return 0;
    }


    private static String path = System.getProperty("user.dir") + "/src/wovn/input";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path)));

        int origItemsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] origItems = new String[origItemsCount];

        for (int i = 0; i < origItemsCount; i++) {
            String origItemsItem = scanner.nextLine();
            origItems[i] = origItemsItem;
        }

        int origPricesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        float[] origPrices = new float[origPricesCount];

        for (int i = 0; i < origPricesCount; i++) {
            float origPricesItem = scanner.nextFloat();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            origPrices[i] = origPricesItem;
        }

        int itemsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] items = new String[itemsCount];

        for (int i = 0; i < itemsCount; i++) {
            String itemsItem = scanner.nextLine();
            items[i] = itemsItem;
        }

        int pricesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        float[] prices = new float[pricesCount];

        for (int i = 0; i < pricesCount; i++) {
            float pricesItem = scanner.nextFloat();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            prices[i] = pricesItem;
        }

        int res = verifyItems(origItems, origPrices, items, prices);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }*/
}
