package controllers;

import models.Employee;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeScheduleComparisonController {

    private List<Employee> employeeList;

    public EmployeeScheduleComparisonController(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    /**
     *
     * @return A map in which the key is the Employee pair and the value is an integer that represents how many times
     * in a week both employees schedule matched.
     */
    public Map<String, Integer> runComparison() {
        TreeMap<String, Integer> map = new TreeMap<>();
        if (this.employeeList.size() >= 2) {
            for (int i = 0; i < this.employeeList.size(); i++) {
                Employee e1 = this.employeeList.get(i);
                for (int j = i + 1; j < this.employeeList.size(); j++) {
                    Employee e2 = this.employeeList.get(j);
                    map.put(e1.getName() + "-" + e2.getName(), e1.getSchedule().compareSchedules(e2.getSchedule()));
                }
            }
        }
        return map;
    }

}
