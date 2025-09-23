import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public final class Dictionary {
    private final static int MIN_WORD_LENGTH = 6;
    private static final Random RANDOM = new Random();

    private Dictionary() {
    }

    public static String randomWord(String filePath) {
        Path absolutePath = Paths.get(filePath).toAbsolutePath();
        List<String> words = readWordsFromFile(filePath, absolutePath);
        validateWordsList(words, absolutePath);
        return getRandomWord(words);
    }

    private static List<String> readWordsFromFile(String filePath, Path absolutePath) {
        try {
            return Files.readAllLines(Path.of(filePath))
                    .stream()
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .filter(Dictionary::isValidWord)
                    .toList();
        } catch (IOException e) {
            System.err.println("Ошибка: Не удалось открыть файл со словами по пути: " + absolutePath);
            System.err.println("Программа будет завершена.");
            System.exit(1);
            return List.of();
        }
    }

    private static boolean isValidWord(String word) {
        return word.length() >= MIN_WORD_LENGTH &&
                word.chars().allMatch(Character::isLetter);
    }

    private static void validateWordsList(List<String> words, Path absolutePath) {
        if (words.isEmpty()) {
            System.err.println("Ошибка: Файл словаря '" + absolutePath + "' не содержит подходящих слов.");
            System.err.println("Слова должны содержать только буквы и иметь длину не менее " +
                    MIN_WORD_LENGTH + " символов.");
            System.err.println("Программа будет завершена.");
            System.exit(1);
        }
    }

    private static String getRandomWord(List<String> words) {
        return words.get(RANDOM.nextInt(words.size()));
    }

}
