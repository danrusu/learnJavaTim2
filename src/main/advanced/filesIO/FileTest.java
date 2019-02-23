package main.advanced.filesIO;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class FileTest {

    public static void main(String[] args) throws IOException {

        String userDir = System.getProperty("user.dir");

        Path englishWordsPath = Paths.get(
                userDir,
                "Resource",
                "Dictionary",
                "english_words.txt"
        );

        // 1. Copy full path click or open english_words.txt and CTRL + SHIFT + C
        // 2. Paste full path
        String path = "C:\\Users\\dan.rusu.IN\\Desktop\\SDA\\learnJavaTim2\\Resource\\Dictionary\\english_words.txt";

        System.out.println(path.equals(englishWordsPath));

        System.out.println("\n\nEnglish words path: \n"
                + englishWordsPath);

        List<String> lines = Files.readAllLines(englishWordsPath);

        // final Predicate<String> isEmptyLine = line -> line.isEmpty();
        final Predicate<String> isEmptyLine = String::isEmpty;
        final Predicate<String> isLineCommented = line -> line.startsWith("//");

        List<String> validLines = lines.stream()
                .filter(isEmptyLine.negate())
                .filter(isLineCommented.negate())
                .collect(toList());

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
