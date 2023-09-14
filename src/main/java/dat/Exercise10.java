package dat;

import java.time.LocalDate;
import java.util.List;

public class Exercise10
{
    public static void main(String[] args)
    {
        TaskList<Task> tasks = new TaskList<>();

        populateTasks(tasks);

        // Print the tasks list
        System.out.println("Print the tasks list");
        tasks.print();

        // Filter tasks based on a keyword in the title or description
        System.out.println("Filter tasks based on a keyword in the title or description");
        List<Task> filteredTasks = tasks.filter("Buy");
        filteredTasks.forEach(System.out::println);

        // Sort tasks by due date
        System.out.println("Sort tasks by due date");
        List<Task> sortedTasks = tasks.sortByDueDate();
        sortedTasks.forEach(System.out::println);

        // Get tasks that are due today
        System.out.println("Get tasks that are due today");
        List<Task> dueTodayTasks = tasks.getDueToday();
        dueTodayTasks.forEach(System.out::println);

        // Get tasks that are overdue
        System.out.println("Get tasks that are overdue");
        List<Task> overdueTasks = tasks.getOverdue();
        overdueTasks.forEach(System.out::println);

    }

    // Populate the tasks list with 5 tasks all with dueDate 2023 in a method
    public static void populateTasks(TaskList<Task> tasks)
    {
        tasks.addTask(new Task("Clean the kitchen", "Clean the kitchen now", LocalDate.of(2023, 10, 5)));
        tasks.addTask(new Task("Buy milk", "Goto to Irma", LocalDate.of(2023, 11, 5)));
        tasks.addTask(new Task("Buy bread", "Goto to Irma", LocalDate.of(2023, 12, 5)));
        tasks.addTask(new Task("Buy butter", "Goto to Irma", LocalDate.of(2023, 9, 5)));
        tasks.addTask(new Task("Buy cheese", "Goto to Irma", LocalDate.of(2023, 11, 5)));

        tasks.addTask(new GardenTask("Move the lawn", "With the new lawn mover", LocalDate.of(2023, 10, 5), "Backyard"));
        tasks.addTask(new GardenTask("Clear dead leaves", "With the new rake", LocalDate.of(2023, 11, 5), "Frontyard"));
        tasks.addTask(new GardenTask("Trim hedge", "With the new trimmer", LocalDate.of(2023, 12, 5), "Frontyard"));
        tasks.addTask(new GardenTask("Plant new roses", "With the new shovel", LocalDate.of(2023, 9, 5), "Backyard"));
        tasks.addTask(new GardenTask("Buy new lawn mower", "At the hardware store", LocalDate.of(2023, 11, 5), "Backyard"));
    }
}
