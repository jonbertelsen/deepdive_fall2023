package dat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Exercise3
{
    private boolean mod3(Integer x)
    {
        return (x % 3 == 0);
    }

    public static void main(String[] args)
    {
        Exercise3 ex3 = new Exercise3();

        // Predicate example
        Predicate<Integer> mod3 = ex3::mod3;



        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> mod3List = new ArrayList<>();

        for (Integer i : intList)
        {
            if (mod3.test(i))
            {
                mod3List.add(i);
            }
        }

        System.out.println(mod3List);

        // Supplier example: no input, returns an object

        Supplier<Employee> employeeSupplier = () -> {
            List<String> names = Arrays.asList("John", "Jane", "Jack", "Joe", "Jill");
            String name = names.get((int) (Math.random() * names.size()));
            int age = (int) (Math.random() * 100);
            return new Employee(name, age);
        };

        System.out.println(employeeSupplier.get());

        // Consumer example: takes a List of objects, returns nothing

        Consumer<List<Employee>> printEmployees = (employees) -> {
            for (Employee e : employees)
            {
                System.out.println(e);
            }
        };

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            employees.add(employeeSupplier.get());
        }
        printEmployees.accept(employees);

        // Function example: convert list of employees to list of names

        Function<List<Employee>, List<String>> getNames = (emplist) -> {
            List<String> names = new ArrayList<>();
            for (Employee e : emplist)
            {
                names.add(e.getName());
            }
            return names;
        };

        List<String> result =  getNames.apply(employees);
        System.out.println(result);

        // Check if employee is older than 18

        Predicate<Employee> isOlderThan18 = (e) -> e.getAge() > 18;
        for (Employee e: employees)
{
            System.out.println(e + " is older than 18: " + isOlderThan18.test(e));
        }

        // Write employees to file
        Consumer<List<Employee>> writeEmployees = (emplist) -> {
            saveEmployeesToFile(emplist, "employees.txt");
        };
        writeEmployees.accept(employees);
    }

    public static void saveEmployeesToFile(List<Employee> employees, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Employee employee : employees) {
                writer.write(employee.getName() + "," + employee.getAge());
                writer.newLine(); // Add a newline to separate entries
            }
            System.out.println("Employees saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
