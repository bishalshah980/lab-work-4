package kfa.service;

import kfa.model.LibraryItem;
import kfa.exception.BookNotAvailableException;
import kfa.exception.ItemOverdueException;

public class LibrarySystem {

    // Section C: Borrowing & Returning
    public void borrowItem(LibraryItem item) throws BookNotAvailableException {
        if (!item.isAvailable()) {
            throw new BookNotAvailableException("Item '" + item.getTitle() + "' is currently out on loan.");
        }
        item.setAvailable(false);
        System.out.println("Checkout successful: " + item.getTitle());
    }

    public void returnItem(LibraryItem item, int daysLate) throws ItemOverdueException {
        if (daysLate > 0) {
            throw new ItemOverdueException(daysLate);
        }
        item.setAvailable(true);
        System.out.println("Return successful: " + item.getTitle());
    }

    // Section D1: ID Generator
    public static String generateMemberId(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) return "INVALID";

        String[] parts = fullName.trim().split(" ");
        String firstName = parts[0];

        String firstPart = firstName.length() >= 3
                ? firstName.substring(0, 3).toUpperCase()
                : firstName.toUpperCase();

        String secondPart = "";
        if (parts.length > 1) {
            String lastName = parts[parts.length - 1];
            secondPart = lastName.length() >= 2
                    ? lastName.substring(0, 2).toUpperCase()
                    : lastName.toUpperCase();
        } else {
            secondPart = firstName.length() >= 2
                    ? firstName.substring(0, 2).toUpperCase()
                    : "XX";
        }

        int randomDigits = (int) (Math.random() * 900) + 100;
        return firstPart + secondPart + randomDigits;
    }

    // Section D2: ISBN Validator
    public static boolean isValidIsbn(String isbn) {
        if (isbn == null || isbn.length() != 13 || isbn.charAt(0) == '0') {
            return false;
        }

        for (int i = 0; i < isbn.length(); i++) {
            char c = isbn.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    // Section D3: Catalogue Report
    public static String buildCatalogueReport(LibraryItem[] items, String keyword) {
        StringBuilder report = new StringBuilder();
        report.append("=== LIBRARY CATALOGUE REPORT ===\n");

        boolean filterActive = (keyword != null && !keyword.trim().isEmpty());
        String term = filterActive ? keyword.toLowerCase().trim() : "";

        for (LibraryItem item : items) {
            if (!filterActive || item.getTitle().toLowerCase().contains(term)) {
                report.append("- ")
                        .append(item.getTitle())
                        .append(" | Status: ")
                        .append(item.isAvailable() ? "Available" : "Not Available")
                        .append("\n");
            }
        }
        return report.toString();
    }
}