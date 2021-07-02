package homeworks.translator;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class DeleteVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return action(file);
    }

    private FileVisitResult action(Path path) throws IOException {
        Files.deleteIfExists(path);
        return FileVisitResult.CONTINUE;
    }


}
