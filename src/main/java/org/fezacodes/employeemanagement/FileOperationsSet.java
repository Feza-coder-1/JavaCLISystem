package org.fezacodes.employeemanagement;
import java.util.Set;

public interface FileOperationsSet {
    public Set<Employee> readEmployeesFromFile(String filename);
    public void writeEmployeesToFile(String filename, Set<Employee> employees);

}
