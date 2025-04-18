import java.util.Scanner;

public class LibraryApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showHomeMenu();
            String choice = scanner.nextLine().trim().toUpperCase();
            switch (choice) {
                case "1": // Show Available
                    handleShowAvailable();
                    break;
                case "2": // Show Checked Out
                    handleShowCheckedOut();
                    break;
                case "X": // Exit
                    running = false;
                    System.out.println("Goodbye!\nHope to never see you again!!.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    private static void showHomeMenu() {
        System.out.println("\n=== Neighborhood Library ===");
        System.out.println("1) Show Available Books");
        System.out.println("2) Show Checked Out Books");
        System.out.println("X) Exit");
        System.out.print("Select an option: ");
    }
    private static void handleShowAvailable() {
        library.showAvailableBooks();
        System.out.print("\nEnter Book ID to check out or X to return: ");
        String input = scanner.nextLine().trim();
        if (input.equalsIgnoreCase("X")) return;

        try {
            int id = Integer.parseInt(input);
            Book b = library.getBookById(id);
            if (b == null || b.isCheckedOut()) {
                System.out.println("That book is already checked out, try another one.");
            } else {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine().trim();
                b.checkOut(name);
                System.out.println("You checked out \"" + b.getTitle() + "\". Return it on time, otherwise I'll get mad.");
            }
        } finally {

        }
    }
    private static void handleShowCheckedOut() {
        library.showCheckedOutBooks();
        System.out.print("\nC) Check In a book  X) Return: ");
        String choice = scanner.nextLine().trim().toUpperCase();
        if (!choice.equals("C")) return;

        System.out.print("Enter Book ID to check in: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Book b = library.getBookById(id);
            if (b == null || !b.isCheckedOut()) {
                System.out.println("You are inputting a invalid book ID or trying to check in a book that is not checked out.");
            } else {
                b.checkIn();
                System.out.println("Book \"" + b.getTitle() + "\" has been returned. Good job on returning it on time.");
            }
        } finally {

        }
    }
}