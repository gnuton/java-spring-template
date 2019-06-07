package org.gnuton.test.web;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeartbeatControllerTest {
    @Test
    public void check_heartbeat_return_true() throws Exception {
        assertEquals(new HeartbeatController().getHearthbeat(), true);
    }
}