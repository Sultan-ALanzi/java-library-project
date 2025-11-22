package obj;

// سلطان دحام حمد العنزي 446102803
// فيصل عبدالله ابراهيم السويد 446105494
public class Member {

  
    private int id;
    private String name;
    private int borrowedCount;

   
    private int numViewBorrowed;
    private int numBorrows;
    private int numReturns;
    private double sessionFees;

    // Static totals for all members
    public static double TotalRevenue = 0;
    public static int TotalViewBorrowed = 0;
    public static int TotalBorrows = 0;
    public static int TotalReturns = 0;

    // Constructor
    public Member(int id, String name, int borrowedCount) {
        this.id = id;
        this.name = name;
        this.borrowedCount = borrowedCount;
    }

    // Check if the member can borrow a book
    private boolean canBorrow() {
        return borrowedCount < 5;
    }

    // Check if the member can return a book
    private boolean canReturn() {
        return borrowedCount > 0;
    }

    // View how many books the member currently has
    public void viewBorrowedCount() {
        System.out.println("You have " + borrowedCount + " borrowed books.");

        numViewBorrowed++;
        TotalViewBorrowed++;
    }

    // Borrow one book
    public boolean borrowOne() {
        if (!canBorrow()) {
            System.out.println("You cannot borrow more than 5 books.");
            return false;
        }

        borrowedCount++;
        numBorrows++;
        sessionFees += 0.50;

        TotalBorrows++;
        TotalRevenue += 0.50;

        System.out.println("Borrowed successfully! Fee = 0.50");
        return true;
    }

    // Return one book
    public boolean returnOne() {
        if (!canReturn()) {
            System.out.println("You have no books to return.");
            return false;
        }

        borrowedCount--;
        numReturns++;
        TotalReturns++;

        System.out.println("Returned successfully!");
        return true;
    }

    // Display statistics for this session
    public void displayStatistics() {
        System.out.println("----- Session Summary for " + name + " -----");
        System.out.println("Borrowed books: " + borrowedCount);
        System.out.println("Times borrowed used: " + numBorrows);
        System.out.println("Times return used: " + numReturns);
        System.out.println("Times view used: " + numViewBorrowed);
        System.out.println("Session fees: " + sessionFees);
        System.out.println("-------------------------------------------");
    }

    // Reset session counters
    public void reset() {
        numBorrows = 0;
        numReturns = 0;
        numViewBorrowed = 0;
        sessionFees = 0;
    }

    // Getter for name
    public String getName() {
        return name;
    }
}



