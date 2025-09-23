public class HangmanRenderer {
    private static final String[] PICTURES = {
            """
                           ______
                           |    |
                           |    
                           |   
                           |   
                           |
                        ___|______
                        """,
            """
                           ______
                           |    |
                           |    O
                           |   
                           |   
                           |
                        ___|______
                        """,
            """
                           ______
                           |    |
                           |    O
                           |    |
                           |   
                           |
                        ___|______
                        """,
            """
                           ______
                           |    |
                           |    O
                           |   /|
                           |   
                           |
                        ___|______
                        """,
            """
                           ______
                           |    |
                           |    O
                           |   /|\\
                           |   
                           |
                        ___|______
                        """,
            """
                           ______
                           |    |
                           |    O
                           |   /|\\
                           |   / 
                           |
                        ___|______
                        """,
            """
                           ______
                           |    |
                           |    O
                           |   /|\\
                           |   / \\
                           |
                        ___|______
                        """
    };

    public void printPicture(int numPicture) {
        System.out.println(PICTURES[numPicture]);
    }
}
