package org.fezacodes.employeemanagement;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        readWriteWitSet();

    }

    private static void readWriteWitSet() {
        Set<Employee> employeesDB = getEmployeesFromDisk("employees2.csv");
        System.out.println(employeesDB);
        firstApproachSet(employeesDB);
    }

    private static Set<Employee> getEmployeesFromDisk(String fiilName) {
        FileOperationsSet melissa = new FileOperationsImpBufferedInterfaceSet() {
        };
        return melissa.readEmployeesFromFile(fiilName);
    }

    private static void firstApproachSet(Set<Employee> employees) {
        Employee employee1 = new FullTimeEmployee(1, "Prince", 3500);
        Employee employee2 = new PartTimeEmployee(2, "Alpha", 40, 50.0);

        employees.add(employee1);
        employees.add(employee2);


        FileOperationsSet fileOperations = new FileOperationsImpBufferedInterfaceSet();

        // Write to the file
        String filename = "employees2.csv";
        fileOperations.writeEmployeesToFile(filename, employees);

        // Reading from the file
        Set<Employee> employeesFromFile = fileOperations.readEmployeesFromFile(filename);
        System.out.println(employeesFromFile);
    }

    private static void firstApproach(List<Employee> employees) {
        Employee employee1 = new FullTimeEmployee(1, "Prince", 3500);
        Employee employee2 = new PartTimeEmployee(2, "Alpha", 40, 50.0);

        employees.add(employee1);
        employees.add(employee2);
        FileOperations fileOperations = new FileOperationsImpBufferedInterface();

        // Write to the file
        String filename = "employees.csv";
        fileOperations.writeEmployeesToFile(filename, employees);

        // Reading from the file
        List<Employee> employeesFromFile = fileOperations.readEmployeesFromFile(filename);
        System.out.println(employeesFromFile);
    }
    private static void secondApproach(List<Employee> employees) {
        Employee employee1 = new FullTimeEmployee(3, "Feza", 3500);
        Employee employee2 = new PartTimeEmployee(4, "Temesghen", 40, 50.0);
        employees.add(employee1);
        employees.add(employee2);

        FileOperations fileOperations = new FileOperationMelissa();

        // Write to the file
        String filename = "employees.csv";
        fileOperations.writeEmployeesToFile(filename, employees);

        // Reading from the file
        List<Employee> employeesFromFile = fileOperations.readEmployeesFromFile(filename);
        System.out.println(employeesFromFile);
    }
}


