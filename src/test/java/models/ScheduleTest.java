package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScheduleTest {
    @Test
    public void compareSameRangeSizeALowerSizeB() {
        Schedule A = new Schedule("MO10:00-12:00,TH12:00-14:00,SU20:00-21:00");
        Schedule B = new Schedule("MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00- 21:00");
        assertEquals(2, A.compareSchedules(B).intValue());
    }

    @Test
    public void compareSameRangeSizeBLowerSizeA() {
        Schedule A = new Schedule("MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00- 21:00");
        Schedule B = new Schedule("MO10:00-12:00,TH12:00-14:00,SU20:00-21:00");
        assertEquals(2, A.compareSchedules(B).intValue());
    }

    @Test
    public void compareDifferentRangeButStill() {
        Schedule A = new Schedule("MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU20:00-21:00");
        Schedule B = new Schedule("MO10:00-12:00,TH12:00-14:00,SU20:00-21:00");
        assertEquals(3, A.compareSchedules(B).intValue());
    }

    @Test
    public void compareDifferentRangeNoMatch() {
        Schedule A = new Schedule("MO10:15-12:00,TU10:00-12:00");
        Schedule B = new Schedule("WE12:00-14:00,SU20:00-21:00");
        assertEquals(0, A.compareSchedules(B).intValue());
    }

}