package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeFrameInitTest {
    TimeFrame tf;

    @Before
    public void setUp() throws Exception {
        this.tf = new TimeFrame("MO10:00-12:00");
    }

    @Test
    public void timeFrameInitDay() {
        assertEquals("MO", tf.getDay());
    }

    @Test
    public void timeFrameInitStartMinute() {
        assertEquals(600, tf.getStartMinute().intValue());
    }

    @Test
    public void timeFrameInitRange() {
        assertEquals(120, tf.getRange().intValue());
    }
}