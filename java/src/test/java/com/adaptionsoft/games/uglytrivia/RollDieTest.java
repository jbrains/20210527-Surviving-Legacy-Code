package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;

public class RollDieTest {
    @Test
    public void happyPath() throws Exception {
        final Game game = new Game();
        game.add("::irrelevant player::");

        game.roll(4);
    }
}
