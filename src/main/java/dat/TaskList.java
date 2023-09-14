package dat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskList<T extends Task>
{
    private List<T> tasks;

    public TaskList()
    {
        this.tasks = new ArrayList<>();
    }

    // Add tasks to the list
    public void addTask(T task) {
        tasks.add(task);
    }

    // Get the list of tasks
    public List<T> getTasks() {
        return tasks;
    }


    // Filter tasks based on a keyword in the title or description as streams
    public List<T> filter(String keyword) {
        return tasks.stream()
                .filter(task -> task.getTitle().contains(keyword) || task.getDescription().contains(keyword))
                .toList();
    }

    // Sort tasks by due date as streams
    public List<T> sortByDueDate() {
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .toList();
    }

    // Get tasks that are due today as streams
    public List<T> getDueToday() {
        return tasks.stream()
                .filter(task -> task.getDueDate().isEqual(LocalDate.now()))
                .toList();
    }

    // Get tasks that are overdue as streams
    public List<T> getOverdue() {
        return tasks.stream()
                .filter(task -> task.getDueDate().isBefore(LocalDate.now()))
                .toList();
    }

    //  Print the list of tasks as streams
    public void print() {
        tasks.stream()
                .forEach(System.out::println);
    }

}
