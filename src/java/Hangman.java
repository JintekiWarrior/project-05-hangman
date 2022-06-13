import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hangman {

    /********** FIELDS **********/
    // The word the player will try and guess
    private String randomWord;

    private String art;

    // random word as a list
    ArrayList<String> randomWordList;

    // List of unguessed letters
    ArrayList<String> correctLettersGuessed;

    // String that will be displayed of the missed player guesses
    private String missedGuesses = "Missed Guesses: ";

    /********** CONSTRUCTORS **********/

    public Hangman()
    {
        this.art = "+---+\n" +
                   "    |\n" +
                   "    |\n" +
                   "    |\n" +
                   "  ===\n";
        this.randomWord = generateRandomWord();
        this.randomWordList = new ArrayList<>(Arrays.asList(this.randomWord.split(" ")));
        this.correctLettersGuessed = generateCorrectGuessesList();
    }

    /********** GETTERS **********/

    // method to hold the art
    private String getArt()
    {
        return this.art;
    }

    // get the random word that was generated
    public String getRandomWord()
    {
        return this.randomWord;
    }

    // method to display the missed letters
    private String getMissedGuesses()
    {
        return missedGuesses;
    }

    // display correct guesses
    private String getCorrectGuesses()
    {
        return String.join("", correctLettersGuessed);
    }

    /********** SETTERS **********/

    // method to add to the art if a player guesses wrong
    public void setArt(int wrongGuess)
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
                art = oneWrongGuess;
                break;
            case 2:
                art = twoWrongGuess;
                break;
            case 3:
                art = threeWrongGuess;
            default:
                System.out.println("Error not a valid wrong guess" + wrongGuess);
        }
    }

    // Add a missed letter to the list and update the missedGuess string
    public void setMissedGuesses(String guess)
    {
        missedGuesses = missedGuesses + " " + guess;
    }

    // method to display the correct letters
    public void setCorrectLettersGuessed(String guess)
    {
        // if the players guess is contained in the random word get the index
        int index = randomWordList.indexOf(guess);
        // update correctLettersGuessed list to include the players guess at the same index as the word
        correctLettersGuessed.add(index, guess);
    }

    /********** Checkers **********/

    // method to check if the guess is correct
    public boolean isGuessCorrect(String guess)
    {
        return this.randomWord.contains(guess);
    }

    /********** Private Methods **********/

    // method to generate a random word using the word list
    private String generateRandomWord()
    {
        String[] wordList =
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

        int randomNumber = (int)Math.floor(Math.random()*(wordList.length - 1) + 1);
        return wordList[randomNumber];
    }

    private ArrayList<String> generateCorrectGuessesList()
    {
        ArrayList<String> correctWordList = new ArrayList<>();

        for (int i = 0; i < this.randomWord.length(); i++)
            correctWordList.add("_");
        return correctWordList;
    }

    /********** Public Methods **********/
    public void displayAllGameGraphics()
    {
        System.out.println(getArt());
        System.out.println(getMissedGuesses());
        System.out.println(getCorrectGuesses());
    }

    public void updateCorrectGuessFields(String guess)
    {
        setCorrectLettersGuessed(guess);
    }

    public void updateIncorrectGuessFields(String guess, int missedGuesses)
    {
        setArt(missedGuesses);
        setMissedGuesses(guess);
    }
}
