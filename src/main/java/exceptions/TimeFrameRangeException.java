package exceptions;

import static util.Constants.TIMERANGEEXCEPTIONERRORMSG;

public class TimeFrameRangeException extends RuntimeException {
    public TimeFrameRangeException() {
        super(TIMERANGEEXCEPTIONERRORMSG);
    }
}
