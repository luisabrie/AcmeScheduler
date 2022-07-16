package controllers;

import models.Employee;
import util.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.Constants.*;

public class ReadEmployeeFileController {
    private String fileName;
    private List<Employee> employeeList;

    /**
     *
     * @param fileName A filename that has the employee schedule strings provided
     */
    public ReadEmployeeFileController(String fileName) {
        this.fileName = fileName;
        this.employeeList = new ArrayList<>();
        this.readFile();
    }

    /**
     *
     * @return A list of Employee with their specified schedule.
     */
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    private void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.fileName));
            String line;
            while ((line = br.readLine()) != null) {
                if (isAValidEmployeeExpression(line)) {
                    Employee e = parseEmployee(line);
                    employeeList.add(e);
                } else {
                    System.err.println(String.format(NOTKNOWNEMPLOYEEEXPRESSION, line));
                }
                ;
            }
        } catch (FileNotFoundException e) {
            System.err.println(String.format(FILENOTFOUND,this.fileName));
        } catch (IOException e) {
            System.err.println(FILEERROR);
            System.exit(-1);
            //e.printStackTrace();
        }
    }

    private boolean isAValidEmployeeExpression(String line) {
        final Pattern pattern = Pattern.compile(EMPLOYEESCHEDULESTRINGREGEX, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }

    private Employee parseEmployee(String employee) {
        String[] parts = employee.split("=");
        String name = parts[0];
        String schedule = parts[1];
        return new Employee(name, schedule);
    }
}
