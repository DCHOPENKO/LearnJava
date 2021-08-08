package homeworks.advertising.visitors;

import homeworks.advertising.advertiser_source_classes.Content;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

/**
 * A Change Content Visitor goes through all the files inside the directory and, according to the conditions,
 * replaces the existing content with a new one (text in the file)
 *
 * @since 1.7
 */

public class ChangeContentVisitor extends SimpleFileVisitor<Path> {

    /** instance with 2 String parameters (existContent and newContent)  */
    private final Content content;

    /**
     * Create a new instance ChangeContentVisitor class. Create instance with 1 parameter type Content  with source data
     * Use constructor for Content instance with 2 parameters
     *
     * @param content - stores and transmits information by 2 String parameters (existingContent and newContent)
     */
    public ChangeContentVisitor(Content content) {
        this.content = content;
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
     * Check if file satisfies condition - file with end ".txt". Then check if file have existContent inside then update
     * file to new text (newContent)
     *
     * @param path - path to file location
     * @return {@link FileVisitResult#CONTINUE}
     */
    private FileVisitResult action(Path path) throws IOException {
        if (path.getFileName().toString().contains(".txt"))
            if (Arrays.toString(Files.readAllBytes(path)).equals(content.getExistContent()))
                Files.write(path, content.getNewContent().getBytes());
        return FileVisitResult.CONTINUE;
    }
}
