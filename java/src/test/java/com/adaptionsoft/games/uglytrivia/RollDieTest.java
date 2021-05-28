package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;

public class RollDieTest {
    private static class TestableGame extends Game {}

    @Test
    public void happyPath() throws Exception {
        final TestableGame game = new TestableGame();
        game.add("::irrelevant player::");

        game.roll(4);
    }
}
