package Rule02;

import java.util.ArrayList;

public class RuleOfBodome02 {
    public static void main(String[] args) {
        Library library = new Library();

        // 관리자 및 이용자 등록
        Manager seiko = new Manager("admin1", "세이코", new ArrayList<>());
        Member mary = new Member("user1", "메리", new ArrayList<>());
        Member manok = new Member("user2", "만옥", new ArrayList<>());

        library.addManager(seiko);
        library.addMember(mary);
        library.addMember(manok);

        // 책 등록
        Book book1 = new Book("001", "자바의 구름", "제임스밥");
        Book book2 = new Book("002", "파이썬 마스터", "한송희");
        Book book3 = new Book("003", "에너지 플로우", "키네틱스");
        Book book4 = new Book("004", "화성에서의 기억", "한송희");
        Book book5 = new Book("005", "야채의 비밀", "송은정");

        seiko.addBook(library, book1);
        seiko.addBook(library, book2);
        seiko.addBook(library, book3);
        seiko.addBook(library, book4);
        seiko.addBook(library, book5);

        // 메리 대출
        mary.borrowBook(book1);

        // 추가 책 등록
        Book book6 = new Book("006", "자료구조의 언덕", "황수");
        Book book7 = new Book("007", "그곳에 가면", "한송희");

        seiko.addBook(library, book6);
        seiko.addBook(library, book7);

        // 이미 대출된 책 대출 시도
        manok.borrowBook(book1); // 자바의 구름 대출 중

        // 메리 반납
        mary.returnBook(book1);

        // 세이코가 책 대출
        seiko.borrowBook(book4); // 화성에서의 기억

        // 저자 검색
        library.searchBooksByAuthor("한송희");

        library.showAllBooks();

        library.showAllUsers();
    }
}
