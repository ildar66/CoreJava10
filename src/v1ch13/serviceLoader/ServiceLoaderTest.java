package v1ch13.serviceLoader;

import java.io.UnsupportedEncodingException;
import java.util.ServiceLoader;

/**
 * @author Cay Horstmann
 * @version 1.00 2015-06-14
 */

public class ServiceLoaderTest {

    private static final byte KEY_VALUE = 3;
    private static final byte[] KEY = {KEY_VALUE};

    private static ServiceLoader<Cipher> cipherLoader = ServiceLoader.load(Cipher.class);

    public static void main(String[] args) throws UnsupportedEncodingException {
        final int minStrength = 1;
        Cipher cipher = getCipher(minStrength);
        String message = "Meet me at the toga party.";
        byte[] bytes = cipher.encrypt(message.getBytes(), KEY);
        String encrypted = new String(bytes, "UTF-8");
        System.out.println(encrypted);
        bytes = cipher.decrypt(encrypted.getBytes(), KEY);
        String decrypted = new String(bytes, "UTF-8");
        System.out.println(decrypted);
    }

    private static Cipher getCipher(int minStrength) {
        for (Cipher cipher : cipherLoader) {
            // .rm Implicitly calls iterator
            if (cipher.strength() >= minStrength) return cipher;
        }
        throw new RuntimeException("Service with min strength = " + minStrength + " not foutnd !");
    }
}