package v2ch01.parallel;

import static java.lang.System.out;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingByConcurrent;
import static java.util.stream.Collectors.toSet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParallelStreams {

    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(
                Paths.get("src/gutenberg/alice30.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));

        // Very bad code ahead
        int[] shortWords = new int[10];
        wordList.parallelStream().forEach(s ->
                                          {
                                              if (s.length() < 10) shortWords[s.length()]++;
                                          });
        out.println(Arrays.toString(shortWords));

        // Try again--the result will likely be different (and also wrong)
        Arrays.fill(shortWords, 0);
        wordList.parallelStream().forEach(s ->
                                          {
                                              if (s.length() < 10) shortWords[s.length()]++;
                                          });
        out.println(Arrays.toString(shortWords));

        // Remedy: Group and count
        Map<Integer, Long> shortWordCounts = wordList.parallelStream()
                                                     .filter(s -> s.length() < 10)
                                                     .collect(groupingBy(String::length, counting()));

        out.println(shortWordCounts);

        // Downstream order not deterministic
        Map<Integer, List<String>> result = wordList.parallelStream()
                                                    .collect(groupingByConcurrent(String::length));

        out.println(result.get(14));

        result = wordList.parallelStream().collect(
                Collectors.groupingByConcurrent(String::length));

        out.println(result.get(14));

        Map<Integer, Long> wordCounts = wordList.parallelStream().collect(
                groupingByConcurrent(String::length, counting()));

        out.println(wordCounts);

        Map<String, Long> wordNameCounts =
                wordList.parallelStream()
                        .collect(
                                groupingByConcurrent(Function.identity(), ConcurrentSkipListMap::new, counting()));

        out.println(wordNameCounts);

        final Map<Integer, List<String>> wordListsGroupingByLength =
                wordList.parallelStream()
                        .collect(groupingByConcurrent(String::length));
        out.println(wordListsGroupingByLength);

        // Set<String> wordSet = new TreeSet<>(wordList);
        Set<String> wordSet = wordList.stream().map(String::toLowerCase).collect(toSet());
        final Map<Integer, List<String>> wordSetsGroupingByLength =
                wordSet.parallelStream().collect(groupingByConcurrent(String::length));
        wordSetsGroupingByLength.forEach((stringLength, stringList) -> out.println(stringLength + " = " + stringList));

        // final int maxStringListSize = wordSetsGroupingByLength.values().stream().mapToInt(List::size).max().getAsInt();
        final Integer maxStringListSizeKey = wordSetsGroupingByLength.entrySet().stream()
                                                    .max(Comparator.comparingInt(e -> e.getValue().size()))
                                                    .get()
                                                    .getKey();
        System.out.println("key '" + maxStringListSizeKey + "' has max list size => " + wordSetsGroupingByLength.get(maxStringListSizeKey));

    }
}
