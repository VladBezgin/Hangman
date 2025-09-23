import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HangmanGame {
    private final static int MAX_ERRORS = 6;
    private Scanner scanner = new Scanner(System.in);
    private char[] hiddenWord;
    private char[] wrongLetters = new char[MAX_ERRORS];
    private int numErrors = 0;

    public void start(String secretWord) {
        hiddenWord = new char[secretWord.length()];
        fillingHiddenWord(secretWord.length());
        while (!isGameOver()) {
            HangmanRenderer hangmanRenderer = new HangmanRenderer();
            hangmanRenderer.printPicture(numErrors);
            printHiddenWord();
            printWrongLetters();
            System.out.println("Ошибки: " + numErrors);
            System.out.println("Введите русскую букву: ");
            String rusLetter = scanner.next().toLowerCase();
            if (validateString(rusLetter)) {
                processLetterGuess(secretWord, rusLetter);
            }
        }
        if (isWin()) {
            System.out.println("Победа! Загаданное слово " + secretWord);
        } else {
            new HangmanRenderer().printPicture(numErrors);
            System.out.println("Поражение! Загаданное слово: " + secretWord);
        }
    }

    private void processLetterGuess(String secretWord, String rusLetter) {
        int index = secretWord.indexOf(rusLetter);
        if (index < 0) {
            addWrongLetter(rusLetter);
            System.out.println("Увы, такой буквы нет в загаданном слове.");
        } else {
            revealGuessedLetters(index, rusLetter, secretWord);
        }
    }

    private void addWrongLetter(String rusLetter) {
        wrongLetters[numErrors] = rusLetter.charAt(0);
        numErrors++;
    }

    private boolean isGameOver() {
        return isLose() || isWin();
    }

    private boolean isLose() {
        return numErrors == MAX_ERRORS;
    }

    private boolean isWin() {
        return 0 > new String(hiddenWord).indexOf('_');
    }

    private void revealGuessedLetters(int index, String rusLetter, String secretWord) {
        while (index >= 0) {
            hiddenWord[index] = rusLetter.charAt(0);
            index = secretWord.indexOf(rusLetter, index + 1);
        }
    }

    private void printHiddenWord() {
        String hiddenWordString = IntStream.range(0, hiddenWord.length)
                .mapToObj(i -> String.valueOf(hiddenWord[i]))
                .collect(Collectors.joining(" ", "[", "]"));
        System.out.println("Загаданное слово: " + hiddenWordString);
    }

    private void printWrongLetters() {
        String wrongLettersString = IntStream.range(0, wrongLetters.length)
                .mapToObj(i -> String.valueOf(wrongLetters[i]))
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Использованные ошибочные буквы: " + wrongLettersString);
    }

    private void fillingHiddenWord(int wordLength) {
        for (int i = 0; i < wordLength; i++) {
            hiddenWord[i] = '_';
        }
    }

    private boolean validateString(String letter) {
        if (letter.length() != 1) {
            System.out.println("Вы ввели больше одного символа");
            return false;
        } else if (!isRussianLetter(letter.charAt(0))) {
            System.out.println("Вы не ввели русскую букву");
            return false;
        } else if ((new String(wrongLetters).indexOf(letter) != -1) || (new String(hiddenWord).indexOf(letter) != -1)) {
            System.out.println("Вы уже вводили данную букву");
            return false;
        }
        return true;
    }

    private boolean isRussianLetter(char symbol) {
        return symbol >= 'а' && symbol <= 'я' || symbol == 'ё';
    }
}
