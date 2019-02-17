package main.advanced.filesIO;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FileTest {

    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");

        Path englishWordsPath = Paths.get(
                userDir,
                "Resource",
                "Dictionary",
                "english_words.txt"
        );


        String path = "C:\\Users\\dan.rusu.IN\\Desktop\\SDA\\learnJavaTim2\\Resource\\Dictionary\\english_words.txt";

        System.out.println("\n\nEnglish words path: \n"
                + englishWordsPath);

        List<String> lines = Files.readAllLines(englishWordsPath);

        final Predicate<String> isEmptyLine = line -> line.isEmpty();
        final Predicate<String> isLineCommented = line -> line.startsWith("//");
        List<String> validLines = lines.stream()
                .filter(isEmptyLine.negate())
                .filter(isLineCommented.negate())
                .collect(Collectors.toList());

        validLines.forEach(System.out::println);

        // get a map of (key, value) = (wordId, wordInEnglish)
    }

    @Test
    public void string_split_test(){

        String x = "This is  a test! If    you run it, you will get all the words; right    ? Great. ";
        String[] tokens = x.split("\\s*(|,|;|!|\\.|\\?)*\\s+");
        System.out.println(Arrays.toString(tokens));
    }

}
