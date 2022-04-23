package com.Bridgelabz.Day27_Test;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.Bridgelabz.Day27.Employee_Payroll_Data;
import com.Bridgelabz.Day27.Employee_Payroll_Service;

import junit.framework.Assert;

public class EmployeePayrollServiceTest {
    @Test
    public void given3EmployeeWhenWrittenToFileShouldMatchEmployeeEntries() {
    	Employee_Payroll_Data[] arrayOfEmps = {
                new Employee_Payroll_Data(1, "Shreesha", 100000),
                new Employee_Payroll_Data(2, "Kirti", 200000),
                new Employee_Payroll_Data(4, "Yavi", 400000),
                new Employee_Payroll_Data(3, "Diya", 300000),
        };

        Employee_Payroll_Service employeePayrollService;
        employeePayrollService  = new Employee_Payroll_Service(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayrollData(FILE_IO);
        employeePayrollService.printData(FILE_IO);
        long entries = employeePayrollService.countEntries(FILE_IO);
        Assert.assertEquals(3, entries);
    }

    @Test
    public void givenFileOnReadingFromFileShouldMatchEmployeeCount() {
        Employee_Payroll_Service employeePayrollService = new Employee_Payroll_Service();
        long entries = employeePayrollService.readEmployeePayrollData(FILE_IO);
        Assert.assertEquals(3, entries);
    }
}