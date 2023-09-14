package dat;

import java.time.LocalDate;

public class Exercise8
{

    public static void main(String[] args) {
        DataStorage<String> memoryStorage = new MemoryStorage<>();
        memoryStorage.store("Hello, world!");
        String retrievedString = memoryStorage.retrieve();
        System.out.println(retrievedString);

        DataStorage<Employee> fileStorage = new FileStorage("file.txt");
        fileStorage.store(new Employee("John", 30, LocalDate.now()));
        Employee retrieved = fileStorage.retrieve();
        System.out.println(retrieved);

        // Create and demonstrate DatabaseStorage
        DatabaseStorage<Employee> databaseStorage = new DatabaseStorage<>(Employee.class);
        databaseStorage.store(new Employee("Johnny", 40, LocalDate.now()));
        Employee retrievedFromDatabase = databaseStorage.retrieve();
        System.out.println(retrievedFromDatabase);
    }

}
