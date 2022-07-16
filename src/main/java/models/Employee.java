package models;

import java.util.Objects;

public class Employee {

    private String name;
    private Schedule schedule;

    /**
     *
     * @param name Employee name
     * @param schedule Employee Schedule
     */
    public Employee(String name, String schedule) {
        this.name = name;
        this.schedule = new Schedule(schedule);
    }

    /**
     *
     * @return Returns the employee name.
     */
    public String getName() {
        return name;
    }

    /**
     * Default equals method generated by the IDE.
     * @param o
     * @return A boolean expression on the equality between the objects
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(schedule, employee.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, schedule);
    }

    /**
     *
     * @return Employee Schedule
     */
    public Schedule getSchedule() {
        return schedule;
    }


}