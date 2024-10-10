package org.fezacodes.employeemanagement;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class FileOperationsImpBufferedInterfaceSet implements FileOperationsSet{

    @Override
    public Set<Employee> readEmployeesFromFile(String filename) {

        Set<Employee> employeeList = new HashSet<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = null;
            while((line = reader.readLine()) != null ) {
                // line: 1,prince,200,fulltime
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                double salary = Double.parseDouble(fields[2]);
                String type = fields[3];

                Employee employee = null;

                if(type.equals("FullTimeEmployee")) {
                    employee = new FullTimeEmployee(id, name, salary);
                } else if( type.equals("PartTimeEmployee")) {
                    employee = new PartTimeEmployee(id, name, salary);
                }
                employeeList.add(employee);

            }

            return employeeList;

        }catch (IOException e) {
            System.out.println("Read error occurred." + e.getMessage());
        }

        return  employeeList;
    }

    @Override
    public void writeEmployeesToFile(String filename, Set<Employee> employees) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for( Employee employee : employees ) {
                writer.write(employee.getCSVFormat());
                writer.newLine();
            }
            System.out.println("File saved successfully.");
        } catch (IOException e) {
            System.out.println("Error wring to file " + e.getMessage());
        }


    }

}
