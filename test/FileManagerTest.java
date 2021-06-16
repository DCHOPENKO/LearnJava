import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import homeworks.filemanager.TotalCommander;
import org.junit.*;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManagerTest {

    private static final String FILE_NAME = "file.txt";
    private static final String FOLDER_NAME = "folder";
    private static final String TEXT_BLOCK = "Hello World";

    @Rule
    public TemporaryFolder tf = new TemporaryFolder();
    private TotalCommander totalCommander;
    private  String startFolder;
    private  Path pathFolder;

    public Boolean isSuchFileIs(Path path, String name) throws IOException {
        return Files.exists(Paths.get(path.toString(), name));
    }

    @Before
    public void createTempFolder() throws IOException {
        startFolder = tf.getRoot().toString();
        pathFolder = Paths.get(startFolder);
        totalCommander = new TotalCommander(startFolder);
    }

    @Test
    public void shouldCreateFile() throws IOException {
        totalCommander.createFile(FILE_NAME);
        Assert.assertTrue(isSuchFileIs(pathFolder, FILE_NAME));
    }

    @Test
    public void shouldCreateFolder() throws IOException {
        totalCommander.createDir(FOLDER_NAME);
        Assert.assertTrue(isSuchFileIs(tf.getRoot().toPath(), FOLDER_NAME));
    }

    @Test
    public void shouldDeleteFolder() throws IOException {
        totalCommander.createDir(FOLDER_NAME);
        totalCommander.deleteFile(FOLDER_NAME);
        Assert.assertFalse(isSuchFileIs(tf.getRoot().toPath(), FOLDER_NAME));
    }

    @Test
    public void shouldDeleteFile() throws IOException {
        totalCommander.createFile(FILE_NAME);
        totalCommander.deleteFile(FILE_NAME);
        Assert.assertFalse(isSuchFileIs(tf.getRoot().toPath(), FILE_NAME));
    }

    @Test
    public void shouldRenameFile() throws IOException {
        totalCommander.createDir(FILE_NAME);
        totalCommander.renameFile(FILE_NAME, "newnams.txt");
        Assert.assertTrue(isSuchFileIs(tf.getRoot().toPath(), "newnams.txt"));
    }

    @Test
    public void shouldCopyFileToNewDir() throws IOException {
        totalCommander.createFile(FILE_NAME);
        totalCommander.createDir("newdir");
        totalCommander.copyFile(FILE_NAME, "newdir");
        Assert.assertTrue(isSuchFileIs(Paths.get(startFolder, "newdir"), FILE_NAME));
    }

    @Test
    public void shouldConvertTxtToPdf() throws IOException, DocumentException {
        createTxtFileWithText(TEXT_BLOCK);
        totalCommander.convertTXTtoPDF(FILE_NAME);
        String pdfFileName = FILE_NAME.replace(".txt", ".pdf");
        Assert.assertTrue(isSuchFileIs(tf.getRoot().toPath(), pdfFileName));
    }

    @Test
    public void shouldTransferTextFromTxtToPdf() throws IOException, DocumentException {
        createTxtFileWithText(TEXT_BLOCK);
        totalCommander.convertTXTtoPDF(FILE_NAME);
        String pdfFileName = FILE_NAME.replace(".txt", ".pdf");
        PdfReader reader;
        try {
            reader = new PdfReader(Paths.get(startFolder, pdfFileName).toString());
            String textFromPage = PdfTextExtractor.getTextFromPage(reader, 1);
            reader.close();
            Assert.assertEquals(TEXT_BLOCK, textFromPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGoDownIntoFolder() throws IOException {
        totalCommander.createDir(FOLDER_NAME);
        totalCommander.goToDownFolder(FOLDER_NAME);
        Assert.assertEquals(Paths.get(tf.getRoot().toString(), FOLDER_NAME).toString(),
                totalCommander.getActualParentPath());
    }

    @Test
    public void shouldGoUpOneLevelFolders() {
        totalCommander.goToUpFolder();
        Assert.assertTrue(totalCommander.getActualParentPath().endsWith("Temp"));
    }

    private void createTxtFileWithText(String textBlock) throws IOException {
        totalCommander.createFile(FILE_NAME);
        Files.write(totalCommander.getActualCurrentPath(), textBlock.getBytes());
    }
}
