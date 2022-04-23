package com.Bridgelabz.Day27;


	import java.io.File;
	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Employee_PayrollFile_IO_Service {
    public static final String PAYROLL_FILE_NAME = "employee-payroll-file.txt";

    public void writeData(List<Employee_Payroll_Data> employeeList) {

        StringBuffer employeeBufferString = new StringBuffer();
        employeeList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            employeeBufferString.append(employeeDataString);
        });

        try {
            Files.write(Paths.get(PAYROLL_FILE_NAME), employeeBufferString.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long countEntries() {
        long Entries = 0;
        try {
            Entries = Files.lines(Paths.get(PAYROLL_FILE_NAME)).count();
        } catch (IOException e) {
        }
        return Entries;
    }

    public void printData() {
        try {
            Files.lines(Paths.get(PAYROLL_FILE_NAME)).forEach(System.out::println);
        } catch (IOException e) {
        }
    }

    public List<Employee_Payroll_Data> readData() {
        List<Employee_Payroll_Data> employeeReadList = new ArrayList<Employee_Payroll_Data>();
        String lin = null;
        try {
            Files.lines(Paths.get(PAYROLL_FILE_NAME)).map(line -> line.trim()).forEach(line -> {
                String[] data = line.split("[a-zA-Z]+ : ");
                int id = Character.getNumericValue(data[1].charAt(0));
                String name = data[2];
                double salary = Double.parseDouble(data[3]);
                Employee_Payroll_Data employeeobject = new Employee_Payroll_Data(id, name, salary);
                employeeReadList.add(employeeobject);
            });
        } catch (IOException e) {
        }
        return employeeReadList;
    }
}