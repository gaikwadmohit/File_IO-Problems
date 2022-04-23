package com.Bridgelabz.Day27;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee_Payroll_Service {

	  public enum IOService {
	        CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	    }

	    public static final Scanner SC = new Scanner(System.in);
	    private List<Employee_Payroll_Data> employeeList;

	    public Employee_Payroll_Service() {
	        this.employeeList = new ArrayList<Employee_Payroll_Data>();
	    }

	    public Employee_Payroll_Service(List<Employee_Payroll_Data> employeeList) {
	        this.employeeList = employeeList;
	    }

	    public void readEmployeeData() {
	        System.out.println("Enter employee id:");
	        int employeeId = SC.nextInt();
	        System.out.println("Enter employee name:");
	        SC.nextLine();
	        String employeeName = SC.nextLine();
	        System.out.println("Enter employee salary:");
	        double employeeSalary = SC.nextDouble();
	        Employee_Payroll_Data newEmployee = new Employee_Payroll_Data(employeeId, employeeName, employeeSalary);
	        employeeList.add(newEmployee);
	    }

	    public void writeEmployeeDdate(IOService ioType) {
	        if (ioType.equals(IOService.CONSOLE_IO)) {
	            for (Employee_Payroll_Data o : employeeList)
	                System.out.println(o.toString());
	        } else if (ioType.equals(IOService.FILE_IO)) {
	            new Employee_PayrollFile_IO_Service().writeData(employeeList);
	        }
	    }

	    public long countEnteries(IOService ioType) {
	        if (ioType.equals(IOService.FILE_IO))
	            return new Employee_PayrollFile_IO_Service().countEntries();
	        return 0;
	    }

	    public void printEmployeePayrollData() {
	        new Employee_PayrollFile_IO_Service().printEmployeePayrolls();
	    }
	}