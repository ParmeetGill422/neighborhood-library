public class Book {
    int id;
    String isbn;
    String title;
    boolean isCheckedOut;
    String checkedOutTo;

    // Full constructor
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    // Getters and setters
    int getId(){ return id; }
    String getIsbn(){ return isbn; }
    String getTitle(){ return title; }
    boolean isCheckedOut(){ return isCheckedOut; }
    String getCheckedOutTo(){ return checkedOutTo; }
    void setIsbn(String isbn){ this.isbn = isbn; }
    void setTitle(String title){ this.title = title; }

    //Marks this book as checked out to the given name.
    public void checkOut(String name) {
        this.isCheckedOut   = true;
        this.checkedOutTo   = name;
    }

     //Marks this book as returned.
    public void checkIn() {
        this.isCheckedOut   = false;
        this.checkedOutTo   = "";
    }
}