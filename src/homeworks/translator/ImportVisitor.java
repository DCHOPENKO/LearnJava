package homeworks.translator;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImportVisitor extends SimpleFileVisitor<Path> {
    Set<Dictionary> dictionaries = new HashSet<>();

    public Set<Dictionary> getDictionaries() {
        return dictionaries;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return action(file);
    }

    private FileVisitResult action(Path path) throws IOException {
        String dictionaryName = path.getFileName().toString().replace(".txt", "");
        Dictionary dictionary = new Dictionary(dictionaryName);
        List<String> listLines = Files.readAllLines(path);
        for (String line : listLines) {
            String[] words = line.split("[:]");
            dictionary.addNewWords(words[0], words[1]);
        }
        dictionaries.add(dictionary);
        return FileVisitResult.CONTINUE;
    }

}
