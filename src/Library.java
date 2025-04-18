//Manages the inventory of books.
public class Library {
    private Book[] inventory;

    public Library() {
        inventory = new Book[20];
        initializeInventory();
    }
    // Populate with 20 sample books.
    private void initializeInventory() {
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = new Book(
                    i + 1,
                    "978-0-00" + String.format("%04d", i),
                    "Sample Title " + (i + 1)
            );
        }
    }
    //Display all books not currently checked out.
    public void showAvailableBooks() {
        System.out.println("\nAvailable Books:");
        System.out.printf("%-4s %-15s %s%n", "ID", "ISBN", "Title");
        for (Book b : inventory) {
            if (!b.isCheckedOut()) {
                System.out.printf("%-4d %-15s %s%n",
                        b.getId(), b.getIsbn(), b.getTitle());
            }
        }
    }
    //Display all books that are checked out, with who has them.
    public void showCheckedOutBooks() {
        System.out.println("\nChecked‑Out Books:");
        System.out.printf("%-4s %-15s %-25s %s%n",
                "ID", "ISBN", "Title", "Checked Out To");
        for (Book b : inventory) {
            if (b.isCheckedOut()) {
                System.out.printf("%-4d %-15s %-25s %s%n",
                        b.getId(), b.getIsbn(),
                        b.getTitle(), b.getCheckedOutTo());
            }
        }
    }
    public Book getBookById(int id) {
        if (id < 1 || id > inventory.length) return null;
        return inventory[id - 1];
    }
}