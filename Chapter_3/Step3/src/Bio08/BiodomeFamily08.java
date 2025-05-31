package Bio08;

import Bio08.Enum.SessionStatus;
import java.time.LocalDateTime;

public class BiodomeFamily08 {
    public static void main(String[] args) {
        Club club = new Club();

        // 1. 멤버 생성
        GeneralMember john = new GeneralMember("John", LocalDateTime.of(2130, 9, 1, 0, 0), "고급", club);
        NomalMember jane = new NomalMember("Jane", LocalDateTime.of(2130, 9, 1, 0, 0), "중급", club);
        NomalMember doe = new NomalMember("Doe", LocalDateTime.of(2130, 9, 1, 0, 0), club);
        NewMember amy = new NewMember("Amy", LocalDateTime.of(2130, 9, 1, 0, 0));
        NewMember leo = new NewMember("Leo", LocalDateTime.of(2130, 9, 1, 0, 0));

        club.addList(john);
        club.addList(jane, doe);
        club.addList(amy, leo);

        // 2. 운영진이 연습 세션 개설
        LocalDateTime sessionDate = LocalDateTime.of(2130, 9, 12, 0, 0);
        john.createSession(sessionDate, "도메 스타디움");

        // 3. 참가자 참가
        // 세션을 직접 꺼내서 addParticipant
        Session session = club.getSessionByDateAndLocation(sessionDate, "도메 스타디움");
        if (session != null) {
            session.addParticipant(jane, amy);
        }

        // 4. 개설된 세션 출력
        System.out.println("\n==== 현재 개설된 세션 ====");
        club.searchSessionByStatus(SessionStatus.OPENED);

        // 5. 세션 날짜 연기
        System.out.println("\n==== 세션 날짜 연기 ====");
        LocalDateTime newDate = sessionDate.plusDays(7);
        john.updateSession(session, newDate);

        // 6. 연습 세션 취소
        System.out.println("\n==== 연습 취소 ====");
        john.cancelSession(session);
    }
}
