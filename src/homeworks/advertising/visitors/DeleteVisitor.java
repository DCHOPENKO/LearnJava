package homeworks.advertising.visitors;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * A Delete Visitor goes through all the files/directories inside the parent directory and delete file/directory
 *
 * @since 1.7
 */

public class DeleteVisitor extends SimpleFileVisitor<Path> {

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
     * Invoked for a directory after entries in the directory, and all of their
     * descendants, have been visited.
     * If the directory iteration completes without an I/O exception;
     * otherwise this method re-throws the I/O exception that caused the iteration
     * of the directory to terminate prematurely.
     * Unless overridden, this method returns {@link FileVisitResult action(file)}.
     */
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return action(dir);
    }

    /**
     * delete file/directory by provided path
     *
     * @param path - path to file location
     * @return {@link FileVisitResult#CONTINUE}
     */
    private FileVisitResult action(Path path) throws IOException {
        Files.delete(path);
        return FileVisitResult.CONTINUE;
    }
}
