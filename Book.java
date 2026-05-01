import java.util.*;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Issued: " + isIssued;
    }
}

class Library {
    private final List<Book> books = new ArrayList<>();

    // ================= MEMBER 1 =================
    public void addBook(Book book) {
        books.add(book);
        System.out.println("[Member 1] Book added successfully!");
    }

    // ================= MEMBER 2 =================
    public void viewBooks() {
        System.out.println("[Member 2] Viewing all books...");
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // ================= MEMBER 3 =================
    public void searchBook(int id) {
        System.out.println("[Member 3] Searching book...");
        for (Book b : books) {
            if (b.id == id) {
                System.out.println("Found: " + b);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // ================= MEMBER 4 =================
    public void issueBook(int id) {
        System.out.println("[Member 4] Issuing book...");
        for (Book b : books) {
            if (b.id == id) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book already issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // ================= MEMBER 5 =================
    public void returnBook(int id) {
        System.out.println("[Member 5] Returning book...");
        for (Book b : books) {
            if (b.id == id) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // ================= MEMBER 6 =================
    public void deleteBook(int id) {
        System.out.println("[Member 6] Deleting book...");
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (b.id == id) {
                it.remove();
                System.out.println("Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
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