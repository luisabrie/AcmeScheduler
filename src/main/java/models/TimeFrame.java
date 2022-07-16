package models;

import exceptions.TimeFrameRangeException;

import java.util.Objects;

public class TimeFrame {

    private String day;
    private Integer startMinute;
    private Integer range;

    /**
     *
     * @param dayString A string which has the form DDXX:YY-XX:YY where DD are two letters that represent a day,
     *                  XX are two letters that represent an hour, and YY are two leters that represent minutes.
     *                  The combination XX:YY represents time and the slash separates between the start time and
     *                  the end time. It should be noted that the end time should not be before the start time.
     */
    public TimeFrame(String dayString) {
        this.day = dayString.substring(0, 2);
        this.startMinute = generateMinutes(dayString.substring(2, 7));
        Integer endMinute = generateMinutes(dayString.substring(8));
        if (endMinute < startMinute)
            throw new TimeFrameRangeException();
        this.range = calculateRange(startMinute, endMinute);
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
        TimeFrame timeFrame = (TimeFrame) o;
        return Objects.equals(day, timeFrame.day) && Objects.equals(startMinute, timeFrame.startMinute) && Objects.equals(range, timeFrame.range);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, startMinute, range);
    }

    /**
     *
     * @return A string that represents the day of the week.
     */
    public String getDay() {
        return day;
    }

    /**
     *
     * @return The starting hour gets converted into minutes. For example: 10:30 --> 630
     */
    public Integer getStartMinute() {
        return startMinute;
    }

    /**
     *
     * @return The time range in minutes since the startMinute.
     */
    public Integer getRange() {
        return range;
    }

    /**
     *
     * @param tf Another TimeFrame object
     * @return A boolean value which turns true if one of the Timeframes is in range of the other.
     * If the starting time of one timeframe is when the other ends, it would be assumed that there were no
     * interactions between those employees.
     */
    public Boolean isInRange(TimeFrame tf) {
        if (this.getStartMinute().compareTo(tf.getStartMinute()) < 0) {
            return this.getTimeSpan() > tf.getStartMinute();
        }
        return tf.getTimeSpan() > this.getStartMinute();
    }

    private Integer getTimeSpan() {
        return this.getStartMinute() + this.getRange();
    }

    private Integer generateMinutes(String startHour) {
        return (
                Integer.parseInt(startHour.substring(0, 2)) * 60) +
                Integer.parseInt(startHour.substring(3)
                );
    }

    private Integer calculateRange(Integer startMinute, Integer endMinute) {
        return endMinute - startMinute;
    }
}
