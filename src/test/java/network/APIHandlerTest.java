package network;

import org.junit.Test;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class APIHandlerTest {

    @Test
    public void testIsCourseReady_WithAvailableSeats() throws Exception {
        // Mock HttpClient and HttpResponse
        HttpClient mockClient = mock(HttpClient.class);
        HttpResponse<String> mockResponse = mock(HttpResponse.class);

        // Return JSON indicating 5 available seats
        when(mockResponse.body()).thenReturn("{\"seatsAvailable\":5}");
        when(mockClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(mockResponse);

        APIHandler apiHandler = new APIHandler(mockClient);
        boolean result = apiHandler.isCourseReady("CPSC", 101, 2, "W", "V");

        assertTrue(result);
    }

    @Test
    public void testIsCourseReady_WithNoSeats() throws Exception {
        HttpClient mockClient = mock(HttpClient.class);
        HttpResponse<String> mockResponse = mock(HttpResponse.class);

        // Return JSON indicating 0 seats
        when(mockResponse.body()).thenReturn("{\"seatsAvailable\":0}");
        when(mockClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(mockResponse);

        APIHandler apiHandler = new APIHandler(mockClient);
        boolean result = apiHandler.isCourseReady("CPSC", 101, 2, "W", "V");

        assertFalse(result);
    }
}
