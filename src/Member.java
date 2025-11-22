package obj;

public class Member {

	
	// Private instance variables
    private int id;
    private String name;
    private int borrowedCount;
    private int numViewBorrowed;
    private int numBorrows;
    private int numReturns;
    private double sessionFees;
    
    // Public static variables
    public static double TotalRevenue = 0;
    public static int TotalViewBorrowed = 0;
    public static int TotalBorrows = 0;
    public static int TotalReturns = 0;
    
    // Constructor
    public Member(int id, String name, int borrowedCount) {
        this.id = id;
        this.name = name;
        this.borrowedCount = borrowedCount;
        this.numViewBorrowed = 0;
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0;
    }

	
 // Private helper methods
    private boolean canBorrow() {
        return borrowedCount < 5;
    }
    
    private boolean canReturn() {
        return borrowedCount > 0;
    }
    
    // Public methods
    public void viewBorrowedCount() {
        System.out.println("You borrow " + borrowedCount + " Books");
        numViewBorrowed++;
        TotalViewBorrowed++;
    }
    
    public boolean borrowOne() {
        if (canBorrow()) {
            borrowedCount++;
            numBorrows++;
            sessionFees += 0.50;
            TotalRevenue += 0.50;
            TotalBorrows++;
            return true;
        }
        return false;
    }

    
    // New method to borrow multiple books
    public int borrowMultiple(int numberOfBooks) {
        int booksBorrowed = 0;
        for (int i = 0; i < numberOfBooks; i++) {
            if (canBorrow()) {
                borrowOne();
                booksBorrowed++;
            } else {
                break;
            }
        }
        return booksBorrowed;
    }
    
 
    public boolean returnOne() {
        if (canReturn()) {
            borrowedCount--;
            numReturns++;
            TotalReturns++;
            return true;
        }
        return false;
    }
    

 // New method to return multiple books
    public int returnMultiple(int numberOfBooks) {
        int booksReturned = 0;
        for (int i = 0; i < numberOfBooks; i++) {
            if (canReturn()) {
                returnOne();
                booksReturned++;
            } else {
                break;
            }
        }
        return booksReturned;
    }
    
    public void displayStatistics() {
        System.out.println("Number of books borrow: " + numBorrows + " books");
        System.out.println("Number of return books: " + numReturns + " books");
        System.out.println("Number of times viewed borrowed count: " + numViewBorrowed);
        System.out.println("Total fee: " + sessionFees);
    }
    
    public void reset() {
        numViewBorrowed = 0;
        numBorrows = 0;
        numReturns = 0;
        sessionFees = 0;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getBorrowedCount() {
        return borrowedCount;
    }
    
    public void setBorrowedCount(int borrowedCount) {
        this.borrowedCount = borrowedCount;
    }
    
    public int getNumViewBorrowed() {
        return numViewBorrowed;
    }
    
    public int getNumBorrows() {
        return numBorrows;
    }
    
    public int getNumReturns() {
        return numReturns;
    }
    
    public double getSessionFees() {
        return sessionFees;
    }
 
	
	
	
	
	
}


