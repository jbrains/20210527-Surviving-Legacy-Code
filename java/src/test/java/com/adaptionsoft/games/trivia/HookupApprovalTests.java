package com.adaptionsoft.games.trivia;

import org.approvaltests.Approvals;
import org.junit.Test;

import java.util.Arrays;

public class HookupApprovalTests {
    @Test
    public void isThisThingOn() throws Exception {
        Approvals.verifyAll("testing", Arrays.asList(1, 2, 3, 4, 5));
    }
}
