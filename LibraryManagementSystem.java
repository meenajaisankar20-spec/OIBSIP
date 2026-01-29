
import java.util.*;

class Book {
    int id;
    String name;
    boolean issued;

    Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.issued = false;
    }

    String status() {
        if (issued)
            return "Issued";
        else
            return "Available";
    }
}

class Admin {
    Scanner sc = new Scanner(System.in);

    void addBook(ArrayList<Book> books) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();
        books.add(new Book(id, name));
        System.out.println("Book Added Successfully\n");
    }

    void deleteBook(ArrayList<Book> books) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        for (Book b : books) {
            if (b.id == id) {
                books.remove(b);
                System.out.println("Book Deleted Successfully\n");
                return;
            }
        }
        System.out.println("Book Not Found\n");
    }
}

class User {
    Scanner sc = new Scanner(System.in);

    void viewBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No Books Available\n");
            return;
        }
        System.out.println("Book ID   Book Name   Status");
        for (Book b : books)
            System.out.println(b.id + "       " + b.name + "       " + b.status());
        System.out.println();
    }

    void issueBook(ArrayList<Book> books) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        for (Book b : books) {
            if (b.id == id && !b.issued) {
                b.issued = true;
                System.out.println("Book Issued Successfully\n");
                return;
            }
        }
        System.out.println("Book Not Available\n");
    }

    void returnBook(ArrayList<Book> books) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        for (Book b : books) {
            if (b.id == id && b.issued) {
                b.issued = false;
                System.out.println("Book Returned Successfully\n");
                return;
            }
        }
        System.out.println("Invalid Book ID\n");
    }
}

class Library {
    Scanner sc = new Scanner(System.in);

    void adminMenu(ArrayList<Book> books, Admin a) {
        while (true) {
            System.out.println("Admin Menu");
            System.out.println("1 Add Book");
            System.out.println("2 Delete Book");
            System.out.println("3 Logout");
            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();
            System.out.println();
            if (ch == 1) a.addBook(books);
            else if (ch == 2) a.deleteBook(books);
            else return;
        }
    }

    void userMenu(ArrayList<Book> books, User u) {
        while (true) {
            System.out.println("User Menu");
            System.out.println("1 View Books");
            System.out.println("2 Issue Book");
            System.out.println("3 Return Book");
            System.out.println("4 Logout");
            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();
            System.out.println();
            if (ch == 1) u.viewBooks(books);
            else if (ch == 2) u.issueBook(books);
            else if (ch == 3) u.returnBook(books);
            else return;
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        Admin admin = new Admin();
        User user = new User();
        Library lib = new Library();

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1 Admin Login");
            System.out.println("2 User Login");
            System.out.println("3 Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            System.out.println();

            if (choice == 1) {
                System.out.print("Enter Admin Password: ");
                if (sc.nextInt() == 1234)
                    lib.adminMenu(books, admin);
                else
                    System.out.println("Invalid Password\n");
            }
            else if (choice == 2) {
                lib.userMenu(books, user);
            }
            else {
                System.out.println("Thank You");
                break;
            }
        }
    }
}
