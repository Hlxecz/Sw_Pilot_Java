package Bio08;

import Bio08.Enum.SessionStatus;
import Bio08.Interface.SessionManager;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class GeneralMember extends Member implements SessionManager {
    Club club;

    public GeneralMember(String name, LocalDateTime joinDate, Club club) {
        super(name, joinDate);
        this.club = club;
    }

    public GeneralMember(String name, LocalDateTime joinDate, String skillLevel, Club club) {
        super(name, joinDate, skillLevel);
        this.club = club;
    }

    @Override
    public void createSession(LocalDateTime date, String location) {
        club.addSession(new Session(date, location, this, SessionStatus.OPENED));
    }

    @Override
    public void cancelSession(Session session) {
        session.setStatus(SessionStatus.CANCELLED);
        System.out.println(session.getSessionDate().toLocalDate() + ", " + session.getLocation() + " 연습 세션이 취소되었습니다.");
    }

    @Override
    public void updateSession(Session session, LocalDateTime newDate) {
        LocalDateTime oldDate = session.getSessionDate(); // 기존 날짜 먼저 저장
        session.setSessionDate(newDate); // 변경 적용

        long daysDiff = ChronoUnit.DAYS.between(oldDate, newDate);

        System.out.println(getName() + "이 " +
                newDate.toLocalDate() + ", " + session.getLocation() +
                "에 연습 세션을 " + daysDiff + "일 연기했습니다.");
    }
}
