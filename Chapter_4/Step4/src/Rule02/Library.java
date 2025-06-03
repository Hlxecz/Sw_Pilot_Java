package Rule02;

import Rule02.Interface.BookController;
import Rule02.Interface.UserController;

import java.util.List;

public class Library implements BookController, UserController {
    private List<Book> books ;
    private List<User> users ;

    public Library(List<Book> books, List<User> users) {
        this.books = books;
        this.users = users;
    }

    public Book writeBook(String isbn, String title, String author) {
        Book book = new Book(isbn, title, author);
        books.add(book);
        return book;
    }
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void addMember(Member member) {
        users.add(member);
    }

    public void addManager(Manager manager) {
        users.add(manager);
    }

}
