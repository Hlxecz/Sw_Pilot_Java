package Rule02;

import Rule02.Interface.Borrowable;

import java.util.Iterator;
import java.util.List;

public class Manager extends User implements Borrowable {

    public Manager(String userId, String name, List<Book> borrowList) {
        super(userId, name, borrowList);
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
        System.out.println("관리자 '" + getName() + "'가 책을 추가합니다: " + book);
    }

    public void removeBook(Library library, Book book) {
        library.removeBook(book);
        System.out.println("관리자 '" + getName() + "'가 책을 삭제합니다: " + book);
    }

    @Override
    public void borrowBook(Book book) {
        if (book.getBorrowed()) {
            System.out.println(book.getTitle() + "'은(는) 이미 대출 중입니다.");
            return;
        }

        System.out.println("매니저 '" + getName() + "'가 '" + book.getTitle() + "' 대출합니다.");
        book.borrow();
        addBorrowBookList(book);
    }

    @Override
    public void returnBook(Book book) {
        Iterator<Book> iterator = getBorrowList().iterator();
        boolean returned = false;

        while (iterator.hasNext()) {
            Book borrowedBook = iterator.next();
            if (book.getIsbn().equals(borrowedBook.getIsbn())) {
                iterator.remove();
                book.returnBook();
                System.out.println("매니저 '" + getName() + "'가 '" + book.getTitle() + "' 반납합니다.");
                returned = true;
                break;
            }
        }

        if (!returned) {
            System.out.println("'" + book.getTitle() + "'는 대출 목록에 없습니다. 반납 실패.");
        }
    }
}
