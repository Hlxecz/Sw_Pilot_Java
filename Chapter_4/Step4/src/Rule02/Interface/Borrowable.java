package Rule02.Interface;

import Rule02.Book;

public interface Borrowable {
    void borrowBook(Book book);
    void returnBook(Book book);
}