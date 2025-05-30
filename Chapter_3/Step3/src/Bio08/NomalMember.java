package Bio08;

import Bio08.Interface.SessionManager;

import java.time.LocalDateTime;

public class NomalMember extends Member implements SessionManager {

    public NomalMember(String name, LocalDateTime joinDate) {
        super(name, joinDate);
    }

    public NomalMember(String name, LocalDateTime joinDate, String skillLevel) {
        super(name, joinDate, skillLevel);
    }

    @Override
    public void createSession(Session session) {
        System.out.println("날짜와");
    }

    @Override
    public void cancelSession(Session session) {
        System.out.println("운영진만 취소 할 수 있습니다.");
    }

    @Override
    public void updateSession(Session session, LocalDateTime localDateTime) {
        System.out.println("운영진만 연습을 연기 할 수 있습니다");
    }
}
