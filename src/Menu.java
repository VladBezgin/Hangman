import java.util.Scanner;

public class Menu {
    private final static int QUIT = 0;
    private final static int START = 1;
    private Scanner scanner = new Scanner(System.in);


    private void printMenu() {
        System.out.println(QUIT + " - Выход из меню");
        System.out.println(START + " - Игра Виселица");
        System.out.print("Ввод: ");
    }

    public void start() {

        HangmanGame hangmanGame = new HangmanGame();
        int menuOption = 1;

        do {
            printMenu();
            if (scanner.hasNextInt()) {
                menuOption = scanner.nextInt();
                switch (menuOption) {
                    case QUIT:
                        System.out.println("Конец сессии!");
                        break;
                    case START:
                        hangmanGame.start(Dictionary.randomWord("src/resources/dictionary.txt"));
                        break;
                    default:
                        System.out.println("Невернный ввод! Введите " + QUIT + " или " + START + ". Ваш ввод: " + menuOption);
                }
            } else {
                String invalidInput = scanner.next();
                System.out.println("Невернный ввод! Введите " + QUIT + " или " + START + ". Ваш ввод: " + invalidInput);
            }
        } while (menuOption != QUIT);
    }
}
