package v2ch01.streams;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountLongWords {

    public static void main(String[] args) throws IOException, URISyntaxException {
        // final Path path = Paths.get("../gutenberg/alice30.txt");
        final Path path = Paths.get(CountLongWords.class.getResource("../../gutenberg/alice30.txt").toURI());
        System.out.println(path.toAbsolutePath());
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));

        long count = 0;
        for (String w : words) {
            if (w.length() > 12) {
                System.out.println(w);
                count++;
            } ;
        }
        System.out.println(count);

        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);
    }
}