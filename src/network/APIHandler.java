package network;

import org.json.*;

public class APIHandler {
    private JSONObject getCourse(String subject, int number, int term, String session, String campus) {
        return new JSONObject();
    }

    // i.e.: subject="CPSC"; number=100 term=2 session="W" campus="V"
    public boolean isCourseReady(String subject, int number, int term, String session, String campus) {
        return false;
    }
}