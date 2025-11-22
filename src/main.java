// GitHub Repository: [https://github.com/Sultan-ALanzi/java-library-project]
// Student name: سلطان دحام حمد العنزي, ID: 446102803
// Student name: فيصل عبدالله ابراهيم السويد, ID: 446105494

import java.util.Scanner;

public class main {

 public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     
     // Create member objects
     Member member1 = new Member(111, "Hamad", 0);
     Member member2 = new Member(222, "Sultan", 0);
     Member member3 = new Member(333, "Ahmed", 0);
     
     String goToMenu;
     
     do {
         System.out.println("==========================");
         System.out.println("Welcome To Library System!");
         System.out.println("==========================");
         System.out.println();
         System.out.println("Please select an account to login: ");
         System.out.println();
         System.out.println("1- user name: " + member1.getName() + " - ID Number: " + member1.getId());
         System.out.println("2- user name: " + member2.getName() + " - ID Number: " + member2.getId());
         System.out.println("3- user name: " + member3.getName() + " - ID Number: " + member3.getId());
         System.out.println();
         System.out.println("4- Login as Administrator");
         System.out.println();
         System.out.println("5- Exit");
         System.out.println();
         System.out.println("Enter your choice: ");
         
         while(!input.hasNextInt()) {
             System.out.println("ERROR!, enter integer number");
             input.next();
             System.out.println("Enter your choice: ");
         }
         int choice = input.nextInt();
         
         switch (choice) {
             case 1: // Enter Hamad Account
                 handleUserMenu(member1, input);
                 goToMenu = "y";
                 break;
                 
             case 2: // Enter Sultan Account
                 handleUserMenu(member2, input);
                 goToMenu = "y";
                 break;
                 
             case 3: // Enter Ahmed Account
                 handleUserMenu(member3, input);
                 goToMenu = "y";
                 break;
                 
             case 4: // Enter Administrator Menu
                 handleAdminMenu(input);
                 goToMenu = "y";
                 break;
                 
             case 5: // Exit
                 System.out.println("Are you sure that you want to EXIT !? (y/n)");
                 String confirmExit = input.next();
                 if(confirmExit.equalsIgnoreCase("y")) {
                     goToMenu = "n";
                 } else {
                     goToMenu = "y";
                 }
                 break;
                 
             default:
                 System.out.println("ERROR!, you must enter number between (1-5). ");
                 System.out.println();
                 goToMenu = "y";
         }
         
     } while (goToMenu.equalsIgnoreCase("y"));
     
     System.out.println("Good Bye!");
     input.close();
 }
 
 private static void handleUserMenu(Member member, Scanner input) {
     String goBack;
     
     do {
         System.out.println("====================");
         System.out.println("  Welcome " + member.getName() + " !");
         System.out.println("====================");
         System.out.println();
         System.out.println("1- Borrow Book.");
         System.out.println("2- Return Book.");
         System.out.println("3- View borrowed books count.");
         System.out.println("4- View Session Summary.");
         System.out.println("5- Exit.");
         System.out.println();
         System.out.println("Enter your choice: ");
         
         while(!input.hasNextInt()) {
             System.out.println("ERROR!, enter integer number");
             input.next();
             System.out.println("Enter your choice: ");
         }
         int choice = input.nextInt();
         
         switch (choice) {
             case 1: // Borrow Book
                 handleBorrowBooks(member, input);
                 goBack = "y";
                 break;
                 
             case 2: // Return Book
                 handleReturnBooks(member, input);
                 goBack = "y";
                 break;
                 
             case 3: // View borrowed books count
                 member.viewBorrowedCount();
                 System.out.println();
                 goBack = "y";
                 break;
                 
             case 4: // View Session Summary
                 member.displayStatistics();
                 System.out.println();
                 goBack = "y";
                 break;
                 
             case 5: // Exit
                 System.out.println("Are you sure that you want to sign out? (y/n)");
                 String confirmExit = input.next();
                 if(confirmExit.equalsIgnoreCase("y")) {
                     goBack = "n";
                 } else {
                     goBack = "y";
                 }
                 break;
                 
             default:
                 System.out.println("ERROR!, you must enter number between (1-5). ");
                 System.out.println();
                 goBack = "y";
         }
         
     } while (goBack.equalsIgnoreCase("y"));
 }
 
 private static void handleBorrowBooks(Member member, Scanner input) {
     System.out.println("How many books do you want to borrow?: ");
     
     while(!input.hasNextInt()) {
         System.out.println("ERROR!, enter integer number");
         input.next();
         System.out.println("How many books do you want to borrow?: ");
     }
     int numBooks = input.nextInt();
     
     // Calculate how many books can be borrowed (max 5 total)
     int availableSlots = 5 - member.getBorrowedCount();
     
     if (numBooks <= 0) {
         System.out.println("ERROR! Number of books must be positive.");
     } else if (availableSlots <= 0) {
         System.out.println("You cannot borrow more books! Maximum limit (5) reached.");
     } else if (numBooks > availableSlots) {
         System.out.println("You can only borrow " + availableSlots + " more books (maximum 5 total).");
         System.out.println("Would you like to borrow " + availableSlots + " books instead? (y/n)");
         String confirm = input.next();
         if (confirm.equalsIgnoreCase("y")) {
             int booksBorrowed = member.borrowMultiple(availableSlots);
             System.out.println("Great! You borrowed " + booksBorrowed + " books!");
             System.out.println("Total fee for this operation: " + (booksBorrowed * 0.50));
         } else {
             System.out.println("Borrow operation cancelled.");
         }
     } else {
         int booksBorrowed = member.borrowMultiple(numBooks);
         System.out.println("Great! You borrowed " + booksBorrowed + " books!");
         System.out.println("Total fee for this operation: " + (booksBorrowed * 0.50));
     }
     System.out.println();
 }
 
 private static void handleReturnBooks(Member member, Scanner input) {
     System.out.println("How many books do you want to return?: ");
     
     while(!input.hasNextInt()) {
         System.out.println("ERROR!, enter integer number");
         input.next();
         System.out.println("How many books do you want to return?: ");
     }
     int numBooks = input.nextInt();
     
     int currentBorrowed = member.getBorrowedCount();
     
     if (numBooks <= 0) {
         System.out.println("ERROR! Number of books must be positive.");
     } else if (currentBorrowed <= 0) {
         System.out.println("You don't have any books to return!");
     } else if (numBooks > currentBorrowed) {
         System.out.println("You only have " + currentBorrowed + " books borrowed.");
         System.out.println("Would you like to return all " + currentBorrowed + " books? (y/n)");
         String confirm = input.next();
         if (confirm.equalsIgnoreCase("y")) {
             int booksReturned = member.returnMultiple(currentBorrowed);
             System.out.println("Great! You returned " + booksReturned + " books!");
         } else {
             System.out.println("Return operation cancelled.");
         }
     } else {
         int booksReturned = member.returnMultiple(numBooks);
         System.out.println("Great! You returned " + booksReturned + " books!");
     }
     System.out.println();
 }
 
 private static void handleAdminMenu(Scanner input) {
     String goBack;
     
     do {
         System.out.println("==============================");
         System.out.println(" Welcome to Administrator Menu!");
         System.out.println("==============================");
         System.out.println();
         System.out.println("1- View total revenue");
         System.out.println("2- Most frequent operation");
         System.out.println("3- Exit to main menu");
         System.out.println();
         System.out.println("Enter your choice: ");
         
         while(!input.hasNextInt()) {
             System.out.println("ERROR!, enter integer number");
             input.next();
             System.out.println("Enter your choice: ");
         }
         int choice = input.nextInt();
         
         switch (choice) {
             case 1:
                 System.out.println("Total revenue collected: " + Member.TotalRevenue);
                 System.out.println();
                 goBack = "y";
                 break;
                 
             case 2:
                 System.out.println("Most frequent operation is: ");
                 if (Member.TotalBorrows > Member.TotalReturns && Member.TotalBorrows > Member.TotalViewBorrowed) {
                     System.out.println("Borrow Book");
                 } else if (Member.TotalReturns > Member.TotalBorrows && Member.TotalReturns > Member.TotalViewBorrowed) {
                     System.out.println("Return Book");
                 } else if (Member.TotalViewBorrowed > Member.TotalBorrows && Member.TotalViewBorrowed > Member.TotalReturns) {
                     System.out.println("View Borrowed Count");
                 } else {
                     System.out.println("Multiple operations are tied");
                 }
                 System.out.println();
                 goBack = "y";
                 break;
                 
             case 3:
                 System.out.println("Are you sure that you want to sign out? (y/n)");
                 String confirmExit = input.next();
                 if(confirmExit.equalsIgnoreCase("y")) {
                     goBack = "n";
                 } else {
                     goBack = "y";
                 }
                 break;
                 
             default:
                 System.out.println("ERROR!, you must enter number between (1-3). ");
                 System.out.println();
                 goBack = "y";
         }
         
     } while (goBack.equalsIgnoreCase("y"));
 }
}
