import controllers.EmployeeScheduleComparisonController;
import controllers.ReadEmployeeFileController;
import models.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static util.Constants.CONSOLEFILENAMEPROMPT;

public class AcmeSchedulerApp {
    public static void main(String[] args) {

        System.out.print(CONSOLEFILENAMEPROMPT);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        try {
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ReadEmployeeFileController refc = new ReadEmployeeFileController(fileName);

        List<Employee> employeeList = refc.getEmployeeList();

        EmployeeScheduleComparisonController escc = new EmployeeScheduleComparisonController(employeeList);
        escc.runComparison().forEach((k, v) -> System.out.printf("%-20s %s%n",k, v));
    }
}