package com.adaptionsoft.games.uglytrivia;

import org.junit.Assert;
import org.junit.Test;

public class RollDieTest {
    private static class TestableGame extends Game {
        @Override
        protected void reportMessage(final String message) {
            // Intentionally do nothing!
        }

        @Override
        protected void askQuestion() {
            // Don't worry about this yet.
            // Set an expectation on this side-effect in another test.
        }
    }

    @Test
    public void happyPath() throws Exception {
        final TestableGame game = new TestableGame();
        game.add("::irrelevant player::");

        game.roll(4);

        Assert.assertEquals(4, game.places[0]);
    }
}
