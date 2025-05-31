package Bio08;

import Bio08.Enum.SessionStatus;

import java.time.LocalDateTime;
import java.util.*;

public class Club {
    private List<Member> memberList;
    private List<Session> sessions;

    public Club() {
        this.memberList  = new ArrayList<>();
        this.sessions  = new ArrayList<>();
    }

    public void addList(Member... members) {
        memberList.addAll(Arrays.asList(members));

        //        for (Member member : members) {
        //            memberList.add(member);
        //        }


        if (members.length == 0) return;

        // 타입 판단 (모두 동일한 타입이라고 가정)
        Member first = members[0];
        String type = "";
        if (first instanceof GeneralMember) {
            type = "운영진으로";
        } else if (first instanceof NomalMember) {
            type = "일반 멤버로";
        } else if (first instanceof NewMember) {
            type = "신규 멤버로";
        }

        // 이름 나열
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < members.length; i++) {
            sb.append(members[i].getName());
            if (i == members.length - 2) sb.append("과 ");
            else if (i < members.length - 2) sb.append(", ");
        }

        sb.append("가 ").append(type).append(" 가입되었습니다.");
        System.out.println(sb);
    }


    public void showAllMembers() {
        System.out.println("======== 전체 동호회 회원 정보 ========");
        for (Member m : memberList) {
            System.out.print(m.getName() + " ");
        }
        System.out.println();
    }

    public void delMember(String name){
        System.out.println("======== 동호회 회원 삭제 ========");
        Iterator<Member> it = memberList.iterator();

        while(it.hasNext()){
            Member rname = it.next();
            if(name.equals(rname.getName())){
                it.remove();
                System.out.println(rname.getName()+"님은 동아리를 탈퇴하였습니다.");
                return;
            }
        }System.out.println(name + "님을 찾을 수 없습니다.");

    }

    public void addSession(Session session) {
        sessions.add(session);
        System.out.println(session.getHost().getName() + "이 " +
                session.getSessionDate().toLocalDate() + ", " +
                session.getLocation() + "에 연습 세션을 오픈했습니다.");
    }


    public Session getSessionByDateAndLocation(LocalDateTime sessionDate, String location) {
        for(Session s : sessions){
            if(s.getSessionDate().equals(sessionDate)  && s.getLocation().equals(location)){
                return s;
            }
        }
        return null;
    }

    public void searchSessionByStatus(SessionStatus sessionStatus) {
        for(Session s : sessions){
            if(s.getStatus() == sessionStatus){
                System.out.println(s);
            }
        }
    }
}
