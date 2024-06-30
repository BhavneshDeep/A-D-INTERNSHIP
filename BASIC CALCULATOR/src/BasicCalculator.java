import java.util.Scanner;

public class BasicCalculator {

    // Define functions for each arithmetic operation
    public static double addition(double a, double b) {
        return a + b;
    }

    public static double subtraction(double a, double b) {
        return a - b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static String division(double a, double b) {
        if (b == 0) {
            return "Division by zero is not allowed.";
        }
        return String.valueOf(a / b);
    }

    // Main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            System.out.print("Enter choice (1/2/3/4/5): ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting the program.");
                break;
            }

            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            switch (choice) {
                case 1:
                    System.out.println("The result is: " + addition(num1, num2));
                    break;
                case 2:
                    System.out.println("The result is: " + subtraction(num1, num2));
                    break;
                case 3:
                    System.out.println("The result is: " + multiplication(num1, num2));
                    break;
                case 4:
                    System.out.println("The result is: " + division(num1, num2));
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    break;
            }
        }

        scanner.close();
    }
}