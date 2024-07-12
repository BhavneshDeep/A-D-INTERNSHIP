import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class ExpenseTracker {
    private static final String FILE_NAME = "expenses.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Expense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. Display Expenses");
            System.out.println("3. Display Total Expenses");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    displayExpenses();
                    break;
                case 3:
                    displayTotalExpenses();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addExpense(Scanner scanner) {
        try {
            System.out.print("Enter expense description: ");
            String description = scanner.nextLine();
            System.out.print("Enter expense amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            if (amount < 0) {
                System.out.println("Amount cannot be negative.");
                return;
            }

            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String expense = String.format("%s - %s: $%.2f%n", timestamp, description, amount);

            Files.write(Paths.get(FILE_NAME), expense.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            System.out.println("Expense added successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid amount.");
        }
    }

    private static void displayExpenses() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
            System.out.println("Expenses:");
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }

    private static void displayTotalExpenses() {
        try {
            double total = Files.lines(Paths.get(FILE_NAME))
                    .map(line -> line.split(": \\$")[1])
                    .mapToDouble(Double::parseDouble)
                    .sum();
            System.out.printf("Total Expenses: $%.2f%n", total);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        } catch (Exception e) {
            System.out.println("An error occurred while calculating the total expenses.");
        }
    }
}
