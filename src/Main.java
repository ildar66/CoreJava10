import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String str = "Hello!";
        int[] codePoints = str.codePoints().toArray();
        str = new String(codePoints, 0, codePoints.length);
        codePoints = str.codePoints().filter(ch -> ch != 'l').toArray();
        str = new String(codePoints, 0, codePoints.length);
        System.out.println(str);
        java.util.Date date  = new Date();
        date.clone();

        System.out.println("Double.NEGATIVE_INFINITY =" + Double.NEGATIVE_INFINITY );
        System.out.println("Double.POSITIVE_INFINITY =" + Double.POSITIVE_INFINITY );
        System.out.println("1/0 =" + 1.0/0 );
        System.out.println("-1/0 =" + -1.0/0 );

        String [] a  = {"4", "2", "3"};
//        a[-1] = "8";

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        System.out.println("before update list=" + list);
        ArrayList<Integer> list2 = new ArrayList<>(list);
        list.set(3, -4);
        list.add(5);
        System.out.println("after update list=" + list);
        System.out.println("list2=" + list2);

        String userDir = System.getProperty("user.home");
        System.out.println("User dir = " + userDir);

        List<Integer> synchArrayList = Collections.synchronizedList(list);
        synchArrayList.add(7);
        synchArrayList.remove(0);
        System.out.println("synchArrayList=" + synchArrayList);

        String baseDir = System.getProperty("base.dir");
        System.out.println("Base dir = " + baseDir);
        final Properties properties = System.getProperties();
        // properties.list(System.out);



    }
}
