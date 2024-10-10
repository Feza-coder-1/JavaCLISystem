package org.fezacodes.employeemanagement;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        firstApproach();
        secondApproach();

    }

    private static void firstApproach() {
        Employee employee1 = new FullTimeEmployee(1, "Prince", 3500);
        Employee employee2 = new PartTimeEmployee(2, "Alpha", 40, 50.0);

        FileOperations fileOperations = new FileOperationsImpBufferedInterface();
        List<Employee> employeeList = Arrays.asList(employee1, employee2);
        // Write to the file
        String filename = "employees.csv";
        fileOperations.writeEmployeesToFile(filename, employeeList);

        // Reading from the file
        List<Employee> employees = fileOperations.readEmployeesFromFile(filename);
        System.out.println(employeeList);
    }
    private static void secondApproach() {
        Employee employee1 = new FullTimeEmployee(3, "Tekeste", 3500);
        Employee employee2 = new PartTimeEmployee(4, "Melissa", 40, 50.0);

        FileOperations fileOperations = new FileOperationMelissa();
        List<Employee> employeeList = Arrays.asList(employee1, employee2);
        // Write to the file
        String filename = "employees.csv";
        fileOperations.writeEmployeesToFile(filename, employeeList);

        // Reading from the file
        List<Employee> employees = fileOperations.readEmployeesFromFile(filename);
        System.out.println(employeeList);
    }
}


