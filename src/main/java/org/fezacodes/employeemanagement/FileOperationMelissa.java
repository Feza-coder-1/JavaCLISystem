package org.fezacodes.employeemanagement;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.BufferedWriter;

public class FileOperationMelissa implements FileOperations {


    @Override
    public List<Employee> readEmployeesFromFile(String filename) {
        List<Employee> employeeList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                double salary = Double.parseDouble(fields[2]);
                String type = fields[3];

                Employee employee = null;

                if (type.equals("FullTimeEmployee")) {
                    employee = new FullTimeEmployee(id, name, salary);
                } else if (type.equals("PartTimeEmployee")) {
                    employee = new PartTimeEmployee(id, name, salary);
                }
                employeeList.add(employee);
            }

        } catch (IOException e) {
            System.out.println("Ooops");
        }
        return employeeList;
    }
    @Override
    public void writeEmployeesToFile(String filename, List<Employee> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for (Employee e : employees){
                writer.write(e.getCSVFormat());
                writer.newLine();
            }

        } catch (IOException e){
            System.out.println("Error Occured");
        }
    }
}
