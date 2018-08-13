package test;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.util.Base64;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class TestEncrypt {

    public static void main(String[] args) throws Exception {
        System.out.println("Cipher test");
        String text = "{\"function\":\"GetBalance\"}";

        String codedtext = null;
        String decodedtext = null;
        try {
            codedtext = encrypt(text, "t6twy5-S11_75=5qy42ER6Y84r84494p");
            decodedtext = decrypt(codedtext, "t6twy5-S11_75=5qy42ER6Y84r84494p");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(codedtext); // this is a byte array, you'll just see a reference to an array
        System.out.println(decodedtext); // This correctly shows "kyle boon"

        String response = "dQxMxR89iSTbEMUIYrpsn7xLfw/dgvsrcYhNEAoIE87Xch80CsC971gwhK2CiAyyYBKhLqzaMxoEd2wAGXATkwmBQpGVt+RVXPV2k95smqNoeVzV0RIoimKT9n3mJThOvOzvnV10cwetxWUuKRhL9BgzKlmIIMWGUz1nujd5FXI=";
        System.out.println(decrypt(response, "t6twy5-S11_75=5qy42ER6Y84r84494p"));
    }

    public static String encrypt(String message, String key) throws Exception {
        final MessageDigest md = MessageDigest.getInstance("md5");
        final byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));
        final byte[] keyBytes = new byte[digestOfPassword.length + 8];
        for (int i = 0; i< keyBytes.length; i++) {
            int j = (i >= digestOfPassword.length ? i - digestOfPassword.length : i);
            keyBytes[i] = digestOfPassword[j];
        }

        final SecretKey skey = new SecretKeySpec(keyBytes, "DESede");
        final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skey);

        final byte[] plainTextBytes = message.getBytes("utf-8");
        final byte[] cipherText = cipher.doFinal(plainTextBytes);
        final String encodedCipherText = Base64.getEncoder().encodeToString(cipherText);

        return encodedCipherText;
    }


    public static String decrypt(String base64Msg, String key) throws Exception {
        final MessageDigest md = MessageDigest.getInstance("md5");
        final byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));
        final byte[] keyBytes = new byte[digestOfPassword.length + 8];
        for (int i = 0; i < keyBytes.length; i++) {
            int j = (i >= digestOfPassword.length ? i - digestOfPassword.length : i);
            keyBytes[i] = digestOfPassword[j];
        }

        final SecretKey skey = new SecretKeySpec(keyBytes, "DESede");
        final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        final Cipher decipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        decipher.init(Cipher.DECRYPT_MODE, skey);

        // final byte[] encData = new
        // sun.misc.BASE64Decoder().decodeBuffer(message);
        final byte[] plainText = decipher.doFinal(Base64.getDecoder().decode(base64Msg));

        return new String(plainText, "UTF-8");
    }
}
