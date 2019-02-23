package main.advanced.utils;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;


public class FileUtilsTest {


    @Test
    public void test_file_utils() {

        Path fullFilePath = FileUtils.getLocalPath(
                "Resource",
                "pdf",
                "dummy.pdf");

        // user dir
        System.out.println(FileUtils.getLocalPath());

        System.out.println(fullFilePath);

        // linux path using / separator
        System.out.println(Paths.get("C:/Users/dan.rusu.IN"));
    }
}
