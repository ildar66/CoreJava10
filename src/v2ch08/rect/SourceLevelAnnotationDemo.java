package v2ch08.rect;

import v2ch08.sourceAnnotations.ToStrings;

/**
 * Using orders:
 * javac v2ch08/sourceAnnotations/ToStringAnnotationProcessor.java
 * javac -processor v2ch08.sourceAnnotations.ToStringAnnotationProcessor v2ch08/rect/*.java
 * java v2ch08.rect.SourceLevelAnnotationDemo
 */
public class SourceLevelAnnotationDemo {

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(new Point(10, 10), 20, 30);
        System.out.println(ToStrings.toString(rect));
    }
}
