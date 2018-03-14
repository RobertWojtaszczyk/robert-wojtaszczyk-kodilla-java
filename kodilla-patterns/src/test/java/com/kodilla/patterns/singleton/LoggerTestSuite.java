package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void testGetLastLog1() {
        //Given
        //When
        Logger.getInstance().log("Opening application");
        //Then
        Assert.assertEquals("Opening application", Logger.getInstance().getLastLog());
    }
}
