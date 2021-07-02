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

public class DataExport {

    public static Path getPath(String stringPath) {
        return Paths.get(stringPath);
    }

    public void exportAll(Path rootPath, Map<String, Map<String, String>> dictionaries) throws IOException {
        Files.walkFileTree(rootPath, new DeleteVisitor());
        for (Map.Entry<String, Map<String, String>> map : dictionaries.entrySet()) {
            String dictionaryName = map.getKey().concat(".txt");
            Path dictionaryPath = Paths.get(rootPath.toString(), dictionaryName);
            Files.createFile(dictionaryPath);
            Map<String, String> dictionary = map.getValue();
            List<String> lines = new ArrayList<>();
            for (Map.Entry<String, String> words : dictionary.entrySet()) {
                lines.add(words.getKey() + ":" + words.getValue());
            }
            Files.write(dictionaryPath, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        }
    }

    public Map<String, Map<String, String>> importAll(Path rootPath) throws IOException {
        ImportVisitor importVisitor = new ImportVisitor();
        Files.walkFileTree(rootPath, importVisitor);
        return importVisitor.getDictionaries();
    }

    // import from files to translator
    //
    // clear all files and export all dictionaries from translator in rootpath folder

}
