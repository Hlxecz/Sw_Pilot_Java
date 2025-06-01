# 🔎 RuleOfBiodome01_before.java SOLID 원칙 위반 분석 보고서

본 보고서는 Java 예제 코드 `RuleOfBiodome01_before.java`를 분석하여, SOLID 객체지향 설계 원칙의 위반 사례를 식별하고 개선 방향을 제시한 문서입니다.

---

## ✅ 1. SRP 위반 - Library 클래스의 책임 과다

**📍 위반 원칙**: SRP (Single Responsibility Principle, 단일 책임 원칙)

<details>
<summary>📌 문제 요약 & 💥 위반 코드</summary>

```java
class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }
    public void removeBook(Book book) { books.remove(book); }

    public void addMember(Member member) { users.add(member); }
    public void addManager(Manager manager) { users.add(manager); }
}
```

책과 유저를 동시에 관리하고 있어, 단일 책임 원칙에 어긋남.

</details>

<details>
<summary>🛠 개선 방안 & ✅ 리팩토링 코드</summary>

```java
class BookManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }
    public void removeBook(Book book) { books.remove(book); }
}

class UserManager {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) { users.add(user); }
}
```

`Library`는 이제 이 두 클래스를 조합만 하면 됩니다.

</details>

---

## ✅ 2. SRP 위반 - User 클래스의 책임 중첩

**📍 위반 원칙**: SRP

<details>
<summary>📌 문제 요약 & 💥 위반 코드</summary>

```java
abstract class User {
    public void borrowBook(Book book) { ... }
    public void returnBook(Book book) { ... }

    abstract void addBook(Book book, Library library);
    abstract void removeBook(Book book, Library library);
}
```

이용자와 관리자 기능을 한 클래스에 같이 정의하여 역할 혼재.

</details>

<details>
<summary>🛠 개선 방안 & ✅ 리팩토링 코드</summary>

```java
abstract class User {
    public void borrowBook(Book book) { ... }
    public void returnBook(Book book) { ... }
}

interface BookEditable {
    void addBook(Book book, Library library);
    void removeBook(Book book, Library library);
}

class Manager extends User implements BookEditable {
    public void addBook(...) { ... }
    public void removeBook(...) { ... }
}
```

이용자와 도서관리 기능을 인터페이스로 분리하여 SRP 만족.

</details>

---

## ✅ 3. OCP 위반 - 유저 추가 방식의 확장성 부족

**📍 위반 원칙**: OCP (Open/Closed Principle)

<details>
<summary>📌 문제 요약 & 💥 위반 코드</summary>

```java
public void addMember(Member member) { users.add(member); }
public void addManager(Manager manager) { users.add(manager); }
```

유형이 추가될 때마다 메서드를 새로 작성해야 함.

</details>

<details>
<summary>🛠 개선 방안 & ✅ 리팩토링 코드</summary>

```java
public void addUser(User user) {
    users.add(user);
}
```

이렇게 수정하면 코드 수정 없이 새로운 User 타입 확장 가능.

</details>

---

## ✅ 4. LSP 위반 - Member가 부모 클래스 기능을 무력화함

**📍 위반 원칙**: LSP (Liskov Substitution Principle)

<details>
<summary>📌 문제 요약 & 💥 위반 코드</summary>

```java
class Member extends User {
    public void addBook(Book book, Library library) {
        System.out.println("Member can't add book");
    }
}
```

`User user = new Member(...)` 후 `user.addBook(...)` 하면 의미 없음.

</details>

<details>
<summary>🛠 개선 방안 & ✅ 리팩토링 코드</summary>

```java
interface BookEditable {
    void addBook(Book book, Library library);
    void removeBook(Book book, Library library);
}

class Manager extends User implements BookEditable {
    public void addBook(...) { ... }
    public void removeBook(...) { ... }
}
```

기능이 필요한 클래스만 인터페이스를 구현하도록 수정.

</details>

---

## ✅ 5. ISP 위반 - Member가 사용하지 않는 메서드 구현 강요

**📍 위반 원칙**: ISP (Interface Segregation Principle)

<details>
<summary>📌 문제 요약 & 💥 위반 코드</summary>

```java
abstract class User {
    abstract void addBook(Book book, Library library);
    abstract void removeBook(Book book, Library library);
}

class Member extends User {
    public void addBook(...) {
        System.out.println("사용할 수 없습니다.");
    }
}
```

사용하지도 않을 기능을 강제로 구현해야 하는 상황.

</details>

<details>
<summary>🛠 개선 방안 & ✅ 리팩토링 코드</summary>

```java
abstract class User {
    public void borrowBook(Book book) { ... }
    public void returnBook(Book book) { ... }
}

// 별도 인터페이스
interface BookEditable {
    void addBook(Book book, Library library);
    void removeBook(Book book, Library library);
}
```

불필요한 기능은 구현하지 않도록 설계 분리.

</details>

---

## ✅ 6. DIP 위반 - Library가 구체 구현(ArrayList)에 의존

**📍 위반 원칙**: DIP (Dependency Inversion Principle)

<details>
<summary>📌 문제 요약 & 💥 위반 코드</summary>

```java
private List<Book> books = new ArrayList<>();
```

`Library`가 직접 `ArrayList`에 의존 → 변경 어려움

</details>

<details>
<summary>🛠 개선 방안 & ✅ 리팩토링 코드</summary>

```java
private List<Book> books;

public Library(List<Book> books) {
    this.books = books;
}
```

→ 추상화된 타입에 의존하고 구현체는 외부에서 주입

</details>

---

## 📝 결론 요약

| 원칙 | 위반 클래스/구조 | 주요 문제점 |
|------|------------------|-------------|
| SRP  | Library, User     | 여러 책임 혼합으로 변경 이유 중첩 |
| OCP  | Library           | 새로운 User 추가 시 코드 수정 필요 |
| LSP  | Member            | 부모 클래스의 기능을 무력화 |
| ISP  | Member            | 사용하지 않는 기능 구현 강요 |
| DIP  | Library           | 구체 구현(ArrayList)에 직접 의존 |

> SOLID 원칙을 지키면 유지보수성과 확장성이 높아지며, 재사용 가능하고 오류에 강한 시스템을 설계할 수 있습니다.
