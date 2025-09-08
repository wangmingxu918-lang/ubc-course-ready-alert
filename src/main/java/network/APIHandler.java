package network;

import org.json.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIHandler {
    private final HttpClient httpClient;

    public APIHandler(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    private JSONObject getCourse(String subject, int number, int term, String session, String campus) {
        return new JSONObject();
    }

    // i.e.: subject="CPSC"; number=100 term=2 session="W" campus="V"
    public boolean isCourseReady(String subject, int number, int term, String session, String campus) {
        return false;
    }
}