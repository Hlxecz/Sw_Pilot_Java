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

    public Session(LocalDateTime sessionDate, String location, Member host,SessionStatus sessionStatus) {
        this.sessionDate = sessionDate;
        this.location = location;
        this.host = host;
        this.participants = new ArrayList<>();
        this.status = sessionStatus;

    }

    public void addParticipant(Member... member) {
        participants.addAll(Arrays.asList(member));
    }

    public LocalDateTime getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDateTime sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Member> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Member> participants) {
        this.participants = participants;
    }

    public Member getHost() {
        return host;
    }

    public void setHost(Member host) {
        this.host = host;
    }

    public SessionStatus getStatus() {
        return status;
    }

    public void setStatus(SessionStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder names = new StringBuilder();
        for (int i = 0; i < participants.size(); i++) {
            names.append(participants.get(i).getName());
            if (i < participants.size() - 1) names.append(", ");
        }
        return sessionDate.toLocalDate() + ", " + location + ", [" + names + "], " + host.getName() + ", " + status;
    }

}
