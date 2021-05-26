package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import com.adaptionsoft.games.uglytrivia.Game;
import org.approvaltests.Approvals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
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
    public void oneGame() throws Exception {
        final ByteArrayOutputStream canvasAsStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvasAsStream));

        Game aGame = new Game();

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");

        Random rand = new Random(762);

        do {
            aGame.roll(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }
        } while (notAWinner);

        Approvals.verify(canvasAsStream.toString(StandardCharsets.UTF_8));
    }
}
