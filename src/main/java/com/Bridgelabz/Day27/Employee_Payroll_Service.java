package com.Bridgelabz.Day27;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee_Payroll_Service {

    public enum IOService{
        CONSOLE_IO, FILE_IO,
    }

    private List<Employee_Payroll_Data> employeePayrollList;

    public Employee_Payroll_Service() {
        employeePayrollList = new ArrayList<>();
    }

    public static void main(String[] args) {
    	Employee_Payroll_Service service = new Employee_Payroll_Service();

        service.readEmployeePayrollData(IOService.CONSOLE_IO);
        service.writeEmployeePayrollData(IOService.CONSOLE_IO);
    }

    public void readEmployeePayrollData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO)) {
            Scanner consoleScn = new Scanner(System.in);
            System.out.println("Enter the Employee Id : ");
            int id = consoleScn.nextInt();

            System.out.println("Enter the Employee Name : ");
            String name = consoleScn.next();

            System.out.println("Enter the Employee Salary : ");
            double salary = consoleScn.nextDouble();
            consoleScn.close();
            employeePayrollList
                    .add(new Employee_Payroll_Data(id, name, salary));
        } else if(ioService.equals(IOService.FILE_IO)) {
        	Employee_PayrollFile_IO_Service fileService = new Employee_PayrollFile_IO_Service();
            fileService.readData();
        }
    }

    public void writeEmployeePayrollData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO)) {
            System.out.println("All Employee Payroll details : "
                    + employeePayrollList);
        } else if (ioService.equals(IOService.FILE_IO)) {
        	Employee_PayrollFile_IO_Service fileService = new Employee_PayrollFile_IO_Service();
            fileService.writeData(employeePayrollList);
        }

    }

    public long countEntries(IOService ioService) {
        long entries = 0;
        Employee_PayrollFile_IO_Service fileService = new Employee_PayrollFile_IO_Service();
        entries = fileService.countEntries();
        return entries;
    }

    public void printData(IOService ioService) {
        new Employee_PayrollFile_IO_Service().printData();
    }
}