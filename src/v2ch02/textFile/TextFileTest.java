package v2ch02.textFile;

import java.io.*;
import java.nio.file.Paths;
import java.time.*;
import java.util.*;

/**
 * @author Cay Horstmann
 * @version 1.14 2016-07-11
 */
public class TextFileTest {

    // public static final String PACKAGE_FILE_NAME = "src/" + TextFileTest.class.getPackage().getName().replace(".", "/") + "/";

    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 2001, 3, 15);

        // save all employee records to the file employee.dat
        // final String fileName = PACKAGE_FILE_NAME + "employee.dat";
        final File file = Paths.get("src", "v2ch02", "textFile", "employee.dat").toFile();
        try (PrintWriter out = new PrintWriter(file, "UTF-8")) {
            writeData(staff, out);
        }

        // retrieve all records into a new array
        try (Scanner in = new Scanner(new FileInputStream(file), "UTF-8")) {
            Employee[] newStaff = readData(in);

            // print the newly read employee records
            for (Employee e : newStaff)
                System.out.println(e);
        }
    }

    /**
     * Writes all employees in an array to a print writer
     * @param employees an array of employees
     * @param out a print writer
     */
    private static void writeData(Employee[] employees, PrintWriter out) throws IOException {
        // write number of employees
        out.println(employees.length);

        for (Employee e : employees)
            writeEmployee(out, e);
    }

    /**
     * Reads an array of employees from a scanner
     * @param in the scanner
     * @return the array of employees
     */
    private static Employee[] readData(Scanner in) {
        // retrieve the array size
        int n = in.nextInt();
        in.nextLine(); // consume newline

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    /**
     * Writes employee data to a print writer
     * @param out the print writer
     */
    public static void writeEmployee(PrintWriter out, Employee e) {
        out.println(e.getName() + "|" + e.getSalary() + "|" + e.getHireDay());
    }

    /**
     * Reads employee data from a buffered reader
     * @param in the scanner
     */
    public static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        LocalDate hireDate = LocalDate.parse(tokens[2]);
        int year = hireDate.getYear();
        int month = hireDate.getMonthValue();
        int day = hireDate.getDayOfMonth();
        return new Employee(name, salary, year, month, day);
    }
}
