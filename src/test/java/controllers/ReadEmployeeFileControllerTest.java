package controllers;

import models.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReadEmployeeFileControllerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test()
    public void fileNotFound() {
        ReadEmployeeFileController refc = new ReadEmployeeFileController("testFileNotFound.bc");
        assertEquals("The file testFileNotFound.bc was not found.\n", errContent.toString());
    }

    @Test
    public void TestWrongExpression() {
        ReadEmployeeFileController refc = new ReadEmployeeFileController("wrongExpression.txt");
        assertEquals("The following line is not a known employee expression: CAMILA=MO7:00-12:00,TU08:00-13:00,WE09:00- 12:00,TH14:00-16:00,SU19:00-23:59\n", errContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setErr(originalErr);
        System.setOut(originalOut);
    }

    @Test
    public void goodController() {
        ReadEmployeeFileController refc = new ReadEmployeeFileController("testFile.txt");
        List<Employee> ale = new ArrayList<>();
        ale.add(new Employee("RENE", "MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU20:00-21:00"));
        ale.add(new Employee("ASTRID", "MO10:00-12:00,TH12:00-14:00,SU20:00-21:00"));
        assertEquals(refc.getEmployeeList(), ale);

    }
}