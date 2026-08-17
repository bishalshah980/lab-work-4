package kfa.model;

// Note: Magazine deliberately does not implement Renewable per library policy.
public class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String title, String isbn, double price, int issueNumber) {
        super(title, isbn, price);
        this.issueNumber = issueNumber;
    }

    @Override
    public int getLendingPeriodDays() {
        return 7;
    }

    @Override
    public String toString() {
        String status = isAvailable() ? "Available" : "Not Available";
        return String.format("[Magazine] [%s] %s (Issue #%d) - Rs %.2f (%s)", getIsbn(), getTitle(), issueNumber, getPrice(), status);
    }
}