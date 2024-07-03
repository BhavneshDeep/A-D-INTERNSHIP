import java.util.Scanner;
class PersonalInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueInput = true;

        while (continueInput) {
            // Prompt user for their name
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            // Prompt user for their age
            int age = 0;
            while (true) {
                System.out.print("Enter your age: ");
                try {
                    age = Integer.parseInt(scanner.nextLine());
                    if (age > 0) {
                        break;
                    } else {
                        System.out.println("Age must be a positive integer. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
            }

            // Prompt user for their salary
            float salary = 0;
            while (true) {
                System.out.print("Enter your salary: ");
                try {
                    salary = Float.parseFloat(scanner.nextLine());
                    if (salary >= 0) {
                        break;
                    } else {
                        System.out.println("Salary cannot be negative. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            // Output the information
            System.out.println("Hello, " + name + ", you are " + age + " years old and your salary is $" + salary);

            // Ask user if they want to continue
            System.out.print("Do you want to enter another record? (yes/no): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                continueInput = false;
            }
        }

        scanner.close();
    }
}
