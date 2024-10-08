package org.fezacodes.employeemanagement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//1. Employee Management System
//Concepts: Interfaces, abstract classes, inheritance, file operations.
//Description:
//Create an Employee abstract class with common attributes like id, name, salary, and methods like calculateSalary().
//Define multiple subclasses (e.g., FullTimeEmployee, PartTimeEmployee) that inherit from Employee and implement the calculateSalary() method differently.
//Implement an interface like FileOperations with methods for reading and writing employee data to a file.
//Store employee data (such as name, salary, and type) in a file and implement methods to read and write this data to a CSV file.

// FQL --> this.getClass() --> org.fezacodes.employeemanagement.FullTimeEmployee
// getSimpleName() --> FullTimeEmployee -->
public abstract class Employee {
    private int id;
    private String name;
    private double salary;
    public Employee (int id, String name){
        this.id = id;
        this.name = name;

    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public abstract void calculateSalary(double salary);

    public String getCSVFormat() {
        return id + "," + name + "," + salary + "," + this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return getCSVFormat();
    }

}
class FullTimeEmployee extends Employee{
    public FullTimeEmployee (int id, String name, double monthlySalary){
        super(id, name);
         calculateSalary(monthlySalary);
    }

    @Override
    public void calculateSalary(double salray) {
        setSalary(salray);
    }
}
class PartTimeEmployee extends Employee{
    private int workHours;
    private double salaryPerHour;

    public PartTimeEmployee (int id, String name, double monthlySalary){
        super(id, name);
        setSalary(monthlySalary);
    }

    public PartTimeEmployee ( int id, String name, int workHours, double salaryPerHour){
        super(id, name);
        this.workHours = workHours;
        this.salaryPerHour = salaryPerHour;
        setSalary(this.workHours * this.salaryPerHour);
    }

    @Override
    public void calculateSalary(double salary) {
       setSalary(salary);
    }
}

