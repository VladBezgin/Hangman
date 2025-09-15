public class DrawingHangman {
    public static void drawHangman(int numErrors){
        switch (numErrors){
            case 0:
                System.out.print("""
                           ______
                           |    |
                           |    
                           |   
                           |   
                           |
                        ___|______
                        """);
                break;
            case 1:
                System.out.print("""
                           ______
                           |    |
                           |    O
                           |   
                           |   
                           |
                        ___|______
                        """);
                break;
            case 2:
                System.out.print("""
                           ______
                           |    |
                           |    O
                           |    |
                           |   
                           |
                        ___|______
                        """);
                break;
            case 3:
                System.out.print("""
                           ______
                           |    |
                           |    O
                           |   /|
                           |   
                           |
                        ___|______
                        """);
                break;
            case 4:
                System.out.print("""
                           ______
                           |    |
                           |    O
                           |   /|\\
                           |   
                           |
                        ___|______
                        """);
                break;
            case 5:
                System.out.print("""
                           ______
                           |    |
                           |    O
                           |   /|\\
                           |   / 
                           |
                        ___|______
                        """);
                break;
            case 6:
                System.out.print("""
                           ______
                           |    |
                           |    O
                           |   /|\\
                           |   / \\
                           |
                        ___|______
                        """);
                break;
            default:
                System.out.println("Неверный ввод!");
        }
    }
}
