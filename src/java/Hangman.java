public class Hangman {
    // method to hold the art
    public String getStartingArt()
    {
        String artInitial = "+---+\n" +
                            "    |\n" +
                            "    |\n" +
                            "    |\n" +
                            "  ===\n";

        return artInitial;
    }
    // method to add to the art if a player guesses wrong
    public String getArt(int wrongGuess)
    {
        String oneWrongGuess = "+---+\n" +
                               "O   |\n" +
                               "    |\n" +
                               "    |\n" +
                               "  ===\n";
        String twoWrongGuess = "+---+\n" +
                               "O   |\n" +
                               "|   |\n" +
                               "    |\n" +
                               "  ===\n";

        String threeWrongGuess = "+---+\n" +
                                 "O   |\n" +
                                 "|   |\n" +
                                 "A   |\n" +
                                 "  ===\n";

        switch (wrongGuess)
        {
            case 1:
                return oneWrongGuess;
            case 2:
                return twoWrongGuess;
            case 3:
                return threeWrongGuess;
            default:
                return "Not a valid wrong guess";
        }
    }
    // method to return a random word
    // method to return a list of words to generate
    // method to check if the guess is correct
    // method to run the game
}
