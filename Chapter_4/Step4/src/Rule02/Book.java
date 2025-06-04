package Rule02;
public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public void borrow() {
        this.isBorrowed = true;
    }

    public void returnBook() {
        this.isBorrowed = false;
    }

    public boolean getBorrowed() {
        return isBorrowed;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isTextbook() {
        return false;
    }

    public boolean isMagazine() {
        return false;
    }

    @Override
    public String toString() {
        return "'" + title + "' , '" + author + "'";
    }


}
