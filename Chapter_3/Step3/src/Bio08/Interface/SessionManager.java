package Bio08.Interface;

import Bio08.Session;
import java.time.LocalDateTime;

public interface SessionManager {
   void createSession(Session session);
   void cancelSession(Session session);
   void updateSession(Session session, LocalDateTime localDateTime);
}
