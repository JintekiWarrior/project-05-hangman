import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner gameScanner = new Scanner(System.in);
        boolean playAgain = true;


        do {
            // initialize new Hangman object
            Hangman hangman = new Hangman();
            // initialize missedGuesses counter variable
            int missedGuesses = 0;
            // iterate in a while loop that ends if the player misses 4 guesses
            while(missedGuesses <= 3)
            {
                // first display Hangman fields
                System.out.println("HANGMAN");
                hangman.displayAllGameGraphics();
                // ask the player to guess
                System.out.println("Guess a letter: ");
                String guess = "";

                try
                {
                    guess = gameScanner.nextLine();
                } catch(Exception err)
                {
                    System.out.println(err.getClass().getName());
                }

                guess.toUpperCase();

                // check if the guess is correct using the Hangman method
                if (hangman.isGuessCorrect(guess))
                {
                    System.out.println("Awesome! You guessed correctly");
                    hangman.updateCorrectGuessFields(guess);
                } else
                {
                    System.out.println("Sorry guessed incorrectly");
                    missedGuesses++;
                    hangman.updateIncorrectGuessFields(guess, missedGuesses);
                }
            }
            System.out.println("The word was " + hangman.getRandomWord());
            System.out.println("Would you like to play again? (y or n)?");
            String answer = gameScanner.nextLine();
            try
            {
                answer = gameScanner.nextLine();
            } catch(Exception err)
            {
                System.out.println(err.getClass().getName());
            }

            if (answer == "n") playAgain = false;

        } while(playAgain);

        gameScanner.close();
    }
}
