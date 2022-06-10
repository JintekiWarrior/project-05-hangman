import java.util.ArrayList;
import java.util.Arrays;

public class Hangman {
    private String[] wordList =
            {
            "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE",
            "CASE", "CATCH", "CHAR", "CLASS", "CONST",
            "CONTINUE", "DEFAULT", "DOUBLE", "DO", "ELSE",
            "ENUM", "EXTENDS", "FALSE", "FINAL", "FINALLY",
            "FLOAT", "FOR", "GOTO", "IF", "IMPLEMENTS",
            "IMPORT", "INSTANCEOF", "INT", "INTERFACE", "LONG",
            "NATIVE", "NEW", "NULL", "PACKAGE", "PRIVATE",
            "PROTECTED", "PUBLIC", "RETURN", "SHORT", "STATIC",
            "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED",
            "THIS", "THROW", "THROWS", "TRANSIENT", "TRUE",
            "TRY", "VOID", "VOLATILE", "WHILE"
            };

    // The word the player will try and guess
    private String randomWord;

    // The wrong letters the player has guessed
    private ArrayList<String> missedLetters = new ArrayList<>();

    // The correct word as a list
    private ArrayList<String> randomWordList = new ArrayList<>();

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

    // method to generate a random word and store it in the random word variable
    public void generateRandomWord()
    {
        int randomNumber = (int)Math.floor(Math.random()*(this.wordList.length - 1) + 1);
        this.randomWord = this.wordList[randomNumber];
    }

    // get the random word that was generated
    public String getRandomWord()
    {
        return this.randomWord;
    }

    // method to check if the guess is correct
    public boolean isGuessCorrect(String guess)
    {
        return this.randomWord.contains(guess);
    }

    // Add a missed letter to the list
    public void updateMissedLetters(String letter)
    {
        this.missedLetters.add(letter);
    }

    // method to display the missed letters
    public String missedLettersDisplay()
    {
        String text = "Missed letters: ";

        for (String letter : this.missedLetters) text += letter;

        return text;
    }

    // method to display the correct letters
    public String displayLetters(String guess)
    {
        // make a list of the randomWord
        // make a list of empty letters the same length as the randomWord

        // if the players guess is contained in the random word get the index
        // update the list of empty letters to include the players guess at the same index as the word

        // return the empty list as a string
    }

}
