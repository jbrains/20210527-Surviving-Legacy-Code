package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;

public class RollDieTest {
    private static class TestableGame extends Game {
        @Override
        protected void reportMessage(final String message) {
            // Intentionally do nothing!
        }
    }

    @Test
    public void happyPath() throws Exception {
        final TestableGame game = new TestableGame();
        game.add("::irrelevant player::");

        game.roll(4);
    }
}
