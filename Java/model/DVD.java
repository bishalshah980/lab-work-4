package kfa.model;

public class DVD extends LibraryItem implements Renewable {
    private int durationMinutes;

    public DVD(String title, String isbn, double price, int durationMinutes) {
        super(title, isbn, price);
        this.durationMinutes = durationMinutes;
    }

    @Override
    public int getLendingPeriodDays() {
        return 5;
    }

    @Override
    public void renew(int extraDays) {
        System.out.println("DVD '" + getTitle() + "' renewed for " + extraDays + " days.");
    }

    @Override
    public String toString() {
        String status = isAvailable() ? "Available" : "Not Available";
        return String.format("[DVD] [%s] %s (%d mins) - Rs %.2f (%s)", getIsbn(), getTitle(), durationMinutes, getPrice(), status);
    }
}