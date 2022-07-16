package models;

import exceptions.TimeFrameRangeException;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeFrameTest {
    @Test
    public void generateMinutesWithoutMin() {
        TimeFrame tf = new TimeFrame("MO10:00-12:00");
        assertEquals(600, tf.getStartMinute().intValue());
    }

    @Test
    public void generateMinutesWithMin() {
        TimeFrame tf = new TimeFrame("MO10:30-12:00");
        assertEquals(630, tf.getStartMinute().intValue());
    }

    @Test
    public void getRange() {
        TimeFrame tf = new TimeFrame("MO10:30-12:00");
        assertEquals(90, tf.getRange().intValue());
    }

    @Test(expected = TimeFrameRangeException.class)
    public void getRangeNoRg() {
        TimeFrame tf = new TimeFrame("WE10:30-10:29");
    }

    @Test
    public void isNotRangeARangeBeforeWholeBRange() {
        TimeFrame tf1 = new TimeFrame("MO01:30-03:30");
        TimeFrame tf2 = new TimeFrame("MO21:30-23:03");
        assertFalse(tf1.isInRange(tf2));
    }

    @Test
    public void isNotRangeBRangeBeforeWholeARange() {
        TimeFrame tf1 = new TimeFrame("MO21:30-23:03");
        TimeFrame tf2 = new TimeFrame("MO01:30-03:30");
        assertFalse(tf1.isInRange(tf2));
    }

    @Test
    public void isInBetweenBRange() {
        TimeFrame tf1 = new TimeFrame("MO10:00-15:00");
        TimeFrame tf2 = new TimeFrame("MO12:00-13:00");
        assertTrue(tf1.isInRange(tf2));
    }

    @Test
    public void isInBetweenARange() {
        TimeFrame tf1 = new TimeFrame("MO12:00-13:00");
        TimeFrame tf2 = new TimeFrame("MO10:00-15:00");
        assertTrue(tf1.isInRange(tf2));
    }

    @Test
    public void isSameRange() {
        TimeFrame tf1 = new TimeFrame("MO00:00-23:59");
        TimeFrame tf2 = new TimeFrame("MO00:00-23:59");
        assertTrue(tf1.isInRange(tf2));
    }

    @Test
    public void isARangeEndBeforeBRangeEnd() {
        TimeFrame tf1 = new TimeFrame("MO06:00-12:00");
        TimeFrame tf2 = new TimeFrame("MO10:00-15:00");
        assertTrue(tf1.isInRange(tf2));
    }

    @Test
    public void isBRangeEndWhenARangeStart() {
        TimeFrame tf1 = new TimeFrame("MO10:00-15:00");
        TimeFrame tf2 = new TimeFrame("MO15:00-17:00");
        assertFalse(tf1.isInRange(tf2));
    }

    @Test
    public void isBRangeStartWhenARangeEnd() {
        TimeFrame tf1 = new TimeFrame("MO15:00-19:00");
        TimeFrame tf2 = new TimeFrame("MO10:00-15:00");
        assertFalse(tf1.isInRange(tf2));
    }

}