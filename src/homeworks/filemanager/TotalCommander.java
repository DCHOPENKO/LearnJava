package homeworks.filemanager;

import com.itextpdf.text.DocumentException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class TotalCommander {
    private static String actualParentPath;
    private static Path actualCurrentPath;
    private static FileService fileService = new FileService();


    public TotalCommander(String rootPath) {
        actualParentPath = rootPath;
    }

    public String getActualParentPath() {
        return actualParentPath;
    }

    public Path getActualCurrentPath() {
        return actualCurrentPath;
    }

    private Path getFullPath(String fileName) {
        return actualCurrentPath = Paths.get(actualParentPath, fileName);
    }

    public void createFile(String fileName) throws IOException {
        fileService.createFile(getFullPath(fileName));
    }

    public void createDir(String fileName) throws IOException {
        fileService.createDir(getFullPath(fileName));
    }

    public void renameFile(String existFileName, String newFileName) throws IOException {
        fileService.rename(getFullPath(existFileName), newFileName);
    }

    public void deleteFile(String fileName) throws IOException {
        fileService.delete(getFullPath(fileName));
    }

    public void copyFile(String existFileName, String DirName) throws IOException {
        fileService.copy(getFullPath(existFileName), getFullPath(DirName));
    }

    public void convertTXTtoPDF(String fileName) throws IOException, DocumentException {
        fileService.convertTXTtoPDF(getFullPath(fileName));
    }

    public void goToUpFolder() {
        String[] string = actualParentPath.split("\\\\");
        string[string.length - 1] = "";
        actualParentPath = String.join(File.separator, Arrays.copyOf(string, string.length - 1));
    }

    public void goToDownFolder(String folderName) {
        actualParentPath = actualParentPath.concat(File.separator).concat(folderName);
      //  actualParentPath = Paths.get(folderName).getRoot().toString();
    }

    public void showElements() throws IOException {
        fileService.showElements(getFullPath(""));
    }



}
