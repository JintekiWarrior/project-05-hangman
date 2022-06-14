import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {
    Hangman game;
    @BeforeEach
    void setUp() {
        game = new Hangman();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRandomWord() {
        String expected = "Banana";
        game.randomWord = "Banana";
        String actual = game.randomWord;
        assertEquals(expected, actual);

    }

    @Test
    void getCorrectGuesses() {
        String actual = game.getCorrectGuesses();
        assertNotNull(actual);
    }

    @Test
    void setArt() {
        String expected = "+---+\n" +
                          "O   |\n" +
                          "    |\n" +
                          "    |\n" +
                          "  ===\n";
        game.setArt(1);
        String actual = game.getArt();
        assertEquals(expected, actual);
    }

    @Test
    void setMissedGuesses() {
        String expected = "Missed Guesses: a";
        game.setMissedGuesses("a");
        String actual = game.missedGuesses;
        assertEquals(expected, actual);

    }

    @Test
    void setCorrectLettersGuessed() {
        game.randomWord = "BAT";
        game.setCorrectLettersGuessed("A");
        assertTrue(game.correctLettersGuessed.contains("A"));
    }

    @Test
    void isGuessCorrect() {
        game.randomWord = "BAT";
        boolean expected = false;
        boolean actual = game.isGuessCorrect("S");

        assertEquals(expected, actual);
    }
}