package Rule02;

import Rule02.Interface.BookController;
import Rule02.Interface.UserController;

import java.util.ArrayList;
import java.util.List;

public class Library implements BookController, UserController {

    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }


    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(Book book) {
        if (!isBookRegistered(book)) {
            System.out.println("해당 책은 등록되어 있지 않습니다.");
            return;
        }

        if (book.getBorrowed()) {
            System.out.println("현재 대출 중인 책은 삭제할 수 없습니다: " + book);
            return;
        }

        books.remove(book);
        System.out.println("책 삭제 완료: " + book);
    }

    public Book writeBook(String isbn, String title, String author) {
        Book book = new Book(isbn, title, author);
        addBook(book);
        return book;
    }


    @Override
    public void addMember(Member member) {
        users.add(member);
        System.out.println("새로운 이용자 '" + member.getName() + "' 등록 완료");
    }

    @Override
    public void addManager(Manager manager) {
        users.add(manager);
        System.out.println("새로운 관리자 '" + manager.getName() + "' 등록 완료");
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("사용자 '" + user.getName() + "' 등록");
    }


    public void searchBooksByAuthor(String authorName) {
        System.out.println("\n저자 '" + authorName + "'의 책 목록:");
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equals(authorName)) {
                found = true;
                String status = book.getBorrowed() ? "대출 불가" : "대출 가능";
                System.out.println("책 제목" + book.getTitle() + ", " + status);
            }
        }
        if (!found) {
            System.out.println("해당 저자의 책을 찾을 수 없습니다.");
        }
    }


    public void showAllBooks() {
        System.out.println("\n전체 책 목록:");
        for (Book book : books) {
            String status = book.getBorrowed() ? "대출 중" : "대출 가능";
            System.out.println(book + " [" + status + "]");
        }
    }

    public void showAllUsers() {
        System.out.println("\n전체 사용자 목록:");
        for (User user : users) {
            System.out.println(user.getName() + " (" + user.getClass().getSimpleName() + ")");
        }
    }


    public boolean isBookRegistered(Book book) {
        return books.contains(book);
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) return book;
        }
        return null;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }
}
