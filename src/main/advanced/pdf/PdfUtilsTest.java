package main.advanced.pdf;

import main.advanced.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PdfUtilsTest {


    @Test
    public void dummy_test() throws IOException {

        final String EXPECTED_DUMMY_TEXT = "Dummy PDF file\r\n";

        String dummyText = PdfUtils.getText(
                getPdfResourcePath("dummy.pdf"));

        System.out.println("\"" + dummyText + "\"");

        Assertions.assertEquals(
                EXPECTED_DUMMY_TEXT,
                dummyText);
    }

    @Test
    public void singlePage_lines_count_test() throws IOException {

        final int EXPECTED_LINES_COUNT = 17;

        String text = PdfUtils.getText(
                getPdfResourcePath("singlePage.pdf"));

        System.out.println("\"" + text + "\"");

        int linesCount = PdfUtils
                .getTextLines(getPdfResourcePath("singlePage.pdf"))
                .length;

        Assertions.assertEquals(
                EXPECTED_LINES_COUNT,
                linesCount);
    }

    @Test
    public void multiplePage_pages_count_test() throws IOException {

        final int EXPECTED_PAGES_COUNT = 3;

        int pagesCount = PdfUtils.getPagesCount(
                getPdfResourcePath("multiPage.pdf")
        );

        System.out.println("Pages count: " + pagesCount);

        Assertions.assertEquals(
                EXPECTED_PAGES_COUNT,
                pagesCount);
    }

    private String getPdfResourcePath(String fileName){

        return FileUtils.getLocalPath(
                "RESOURCE",
                "advancedCoding",
                "pdf",
                fileName
        ).toString();
    }
}
