package health.com;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Main Menu ====");
            System.out.println("1. Run Login Feature Tests");
            System.out.println("2. Run Program Monitoring Tests");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> runFeature("cases/feature1.feature");
                case 2 -> runFeature("cases/feature2.feature");
                case 3 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void runFeature(String featurePath) {
        String[] cucumberOptions = new String[]{
                "--glue", "health.com.AcceptanceTest",
                "--plugin", "pretty",
                featurePath
        };
        io.cucumber.core.cli.Main.main(cucumberOptions); // تعديل استدعاء Main
    }
}
