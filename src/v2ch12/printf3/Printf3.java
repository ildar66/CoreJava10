package v2ch12.printf3;

import java.io.*;

/**
 * @version 1.10 1997-07-01
 * @author Cay Horstmann
 */
class Printf3
{
   public static native void fprint(PrintWriter out, String format, double x);

   static
   {
      System.loadLibrary("v2ch12.printf3.Printf3");
   }
}
