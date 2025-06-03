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
        if(book.get)
        System.out.println("이용자 '"+getName()+"' 가" + book.getTitle() +"' 대출합니다.");
        book.setBorrowed(true);
        addBorrowBookList(book);
    }

    @Override
    public void returnBook(Book book) {
        Iterator<Book> list = getBorrowList().listIterator();

        while(list.hasNext()){
            Book borrowBook = list.next();
            if(book.getIsbn().equals(borrowBook.getIsbn())){
                System.out.println("이용자 '"+getName()+"' 가" + book.getTitle() +"' 반납합니다.");
                list.remove();
            }

        }

    }
}
