package com.Bridgelabz.Day27;

public class Employee_Payroll_Data {

    public int employeeId;
    public String employeeName;
    public double salary;

    public Employee_Payroll_Data(int employeeId, String employeeName, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Id : " + employeeId + "\t" + "Name : " + employeeName + "\t" + "Salary : " + salary;
    }
}