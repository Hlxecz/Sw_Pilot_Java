package Rule02;

import java.util.List;

public class Manager extends User{
    public Manager(String userId, String name, List<Book> borrowList) {
        super(userId, name, borrowList);
    }
}
