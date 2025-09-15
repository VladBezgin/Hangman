import java.util.Scanner;

public class Menu {
    private Scanner in = new Scanner(System.in);


    private void printMenu() {
        System.out.println("0 - Выход из меню");
        System.out.println("1 - Игра Виселица");
        System.out.print("Ввод: ");
    }

    public void run() {

        Dictionary dictionary = new Dictionary();
        HangmanGame hangmanGame = new HangmanGame();
        int menuOption = 1;
        do {
            printMenu();
            menuOption = in.nextInt();
            switch (menuOption) {
                case 0:
                    System.out.println("Конец сессии!");
                    break;
                case 1:
                    hangmanGame.run(dictionary.randomWord());
                    break;
                default:
                    System.out.println("Неверный ввод!");
            }
        } while (menuOption != 0);
    }
}
