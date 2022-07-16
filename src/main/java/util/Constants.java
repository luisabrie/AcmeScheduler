package util;

public final class Constants
{
    private Constants() {} // to restrict instantiation
    public static final String NOTKNOWNEMPLOYEEEXPRESSION = "The following line is not a known employee expression: %s";
    public static final String EMPLOYEESCHEDULESTRINGREGEX = "^[a-zA-Z]+=((MO|TU|WE|TH|FR|SA|SU) *(0\\d|1\\d|2[0-3]) *: *[0-5]\\d *- *(0\\d|1\\d|2[0-3]) *: *[0-5]\\d,)*(MO|TU|WE|TH|FR|SA|SU) *(0\\d|1\\d|2[0-3]) *: *[0-5]\\d *- *(0\\d|1\\d|2[0-3]) *: *[0-5]\\d$";

    public static final String FILENOTFOUND = "The file %s was not found";
    public static final String FILEERROR = "An error occurred while reading the file.";

    public static final String TIMERANGEEXCEPTIONERRORMSG = "Mismatch start and end times";

    public static final String CONSOLEFILENAMEPROMPT = "Enter the filename where the employee schedules reside (The file should be in the same directory as the app):";
}

