package homeworks.advertising.visitors;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * A Clear Content Visitor goes through all the files inside the directory and, according to the conditions,
 * clear all data inside files (text in the file)
 *
 * @since 1.7
 */

public class ClearContentVisitor extends SimpleFileVisitor<Path> {

    /** empty text block  */
    private static final String EMPTY_BLOCK = "";

    /**
     * Invoked for a file in a directory.
     *
     * Unless overridden, this method returns {@link FileVisitResult action(file)}.
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return action(file);
    }

    /**
     * Check if file satisfies condition - file with end ".txt". Then clear all data inside file
     *
     * @param path - path to file location
     * @return {@link FileVisitResult#CONTINUE}
     */
    private FileVisitResult action(Path path) throws IOException {
        if (path.getFileName().toString().contains(".txt"))
            Files.write(path, EMPTY_BLOCK.getBytes());
        return FileVisitResult.CONTINUE;
    }
}
