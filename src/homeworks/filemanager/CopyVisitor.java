package homeworks.filemanager;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyVisitor extends SimpleFileVisitor<Path> {

    private Path newDir;

    public CopyVisitor(Path newDir) {
        this.newDir = newDir;
    }

    public void setNewDir(Path newDir) {
        this.newDir = newDir;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return action(file, newDir);
    }

    private FileVisitResult action(Path file, Path newDir) throws IOException {

        Files.copy(file, newDir.resolve(file.getFileName()), StandardCopyOption.REPLACE_EXISTING);

        return FileVisitResult.CONTINUE;
    }
}
