package Bio08;
import java.time.LocalDateTime;
import java.util.*;
import Bio08.Enum.SessionStatus;

public class Session {
    private LocalDateTime sessionDate; // 연습 날짜
    private String location; // 연습 장소
    private List<Member> participants; // 참석 멤버 리스트
    private Member host; // 개설자 (Executive 또는 GeneralMember)
    private SessionStatus status; // 진행 상태 (개설/취소)

    public Session(LocalDateTime sessionDate, String location, Member host) {
        this.sessionDate = sessionDate;
        this.location = location;
        this.host = host;

        this.participants = new ArrayList<>();
        this.status = null;
    }
}
