package kfa.exception;

public class ItemOverdueException extends Exception {
    private int daysOverdue;

    public ItemOverdueException(int daysOverdue) {
        super("Item returned " + daysOverdue + " day(s) overdue.");
        this.daysOverdue = daysOverdue;
    }

    public int getDaysOverdue() {
        return daysOverdue;
    }
}