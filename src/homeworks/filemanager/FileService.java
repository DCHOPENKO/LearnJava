package homeworks.filemanager;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumSet;

public class FileService {

    public void showElements(Path path) throws IOException {
        Files.walkFileTree(path, EnumSet.noneOf(FileVisitOption.class), 1, new ViewerVisitor());
    }

    public void createDir(Path path) throws IOException {
        deleteIfExist(path);
        Files.createDirectory(path);
    }

    public void createFile(Path path) throws IOException {
        deleteIfExist(path);
        Files.createFile(path);
    }

    public void delete(Path path) throws IOException {
        Files.walkFileTree(path, new DeleteVisitor());
    }

    private void deleteIfExist(Path path) throws IOException {
        if (Files.exists(path)) {
            delete(path);
        }
    }

    public void rename(Path path, String newName) throws IOException {
        Files.move(path, path.resolveSibling(newName));
    }

    public void copy(Path path, Path newDir) throws IOException {
        Files.walkFileTree(path, new CopyVisitor(newDir));
    }

    public void convertTXTtoPDF(Path path) throws IOException, DocumentException {
        Document pdfDoc = new Document();
        String fullPath = String.valueOf(path.toAbsolutePath());

        String pathToPdf = fullPath.replace(".txt", ".pdf");

        PdfWriter.getInstance(pdfDoc, new FileOutputStream(pathToPdf));

        pdfDoc.open();

        byte[] bytes = Files.readAllBytes(path);

        String text = new String(bytes);

        Paragraph pdfLine = new Paragraph(text);
        pdfDoc.add(pdfLine);

        pdfDoc.close();
    }

}
