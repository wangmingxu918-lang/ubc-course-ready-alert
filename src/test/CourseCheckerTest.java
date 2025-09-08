package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(PowerMockRunner.class)
@PrepareForTest({YourOriginalClass.class, HttpClient.class})
public class CourseCheckerTest {

    @Test
    public void testIsCourseReady_WithAvailableSeats() throws Exception {
        HttpClient mockClient = PowerMockito.mock(HttpClient.class);
        @SuppressWarnings("unchecked")
        HttpResponse<String> mockResponse = PowerMockito.mock(HttpResponse.class);
        PowerMockito.whenNew(HttpClient.class).withAnyArguments().thenReturn(mockClient);
        

        PowerMockito.when(mockClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                   .thenReturn(mockResponse);
        
        PowerMockito.when(mockResponse.body()).thenReturn("<div>5 seats available</div>");
        
        boolean result = YourOriginalClass.isCourseReady("MATH", "101", "Fall", "2023", "Main");
        
        assertTrue(result);
    }

    @Test
    public void testIsCourseReady_WithClosedCourse() throws Exception {
        HttpClient mockClient = PowerMockito.mock(HttpClient.class);
        @SuppressWarnings("unchecked")
        HttpResponse<String> mockResponse = PowerMockito.mock(HttpResponse.class);
        
        PowerMockito.whenNew(HttpClient.class).withAnyArguments().thenReturn(mockClient);
        PowerMockito.when(mockClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                   .thenReturn(mockResponse);
        PowerMockito.when(mockResponse.body()).thenReturn("<div>Course closed - 0 seats</div>");
        
        boolean result = YourOriginalClass.isCourseReady("CS", "201", "Spring", "2024", "Main");
        
        assertFalse(result);
    }
}