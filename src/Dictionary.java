import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dictionary {
    public static String randomWord() {
        try (Stream<String> lines = Files.lines(Paths.get("src/resources/dictionary.txt"))) {
            Set<String> linesSet = lines
                    .map(line -> line.replaceAll(" ", ""))
                    .filter(line -> line != null && line.length() > 6)
                    .collect(Collectors.toSet());
            Optional<String> randomElement = linesSet.stream()
                    .skip((int) (linesSet.size() * Math.random()))
                    .findFirst();
            return randomElement.orElse("слово");
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return null;
        }
    }
}
