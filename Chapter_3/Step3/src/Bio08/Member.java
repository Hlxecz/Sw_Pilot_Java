package Bio08;

import java.time.LocalDateTime;

public class Member {
    private String name; // 이름
    private LocalDateTime joinDate; // 가입 일자
    private String skillLevel; // 스킬 수준 (예: "초급", "중급", "고급" 등)
    //private String region; // 소속 지역 (보너스)


    public Member(String name, LocalDateTime joinDate) {
        this.name = name;
        this.joinDate = joinDate;
        this.skillLevel = "";
    }

    public Member(String name, LocalDateTime joinDate, String skillLevel) {
        this.name = name;
        this.joinDate = joinDate;
        this.skillLevel = skillLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

}
