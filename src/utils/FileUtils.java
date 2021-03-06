package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 8/14/18 - 10:36.
 * @organization VED
 */

public class FileUtils {
    private static String mProjectDir = System.getProperty("user.dir") + "/src/com/boiboi/ds/";

    public static Scanner readFile(String fileName) {
        String filePath = mProjectDir + fileName;
        File file = new File(filePath);
        try {
            if (file.exists()) {
                return new Scanner(file);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

        System.out.println("Wrong file path");
        return null;
    }
}
