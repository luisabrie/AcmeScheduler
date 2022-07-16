package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void getName() {
        Employee e = new Employee("JUAN", "MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU00:00-11:00");
        assertEquals("JUAN", e.getName());
    }

    @Test
    public void testEqualsOne() {
        Employee e = new Employee("JUAN", "MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU00:00-11:00");
        assertEquals(e, e);
    }

    @Test
    public void testEqualsTwo() {
        Employee e = new Employee("JUAN", "MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU00:00-11:00");
        assertFalse(e.equals(null));
    }

    @Test
    public void testEqualsThree() {
        Employee e = new Employee("JUAN", "MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU00:00-11:00");
        assertFalse(e.equals(new Object()));
    }

    @Test
    public void testEqualsFour() {
        Employee e = new Employee("JUAN", "MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU00:00-11:00");
        Employee e2 = new Employee("JUAN", "MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU00:00-11:00");
        assertTrue(e.equals(e2));
    }

    @Test
    public void testEqualsFive() {
        Employee e = new Employee("JUAN", "MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU00:00-11:00");
        Employee e2 = new Employee("CARLOS", "MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU00:00-11:00");
        assertFalse(e.equals(e2));
    }

    @Test
    public void testEqualsSix() {
        Employee e = new Employee("JUAN", "MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU00:00-11:00");
        Employee e2 = new Employee("JUAN", "MO11:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU00:00-11:00");
        assertFalse(e.equals(e2));
    }


    @Test
    public void getSchedule() {
        Employee e = new Employee("JUAN", "MO10:00-12:00,TH12:00-14:00,SU20:00-21:00");
        Schedule schedule = new Schedule("MO10:00-12:00,TH12:00-14:00,SU20:00-21:00");
        assertEquals(schedule, e.getSchedule());
    }
}