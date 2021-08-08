package homeworks.advertising.visitors;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * A Write Content Visitor goes through all the files inside the directory and, according to the conditions,
 * add new content into file (text in the file)
 *
 * @since 1.7
 */

public class WriteContentVisitor extends SimpleFileVisitor<Path> {

    /** text with new Content data  */
    private final String newContent;

    /**
     * Create a new instance ChangeContentVisitor class. Create instance with 1 parameter type String  with text data
     *
     * @param newContent - text with new Content data
     */
    public WriteContentVisitor(String newContent) {
        this.newContent = newContent;
    }

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
     * Check if file satisfies condition - file with end ".txt". Then write text (newContent) to file
     *
     * @param path - path to file location
     * @return {@link FileVisitResult#CONTINUE}
     */
    private FileVisitResult action(Path path) throws IOException {
        if (path.getFileName().toString().contains(".txt"))
            Files.write(path, newContent.getBytes());
        return FileVisitResult.CONTINUE;
    }
}