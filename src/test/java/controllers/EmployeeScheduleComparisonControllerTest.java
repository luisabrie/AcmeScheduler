package controllers;

import models.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class EmployeeScheduleComparisonControllerTest {
    @Test
    public void runComparisonSingle() {
        List<Employee> ale = new ArrayList<>();
        ale.add(new Employee("RENE", "MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU20:00-21:00"));
        Map<String, Integer> providedMap = new TreeMap<>();
        EmployeeScheduleComparisonController escc = new EmployeeScheduleComparisonController(ale);
        Map<String, Integer> treeMap = escc.runComparison();
        assertEquals(providedMap.size(), treeMap.size());
    }

    @Test
    public void runComparisonMoreThanOne() {
        List<Employee> ale = new ArrayList<>();
        ale.add(new Employee("RENE", "MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU20:00-21:00"));
        ale.add(new Employee("ASTRID", "MO10:00-12:00,TH12:00-14:00,SU20:00-21:00"));
        Map<String, Integer> providedMap = new TreeMap<>();
        providedMap.put("RENE-ASTRID", 3);
        EmployeeScheduleComparisonController escc = new EmployeeScheduleComparisonController(ale);
        Map<String, Integer> treeMap = escc.runComparison();
        providedMap.keySet().stream().forEach((key) -> {
            assertEquals("Value mismatch for key '" + key + "';", providedMap.get(key), treeMap.get(key));
        });
    }
}