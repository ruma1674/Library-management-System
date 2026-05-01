// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.Scanner;

public class Main {
   public Main() {
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Library library = new Library();

      while(true) {
         System.out.println("\n===== Library Management System =====");
         System.out.println("1. Add Book (Member 1)");
         System.out.println("2. View Books (Member 2)");
         System.out.println("3. Search Book (Member 3)");
         System.out.println("4. Issue Book (Member 4)");
         System.out.println("5. Return Book (Member 5)");
         System.out.println("6. Delete Book (Member 6)");
         System.out.println("7. Exit");
         System.out.print("Enter choice: ");
         int choice = sc.nextInt();
         switch (choice) {
            case 1:
               System.out.print("Enter Book ID: ");
               int id1 = sc.nextInt();
               sc.nextLine();
               System.out.print("Enter Title: ");
               String title = sc.nextLine();
               System.out.print("Enter Author: ");
               String author = sc.nextLine();
               library.addBook(new Book(id1, title, author));
               break;
            case 2:
               library.viewBooks();
               break;
            case 3:
               System.out.print("Enter Book ID to search: ");
               library.searchBook(sc.nextInt());
               break;
            case 4:
               System.out.print("Enter Book ID to issue: ");
               library.issueBook(sc.nextInt());
               break;
            case 5:
               System.out.print("Enter Book ID to return: ");
               library.returnBook(sc.nextInt());
               break;
            case 6:
               System.out.print("Enter Book ID to delete: ");
               library.deleteBook(sc.nextInt());
               break;
            case 7:
               System.out.println("Exiting system... Goodbye!");
               sc.close();
               return;
            default:
               System.out.println("Invalid choice!");
         }
      }
   }
}