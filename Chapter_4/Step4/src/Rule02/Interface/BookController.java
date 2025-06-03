package Rule02.Interface;

import Rule02.Book;
import Rule02.Library;

public interface BookController {
    void addBook(Book book, Library library);
    void removeBook(Book book, Library library);
}
