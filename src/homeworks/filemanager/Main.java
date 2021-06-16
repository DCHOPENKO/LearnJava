package homeworks.filemanager;

import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner READER = new Scanner(System.in);
    private static final String ROOTPATH = "D:\\temp\\File Manager Source Folder";
    private static final TotalCommander COMMANDER = new TotalCommander(ROOTPATH);
    private static boolean isWork = true;

    public static void main(String[] args) throws IOException, DocumentException {

        while (isWork) {
            openMainWindow();
        }

    }

    private static void openMainWindow() throws IOException, DocumentException {
        showHeader();
        showBody();
        showFooter();
        System.out.println("<<< Select operation >>>");
        int input = READER.nextInt();
        switch (input) {
            case 1:   // down into folder
                COMMANDER.goToDownFolder(inputName("Input folder name"));
                openMainWindow();
                break;
            case 2:   //  go up folder
                COMMANDER.goToUpFolder();
                openMainWindow();
                break;
            case 3: //  exit
                closeApp();
                break;
            case 4:  // createFile
                COMMANDER.createFile(inputName("Input file name"));
                openMainWindow();
                break;
            case 5:  //  createFolder
                COMMANDER.createDir(inputName("Input folder name"));
                openMainWindow();
                break;
            case 6:  // rename
                COMMANDER.renameFile(inputName("Input existing file/folder name"),
                        inputName("Input new file/folder name"));
                openMainWindow();
                break;
            case 7:  // copy
                COMMANDER.copyFile(inputName("Input which file need to copy"),
                        inputName("Input folder name to which need to copy file"));
                openMainWindow();
                break;
            case 8:  // delete
                COMMANDER.deleteFile(inputName("Input file/folder name to delete"));
                break;
            case 9:  // convert to PDF
                COMMANDER.convertTXTtoPDF(inputName("Input file name to convert to PDF)"));
                openMainWindow();
                break;
            default:
                System.out.println("Incorrect input");
                openMainWindow();
                break;
        }
    }

    private static String inputName(String text) {
        System.out.println(text);
        return READER.next();
    }

    private static void showHeader() {
        System.out.println("<<<---<<<---<<<   TOTAL COMMANDER   >>>--->>>--->>>");
        System.out.println("Path:-->" + COMMANDER.getActualParentPath() + "\\");
    }

    private static void showBody() throws IOException {
        System.out.println("<<<---<<<---<<<     MAIN SCREEN     >>>--->>>--->>>");
        COMMANDER.showElements();
    }

    private static void showFooter() {
        System.out.println("<<<---<<<---<<<---<<<     Navigation     >>>--->>>--->>>--->>>");
        System.out.println("1. OpenDir | 2. GoUpDir | 3. Exit");
        System.out.println("<<<---<<<---<<<---<<< Actions with DIR/Files >>>--->>>--->>>--->>>");
        System.out.println("4. Create File | 5. Create DIR | 6. Rename | 7. Copy | 8. Delete");
        System.out.println("<<<---<<<---<<<---<<< Actions with Files >>>--->>>--->>>--->>>");
        System.out.println("9. ConvertToPDF ");
    }

    private static void closeApp() {
        READER.close();
        isWork = false;
    }

    public int getNumberOfFiles() throws FileNotFoundException {
        try {
            return 1;
        } catch (IllegalArgumentException | NullPointerException e) {
//            e = new NullPointerException();

        } finally {
            throw new NullPointerException();
        }

    }
}
