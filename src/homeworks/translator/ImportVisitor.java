package homeworks.translator;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImportVisitor extends SimpleFileVisitor<Path> {
    Map<String, Map<String, String>> dictionaries = new HashMap<>();

    public Map<String, Map<String, String>> getDictionaries() {
        return dictionaries;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return action(file);
    }

    private FileVisitResult action(Path path) throws IOException {
        Map<String, String> dictionary = new HashMap<>();
        List<String> listLines = Files.readAllLines(path);
        for (String line : listLines) {
            String [] words = line.split("[:]");
            dictionary.put(words[0], words[1]);
        }
        String dictionaryName = path.getFileName().toString().replace(".txt", "");
        dictionaries.put(dictionaryName, dictionary);
        return FileVisitResult.CONTINUE;
    }


}
