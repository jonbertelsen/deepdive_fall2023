package dat;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Predicate;

public class Exercise4
{
    public static void main(String[] args)
    {
        List<Employee> employees = populateEmployees();
        System.out.println(employees);
        showEmployeesAgeInYears(employees);
        System.out.println(avgAge(employees));
        showEmployeesBornInMonth(employees, 10);
        Map<Integer, List<Employee>> employeesByMonth = groupEmployeesByMonth(employees);
        System.out.println(employeesByMonth);
        System.out.println(employeesByMonthCount(employeesByMonth));
        System.out.println(employeesInCurrentMonth(employees));
    }

    private static String employeesInCurrentMonth(List<Employee> employees)
    {
        LocalDate now = LocalDate.now();
        StringBuilder sb = new StringBuilder("Born in month: " + now.getMonthValue() + "\n");
        for (Employee e: employees)
        {
            if (e.getBirthDate().getMonthValue() == now.getMonthValue())
            {
                sb.append(e.getName() + "\n");
            }
        }
        return sb.toString();
    }

    private static String employeesByMonthCount(Map<Integer, List<Employee>> employeesByMonth)
    {
        StringBuilder sb = new StringBuilder();
        for (int i: employeesByMonth.keySet())
        {
            sb.append("Month: " + i + ": " + employeesByMonth.get(i).size() + " person(s)\n");
        }
        return  sb.toString();
    }

    private static Map<Integer, List<Employee>> groupEmployeesByMonth(List<Employee> employees)
    {
        Map<Integer, List<Employee>> grouping = new HashMap<>();

        for (Employee e : employees)
        {
            if (grouping.get(e.getBirthDate().getMonthValue()) == null)
            {
                List<Employee> employeeList = new ArrayList<>();
                employeeList.add(e);
                grouping.put(e.getBirthDate().getMonthValue(), new ArrayList<>(Arrays.asList(e)));
            } else
            {
                grouping.get(e.getBirthDate().getMonthValue()).add(e);
            }
        }
        return grouping;
    }

    private static void showEmployeesBornInMonth(List<Employee> employees, int i)
    {
        // V1
        for (Employee e : employees)
        {
            if (e.getBirthDate().getMonthValue() == i)
            {
                System.out.println(e.getName());
            }
        }

        // V2
        Predicate<Employee> bornInMonth = e -> e.getBirthDate().getMonthValue() == i;

        for (Employee e : employees)
                {
                    if (bornInMonth.test(e))
                    {
                        System.out.println(e.getName());
                    }
                }

        // V3 (brug af streams)
        employees.stream()
                .filter(bornInMonth)
                .forEach(e -> System.out.println(e.getName()));

    }

    private static List<Employee> populateEmployees()
    {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 37, LocalDate.of(1985, 10, 10)));
        employees.add(new Employee("Jane", 28, LocalDate.of(1995, 5, 5)));
        employees.add(new Employee("Jack", 48, LocalDate.of(1975, 1, 1)));
        employees.add(new Employee("Joe", 22, LocalDate.of(1999, 10, 12)));
        employees.add(new Employee("Jill", 32, LocalDate.of(1989, 9, 24)));
        employees.add(new Employee("Joan", 32, LocalDate.of(1989, 9, 25)));
        return employees;
    }

    private static int calculateAgeInYears(LocalDate birthDate)
    {
        LocalDate now = LocalDate.now();
        Period period = Period.between(birthDate, now);
        return period.getYears();
    }

    private static void showEmployeesAgeInYears(List<Employee> employees)
    {
        for (Employee e : employees)
        {
            System.out.println(e.getName() + ": " +
                    calculateAgeInYears(e.getBirthDate()));
        }
    }

    public static int avgAge(List<Employee> employees)
    {
        int sum = 0;
        for (Employee e : employees)
        {
            sum += calculateAgeInYears(e.getBirthDate());
        }
        return sum / employees.size();
    }
}
