package org.howard.edu.lsp.exam.problem51;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TestLogger {

    @Test
    @DisplayName("testDisplayLog")
    public void testDisplayLog() {
        Logger logger = Logger.getInstance();
        logger.logMessage("Test message");
        assertEquals("Log:\nTest message\n", logger.displayLog());
    }

    @Test
    @DisplayName("testLoggerInstances")
    public void testLoggerInstances() {
        Logger firstInstance = Logger.getInstance();
        Logger secondInstance = Logger.getInstance();
        assertSame(firstInstance, secondInstance);
    }
}
