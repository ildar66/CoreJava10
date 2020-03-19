package v2ch02.findDirectories;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

/**
 * @author Cay Horstmann
 * @version 1.1 2012-05-31
 */
public class FindDirectories {

    public static void main(String[] args) throws IOException {
        // Path dir = Paths.get(args.length == 0 ? System.getProperty("user.home") : args[0]);
        Path dir = Paths.get(System.getProperty("user.home"), "git", "CoreJava10", "src");

        // не работаете
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {

            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (attrs.isDirectory()) { // ???  не работает
                    System.out.println(file);
                }
                return FileVisitResult.CONTINUE;
            }

            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                // return super.postVisitDirectory(dir, exc);
                return FileVisitResult.CONTINUE;
            }
        });

        // так работает
       /* Files.walk(dir).forEach(path ->
                                {
                                    if (Files.isDirectory(path)) {
                                        System.out.println(path);
                                    }
                                });*/

        // так работает
        /*Files.walkFileTree(dir, new SimpleFileVisitor<Path>()
        {
            public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes
                    attrs)
                    throws IOException
            {
                System.out.println(path);
                return FileVisitResult.CONTINUE;
            }
            public FileVisitResult postVisitDirectory(Path dir, IOException exc)
            {
                return FileVisitResult.CONTINUE;
            }
            public FileVisitResult visitFileFailed(Path path, IOException exc) throws
                                                                               IOException
            {
                return FileVisitResult.SKIP_SUBTREE;
            }
        });*/
    }
}
