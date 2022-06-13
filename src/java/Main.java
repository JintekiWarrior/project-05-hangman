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
            int goodGuesses = 0;
            // iterate in a while loop that ends if the player misses 4 guesses
            while(missedGuesses <= 3 && !hangman.getCorrectGuesses().equals(hangman.getRandomWord()))
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

                guess = guess.toUpperCase();
                System.out.println(guess);

                // check if the guess is correct using the Hangman method
                if (hangman.isGuessCorrect(guess))
                {
                    System.out.println("Awesome! You guessed correctly");
                    goodGuesses++;
                    hangman.updateCorrectGuessFields(guess);
                } else
                {
                    System.out.println("uh oh! You guessed poorly");
                    missedGuesses++;
                    hangman.updateIncorrectGuessFields(guess, missedGuesses);
                }

            }
            System.out.println("The word was " + hangman.getRandomWord());

            // check for a win or a loss
            if (missedGuesses > 3)
            {
                System.out.println("Better luck next time");
            } else
            {
                System.out.println("Great Job, you won!");
            }

            System.out.println("Would you like to play again? (y or n)?");
            String answer = "";
            try
            {
                answer = gameScanner.nextLine();
            } catch(Exception err)
            {
                System.out.println(err.getClass().getName());
            }

            answer = answer.toUpperCase();
            System.out.println(answer);
            String n = "N";

            if (answer.equals(n))
            {
                System.out.println("Come back soon");
                playAgain = false;
            }

        } while(playAgain);

        gameScanner.close();
    }
}
