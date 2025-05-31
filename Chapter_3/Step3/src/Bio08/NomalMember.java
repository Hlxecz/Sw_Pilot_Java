package Bio08;

import Bio08.Enum.SessionStatus;
import Bio08.Interface.SessionManager;

import java.time.LocalDateTime;

public class NomalMember extends Member implements SessionManager {
    Club club;

    public NomalMember(String name, LocalDateTime joinDate,Club club) {
        super(name, joinDate);
        this.club = club;
    }

    public NomalMember(String name, LocalDateTime joinDate, String skillLevel,Club club) {
        super(name, joinDate, skillLevel);
        this.club = club;
    }

    @Override
    public void createSession(LocalDateTime date, String location) {
         club.addSession(new Session(date,location,this, SessionStatus.OPENED));
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
