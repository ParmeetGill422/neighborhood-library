//Manages the inventory of books.
public class Library {
    private Book[] inventory;

    public Library() {
        inventory = new Book[20];
        initializeInventory();
    }
    // Populate with 20 sample books.
    private void initializeInventory() {
        inventory[0]  = new Book( 1, "978-0140449136", "The Odyssey");
        inventory[1]  = new Book( 2, "978-0141439600", "Pride and Prejudice");
        inventory[2]  = new Book( 3, "978-0061120084", "To Kill a Mockingbird");
        inventory[3]  = new Book( 4, "978-0451524935", "1984");
        inventory[4]  = new Book( 5, "978-0743273565", "The Great Gatsby");
        inventory[5]  = new Book( 6, "978-0544003415", "The Hobbit");
        inventory[6]  = new Book( 7, "978-0142437230", "Moby-Dick");
        inventory[7]  = new Book( 8, "978-0307277671", "The Road");
        inventory[8]  = new Book( 9, "978-0140283334", "Brave New World");
        inventory[9]  = new Book(10, "978-0679785897", "Crime and Punishment");
        inventory[10] = new Book(11, "978-0140449266", "The Iliad");
        inventory[11] = new Book(12, "978-0140449181", "Meditations");
        inventory[12] = new Book(13, "978-0140449273", "The Aeneid");
        inventory[13] = new Book(14, "978-0140444308", "Don Quixote");
        inventory[14] = new Book(15, "978-0140449198", "The Divine Comedy");
        inventory[15] = new Book(16, "978-0553212416", "Dr. Jekyll and Mr. Hyde");
        inventory[16] = new Book(17, "978-0553213119", "Frankenstein");
        inventory[17] = new Book(18, "978-0140449204", "Faust");
        inventory[18] = new Book(19, "978-0553212850", "The Scarlet Letter");
        inventory[19] = new Book(20, "978-0141439518", "Dracula");
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