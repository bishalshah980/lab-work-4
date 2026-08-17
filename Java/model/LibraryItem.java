package kfa.model;

public abstract class LibraryItem {
    private String title;
    private String isbn;
    private double price;
    private boolean available;

    public LibraryItem(String title, String isbn, double price) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.available = true; // Always defaults to available
    }

    public abstract int getLendingPeriodDays();

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Warning: Price cannot be negative. Set to 0.0.");
            this.price = 0.0;
        }
    }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}