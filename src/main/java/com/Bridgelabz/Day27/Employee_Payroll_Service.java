package com.Bridgelabz.Day27;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee_Payroll_Service<EmployeePayrollData> {
	Scanner SC = new Scanner(System.in);

    public enum IOService {CONSALE_IO, FILE_IO, DB_IO, REST_IO, ioType}

    private List<Employee_Payroll_Data> employeePayrollList;

    public Employee_Payroll_Service() {
        this.employeePayrollList = new employeePayrollList();
    }

    public Employee_Payroll_Service(List<Employee_Payroll_Data> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    public static void main(String[] args) {
        ArrayList<Employee_Payroll_Data> employeePayrollList = new ArrayList<>();
        Employee_Payroll_Service employeePayrollService = new Employee_Payroll_Service(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.ioType);
    }

    public void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee Id:");
        int employeeId = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name:");
        String employeeName = consoleInputReader.next();
        System.out.println("Enter Employee Salary:");
        double employeeSalary = consoleInputReader.nextDouble();
        employeePayrollList.add(new Employee_Payroll_Data(employeeId, employeeName, employeeSalary));
    }

    public void writeEmployeePayrollData(IOService ioType) {
        if (ioType.equals(IOService.CONSALE_IO)) {
            for (EmployeePayrollData o : employeePayrollList)
                System.out.println(o.toString());
        } else if (ioType.equals(IOService.FILE_IO)) {
            new Employee_PayrollFile_IO_Service().writeData(employeePayrollList);
        }
    }

    public long countEnteries(IOService ioType) {
        if (ioType.equals(IOService.FILE_IO))
            return new Employee_PayrollFile_IO_Service().countEntries();
        return 0;
    }
}