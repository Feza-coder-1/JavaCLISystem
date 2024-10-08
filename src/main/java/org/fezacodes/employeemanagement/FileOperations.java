package org.fezacodes.employeemanagement;
import java.util.List;

public interface FileOperations {
    public List<Employee> readEmployeesFromFile(String filename);
    public void writeEmployeesToFile(String filename, List<Employee> employees);
}
