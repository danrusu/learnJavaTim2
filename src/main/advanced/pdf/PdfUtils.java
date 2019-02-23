package main.advanced.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public interface PdfUtils {

    static String getText(String filename) throws IOException {

        //Loading an existing document
        File file = new File(filename);
        PDDocument document = PDDocument.load(file);

        String text = "no text";
        try {
            //Instantiate PDFTextStripper class
            PDFTextStripper pdfStripper = new PDFTextStripper();

            //Retrieving text from PDF document
            text = pdfStripper.getText(document);
        }
        finally {
            //Closing the document
            document.close();
        }

        return text;
    }


    static String[] getTextLines(String filename) throws IOException {

        return getText(filename).split("\n");
    }


    static int getLinesCount(String filename) throws IOException {
        return getTextLines(filename).length;
    }


    static boolean comparePDFbyText(String expected, String actual) throws IOException {

        return getText(expected).equals(getText(actual));
    }


    static int getPagesCount(String filename) throws IOException {

        PDDocument document = PDDocument.load(new File(filename));

        int nrOfPages = document.getNumberOfPages();

        document.close();

        return nrOfPages;
    }
}
