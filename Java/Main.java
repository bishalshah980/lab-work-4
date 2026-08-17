import kfa.model.*;
import kfa.exception.*;
import kfa.service.LibrarySystem;

public class Main {
    public static void main(String[] args) {
        System.out.println(" SECTION A & B DEMO ");
        Book book1 = new Book("Clean Code", "Subash", "9780132350884", 85.00);
        Magazine mag1 = new Magazine("Tech Monthly", "9780132350885", 500.00, 42);
        DVD dvd1 = new DVD("Java Fundamentals", "9780132350886", 430.00, 120);

        LibraryItem[] items = {book1, mag1, dvd1};

        for (LibraryItem item : items) {
            System.out.println(item + " | Lending Days: " + item.getLendingPeriodDays());
        }
        System.out.println("Total Books Count: " + Book.getTotalBooks());

        System.out.println("\n=== SECTION C DEMO ===");
        LibrarySystem system = new LibrarySystem();

        processBorrow(system, book1);

        processBorrow(system, book1);

        processReturn(system, book1, 5);

        processReturn(system, book1, 0);

        System.out.println("\n=== SECTION D DEMO ===");
        System.out.println("Member ID ( Shrestha): " + LibrarySystem.generateMemberId("Shrestha"));
        System.out.println("Member ID (Single Name 'Estus'): " + LibrarySystem.generateMemberId("Estus"));

        System.out.println("ISBN Valid ('9780132350884'): " + LibrarySystem.isValidIsbn("9780132350884"));
        System.out.println("ISBN Invalid ('0780132350884'): " + LibrarySystem.isValidIsbn("0780132350884"));

        System.out.println("\n" + LibrarySystem.buildCatalogueReport(items, "Clean"));
    }

    private static void processBorrow(LibrarySystem system, LibraryItem item) {
        try {
            system.borrowItem(item);
        } catch (BookNotAvailableException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } finally {
            System.out.println("Transaction processed for: " + item.getTitle());
        }
    }

    private static void processReturn(LibrarySystem system, LibraryItem item, int daysLate) {
        try {
            system.returnItem(item, daysLate);
        } catch (ItemOverdueException e) {
            System.out.println("Exception Caught: " + e.getMessage());
            item.setAvailable(true);
        } finally {
            System.out.println("Transaction processed for: " + item.getTitle());
        }
    }
}