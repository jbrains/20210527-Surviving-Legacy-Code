package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.approvaltests.Approvals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CheckOutputFromOriginalGameRunner {
    private PrintStream stdout;

    private boolean notAWinner;

    @Before
    public void rememberStdout() throws Exception {
        stdout = System.out;
    }

    @After
    public void resetStdout() throws Exception {
        System.setOut(stdout);
    }

    @Test
    public void severalGames() throws Exception {
        final ByteArrayOutputStream canvasAsStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvasAsStream));

        final int howManyGames = 10;
        final int startingGameId = 762;
        final Map<Integer, String> messagesByGame = runGames(canvasAsStream, howManyGames, startingGameId);
        Approvals.verify(messagesByGame);
    }

    private Map<Integer, String> runGames(final ByteArrayOutputStream canvasAsStream, final int howManyGames, final int startingGameId) {
        final Map<Integer, String> messagesByGame = new HashMap<>();
        for (int i = 0; i < howManyGames; i++) {
            final int gameId = startingGameId + i * 19;

            Game aGame = new Game();

            aGame.add("Chet");
            aGame.add("Pat");
            aGame.add("Sue");
            Random rand = new Random(gameId);

            do {
                aGame.roll(rand.nextInt(5) + 1);

                if (rand.nextInt(9) == 7) {
                    notAWinner = aGame.wrongAnswer();
                }
                else {
                    notAWinner = aGame.wasCorrectlyAnswered();
                }
            } while (notAWinner);

            final String gameMessages = canvasAsStream.toString(StandardCharsets.UTF_8);
            messagesByGame.put(gameId, gameMessages);
        }
        return messagesByGame;
    }
}
