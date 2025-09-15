import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HangmanGame {
    private Scanner in = new Scanner(System.in);

    private static boolean validateCharacter(String letter, char[] wrongLetters, char[] hiddenWord) {
        if (letter.length() != 1) {
            System.out.println("Вы ввели больше одного символа");
            return false;
        } else if (!((letter.charAt(0) >= 'а' && letter.charAt(0) <= 'я') || letter.charAt(0) == 'ё')) {
            System.out.println("Вы не ввели русскую букву");
            return false;
        } else if ((new String(wrongLetters).indexOf(letter) != -1) || (new String(hiddenWord).indexOf(letter) != -1)) {
            System.out.println("Вы уже вводили данную букву");
            return false;
        } else {
            return true;
        }
    }

    public void run(String secretWord) {
        int numErrors = 0;
        //System.out.println(secretWord);
        char[] hiddenWord = new char[secretWord.length()];
        char[] wrongLetters = new char[6];
        for (int i = 0; i < hiddenWord.length; i++) {
            hiddenWord[i] = '_';
        }
        while (numErrors < 6) {
            DrawingHangman drawingHangman = new DrawingHangman();
            drawingHangman.drawHangman(numErrors);
            String hiddenWordString = IntStream.range(0, hiddenWord.length)
                    .mapToObj(i -> String.valueOf(hiddenWord[i]))
                    .collect(Collectors.joining(" ", "[", "]"));

            String wrongLettersString = IntStream.range(0, wrongLetters.length)
                    .mapToObj(i -> String.valueOf(wrongLetters[i]))
                    .collect(Collectors.joining(", ", "[", "]"));

            System.out.println("Загаданное слово: " + hiddenWordString);
            System.out.println("Использованные ошибочные буквы: " + wrongLettersString);
            System.out.println("Ошибки: " + numErrors);
            System.out.println("Введите русскую букву: ");

            String rusLetter = in.next().toLowerCase();
            if (validateCharacter(rusLetter, wrongLetters, hiddenWord)) {
                int index = secretWord.indexOf(rusLetter);
                if (index < 0) {
                    wrongLetters[numErrors] = rusLetter.charAt(0);
                    numErrors++;
                    System.out.println("Увы, такой буквы нет в загадоном слове.");

                } else {
                    //проверка на вхождение символа
                    while (index >= 0) {
                        hiddenWord[index] = rusLetter.charAt(0);
                        index = secretWord.indexOf(rusLetter, index + 1);
                    }
                    String subStr = new String(hiddenWord);
                    if (0 > subStr.indexOf('_')) {
                        System.out.println("Победа");
                        break;
                    }
                }
            }
        }
        if(numErrors == 6) {
        System.out.println("Порожение, загаданное слово: " + secretWord);
        }
    }
}
