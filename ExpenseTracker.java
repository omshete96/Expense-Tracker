import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nExpense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expenses");
            System.out.println("4. Remove Expense");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    viewTotalExpenses();
                    break;
                case 4:
                    removeExpense();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addExpense() {
        System.out.print("Enter expense description: ");
        String description = scanner.nextLine();
        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        expenses.add(new Expense(description, amount));
        System.out.println("Expense added successfully.");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("Expenses:");
            for (int i = 0; i < expenses.size(); i++) {
                System.out.println((i + 1) + ". " + expenses.get(i));
            }
        }
    }

    private static void viewTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        System.out.println("Total Expenses: $" + total);
    }

    private static void removeExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to remove.");
            return;
        }
        viewExpenses();  // Show current expenses with index
        System.out.print("Enter the index of the expense to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (index > 0 && index <= expenses.size()) {
            expenses.remove(index - 1);  // Remove the expense at the given index
            System.out.println("Expense removed successfully.");
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }
}

class Expense {
    private final String description;
    private final double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Description: " + description + ", Amount: $" + amount;
    }
}
