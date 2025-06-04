package Rule02;

import Rule02.Interface.Borrowable;

import java.util.Iterator;
import java.util.List;


public class Member extends User implements Borrowable {

    public Member(String userId, String name, List<Book> borrowList) {
        super(userId, name, borrowList);
    }

    @Override
    public void borrowBook(Book book) {
        if (book.getBorrowed()) {
            System.out.println(book.getTitle() + "'은(는) 이미 대출 중입니다.");
            return;
        }

        System.out.println("이용자 '" + getName() + "'가 '" + book.getTitle() + "' 대출합니다.");
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
                System.out.println("이용자 '" + getName() + "'가 '" + book.getTitle() + "' 반납합니다.");
                returned = true;
                break;
            }
        }

        if (!returned) {
            System.out.println("'" + book.getTitle() + "'는 대출 목록에 없습니다. 반납 실패.");
        }
    }
}

