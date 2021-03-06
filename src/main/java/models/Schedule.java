package models;

import java.util.*;

public class Schedule {

    private List<TimeFrame> timeFrameList;
    private Map<String, TimeFrame> timeFrameMap;

    /**
     *
     * @param schedule Schedule string provided by management. It should have the form DDXX:YY-XX:YY,XX:YY,...
     *                 Where DD are two letters that represents the day.
     *                 XX are  two numbers that represent an hour.
     *                 YY are two numbers that represent the minutes.
     */
    public Schedule(String schedule) {
        this.timeFrameList = generateSchedule(schedule);
        this.timeFrameMap = generateScheduleMap(this.timeFrameList);
    }

    /**
     *
     * This method selects the schedule with the lowest number of days to compare with the other.
     *
     * @param schedule Schedule object
     * @return the coincidence number between the two schedules
     */
    public Integer compareSchedules(Schedule schedule) {
        if (this.timeFrameMap.size() < schedule.timeFrameMap.size()) {
            return calculateCoincidences(this, schedule);
        }
        return calculateCoincidences(schedule, this);
    }

    /**
     *
     * A method that calculates the coincidences between two schedules.
     *
     * @param A Schedule object
     * @param B Schedule object
     * @return the number of coincidences between the two schedules
     */
    private Integer calculateCoincidences(Schedule A, Schedule B) {
        int coincidences = 0;
        for (TimeFrame tf : A.timeFrameList) {
            String day = tf.getDay();
            if (B.timeFrameMap.containsKey(day) &&
                    B.timeFrameMap.get(day).isInRange(tf)) {
                coincidences++;
            }
        }
        return coincidences;
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
        Schedule schedule = (Schedule) o;
        return Objects.equals(timeFrameList, schedule.timeFrameList) && Objects.equals(timeFrameMap, schedule.timeFrameMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeFrameList, timeFrameMap);
    }

    /**
     *
     * @param schedule Schedule string provided by management. It should have the form DDXX:YY-XX:YY,XX:YY,...
     *                 Where DD are two letters that represents the day.
     *                 XX are  two numbers that represent an hour.
     *                 YY are two numbers that represent the minutes.
     * @return A list of timeframe objects that represent the schedule
     */
    private List<TimeFrame> generateSchedule(String schedule) {
        ArrayList<TimeFrame> timeFrameList = new ArrayList<>();
        for (String part : parseSchedule(schedule)) {
            timeFrameList.add(new TimeFrame(part));
        }
        return timeFrameList;
    }

    /**
     *
     * @param timeFrames timeframe list of objects that represent the schedule.
     * @return A map where the keys represent the day of the week and the value is a timeframe object
     */
    private Map<String, TimeFrame> generateScheduleMap(List<TimeFrame> timeFrames) {
        HashMap<String, TimeFrame> scheduleMap = new HashMap<>();
        for (TimeFrame tf : timeFrames) {
            scheduleMap.put(tf.getDay(), tf);
        }
        return scheduleMap;
    }

    /**
     * This method parse and cleans the input of the schedule string provided by management. It ensures that there are no spaces.
     * @param schedule Schedule string provided by management. It should have the form DDXX:YY-XX:YY,XX:YY,...
     *                 Where DD are two letters that represents the day.
     *                 XX are  two numbers that represent an hour.
     *                 YY are two numbers that represent the minutes.
     * @return An array in which each value represents a day with the time range.
     */
    private String[] parseSchedule(String schedule) {
        return schedule.replaceAll(" ", "").split(",");
    }
}
