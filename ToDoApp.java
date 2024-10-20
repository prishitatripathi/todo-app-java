import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {

    // List to store tasks
    private static ArrayList<String> tasks = new ArrayList<>();
    // Scanner object for input
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    viewTasks();
                    break;
                case "3":
                    removeTask();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Prints the menu options
    private static void printMenu() {
        System.out.println("\nTo-Do List Application");
        System.out.println("1. Add a task");
        System.out.println("2. View tasks");
        System.out.println("3. Remove a task");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Adds a new task to the to-do list
    private static void addTask() {
        System.out.print("Enter the task description: ");
        String description = scanner.nextLine();
        tasks.add(description);
        System.out.println("Task added successfully.");
    }

    // Displays the list of tasks
    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nYour Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Removes a task based on the task number
    private static void removeTask() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter the task number to remove: ");
            int taskNumber = Integer.parseInt(scanner.nextLine());
            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                String removedTask = tasks.remove(taskNumber - 1);
                System.out.println("Task '" + removedTask + "' removed successfully.");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}