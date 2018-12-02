package KoonFungYee;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.RecursiveAction;

public class ReadPDF extends RecursiveAction {
    public final static List<Row> rows=new ArrayList<>();

    public static void read() throws IOException {
        PDDocument document = PDDocument.load(new File("Word-list-5-and-6.pdf"));
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);
        Scanner scan = new Scanner(text);

        //Save data to Row class
        while (scan.hasNextLine())
        {
            String line = scan.nextLine();
            String upperCase=line.toUpperCase();
            rows.add(new Row(upperCase));
        }
        document.close();
    }

    @Override
    protected void compute() {

    }
}


