package v1ch03.FirstSample;

import java.util.Arrays;
import java.util.List;

/**
 * This is the first sample program in Core Java Chapter 3
 * @author Gary Cornell
 * @version 1.01 1997-03-22
 */
public class FirstSample {

    public static void main(String[] args) {
        System.out.println("We will not use 'Hello, World!'");
        System.out.println(0x1.0p-3);
//        System.out.println(8/0);
        int n = 0b1111;
        int fourthBitFromRight = (n & 0b1000)/0b1000;
        System.out.println(fourthBitFromRight);

        String all = String.join(" / ", "S", "M", "L", "XL");
        List<String> list = Arrays.asList("one", "two", "three", "four");
        all = String.join(", ", list);
        System.out.println(all);
    }
}
