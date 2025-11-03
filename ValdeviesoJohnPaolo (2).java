/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package valdeviesojohnpaolo;
import java.util.Scanner;
/**
 *
 * @author BED
 */
public class ValdeviesoJohnPaolo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] users = new String[100][2]; // Assuming a maximum of 100 users
        int userCount = 0;

        while (true) {
            System.out.println("==== LOGIN SYSTEM ====");
            System.out.println("[1] Login");
            System.out.println("[2] Register");
            System.out.println("[3] Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    // Login
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    boolean loggedIn = false;
                    for (int i = 0; i < userCount; i++) {
                        if (users[i][0].equals(username) && users[i][1].equals(password)) {
                            System.out.println("Hello, " + username + "!");
                            loggedIn = true;
                            break;
                        }
                    }

                    if (!loggedIn) {
                        System.out.println("Invalid username or password!");
                    }
                    break;

                case 2:
                    // Register
                    System.out.print("Enter username: ");
                    String newUsername = scanner.nextLine();

                    // Check if username already exists
                    boolean usernameExists = false;
                    for (int i = 0; i < userCount; i++) {
                        if (users[i][0].equals(newUsername)) {
                            usernameExists = true;
                            break;
                        }
                    }

                    if (usernameExists) {
                        System.out.println("Username already exists!");
                        break;
                    }

                    System.out.print("Enter password: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Confirm password: ");
                    String confirmPassword = scanner.nextLine();

                    if (!newPassword.equals(confirmPassword)) {
                        System.out.println("Password and confirm password do not match!");
                        break;
                    }

                    // Save user to array
                    users[userCount][0] = newUsername;
                    users[userCount][1] = newPassword;
                    userCount++;

                    System.out.println("Registration successful!");
                    break;

                case 3:
                    // Exit
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}