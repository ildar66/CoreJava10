package v2ch12.helloNative;

/**
 * In summary, follow these steps to link a native method to a Java program:
 * 1. Declare a native method in a Java class.
 * 2. Run javah to get a header file with a C declaration for the method.
 * 3. Implement the native method in C.
 * 4. Place the code in a shared library.
 * 5. Load that library in your Java program.
 *
 * @author Cay Horstmann
 * @version 1.11 2007-10-26
 */
class HelloNativeTest {

    public static void main(String[] args) {
        HelloNative.greeting();
    }

    static {
        System.loadLibrary("v2ch12.helloNative.HelloNative");
    }
}
