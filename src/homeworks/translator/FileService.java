package homeworks.translator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileService {
    private static final String FILE_EXTENSION = ".txt";

    // import from files to translator
    // clear all files and export all dictionaries from translator in rootpath folder

    public void exportAll(Path rootPath, Set<Dictionary> dictionaries) throws IOException {
        Files.walkFileTree(rootPath, new DeleteVisitor());
        for (Dictionary dictionary : dictionaries) {
            String dictionaryName = dictionary.getName().concat(FILE_EXTENSION);
            Path dictionaryPath = Paths.get(rootPath.toString(), dictionaryName);
            Files.createFile(dictionaryPath);

            Map<String, String> vocabulary = dictionary.getVocabulary();
            List<String> lines = new ArrayList<>();
            for (Map.Entry<String, String> words : vocabulary.entrySet()) {
                lines.add(words.getKey() + ":" + words.getValue());
            }
            Files.write(dictionaryPath, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        }
    }

    public Set<Dictionary> importDictionaries(Path rootPath) throws IOException {
        ImportVisitor importVisitor = new ImportVisitor();
        Files.walkFileTree(rootPath, importVisitor);
        return importVisitor.getDictionaries();
    }

}
