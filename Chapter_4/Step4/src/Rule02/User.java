package Rule02;

import java.util.List;

public abstract class User {
    private String userId;
    private String name;
    private List<Book> borrowList;

    public User(String userId, String name, List<Book> borrowList) {
        this.userId = userId;
        this.name = name;
        this.borrowList = borrowList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
