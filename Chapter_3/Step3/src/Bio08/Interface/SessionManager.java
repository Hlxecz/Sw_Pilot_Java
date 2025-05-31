package Bio08.Interface;

import Bio08.Session;
import java.time.LocalDateTime;

public interface SessionManager {
   void createSession(LocalDateTime date, String location);
   void cancelSession(Session session);
   void updateSession(Session session, LocalDateTime newDate);
}
