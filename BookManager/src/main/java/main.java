import dao.BookDao;
import model.Book;

import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        BookDao bookDAO = new BookDao();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nBook Manager");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Book Category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter Book Rating: ");
                    float rating = sc.nextFloat();

                    Book book = new Book(name, category, rating);
                    bookDAO.saveBook(book);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    List<Book> bookList = bookDAO.getAllBooks();
                    if (bookList.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        for (Book b : bookList) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to delete: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a valid book ID.");
                        sc.nextLine(); // consume invalid input
                        continue;
                    }
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    bookDAO.deleteBook(id);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    }
