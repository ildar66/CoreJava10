package v2ch09.hash;

import java.io.*;
import java.nio.file.*;
import java.security.*;

/**
 * This program computes the message digest of a file.
 * @author Cay Horstmann
 * @version 1.20 2012-06-16
 */
public class Digest {

    /**
     * @param args args[0] is the filename, args[1] is optionally the algorithm
     * (SHA-1, SHA-256(384,512), or MD5)
     */
    public static void main(String[] args) throws IOException, GeneralSecurityException {
        String algname = args.length >= 2 ? args[1] : "SHA-384"; //"SHA-512";
        MessageDigest alg = MessageDigest.getInstance(algname);
        Path path;
        if (args.length >= 1) {
            path = Paths.get(args[0]);
        } else {
            path = Paths.get(System.getProperty("user.home"), "git", "CoreJava10", "src", "v2ch09", "hash", "input.txt");
        }
        byte[] input = Files.readAllBytes(path);
        byte[] hash = alg.digest(input);
        String d = "";
        for (byte aHash : hash) {
            int v = aHash & 0xFF;
            if (v < 16) d += "0";
            d += Integer.toString(v, 16).toUpperCase() + " ";
        }
        System.out.println(d);
    }
}
