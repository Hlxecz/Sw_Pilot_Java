package Bio08;

import java.time.LocalDateTime;

public class GeneralMember extends Member{
    public GeneralMember(String name, LocalDateTime joinDate) {
        super(name, joinDate);
    }

    public GeneralMember(String name, LocalDateTime joinDate, String skillLevel) {
        super(name, joinDate, skillLevel);
    }
}
