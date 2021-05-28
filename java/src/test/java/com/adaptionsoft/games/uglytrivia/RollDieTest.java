package com.adaptionsoft.games.uglytrivia;

import org.junit.Assert;
import org.junit.Test;

public class RollDieTest {
    private static class TestableGame extends Game {
        public TestableGame(int startingPlace) {
            add("::irrelevant player::");
            places[0] = startingPlace;
        }

        @Override
        protected void reportMessage(final String message) {
            // Intentionally do nothing!
        }

        @Override
        protected void askQuestion() {
            // Don't worry about this yet.
            // Set an expectation on this side-effect in another test.
        }

        private int placeOfOnlyPlayer() {
            return places[0];
        }
    }

    @Test
    public void happyPath() throws Exception {
        final TestableGame game = new TestableGame(0);

        game.roll(4);

        Assert.assertEquals(4, game.placeOfOnlyPlayer());
    }

}
