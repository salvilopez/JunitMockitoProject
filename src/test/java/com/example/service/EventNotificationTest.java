package com.example.service;

import com.example.Attendee;
import com.example.Event;
import com.example.EventType;
import com.example.Notification;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EventNotificationTest {




    private static final String MSG_ANNOUNCE = "The next big event is coming!";
    private static final String MSG_CONFIRM = "Dear Attendee, your subscription to the event has been confirmed successfully.";


    @Mock
    EventNotificationServiceImpl eventService;



    @InjectMocks
    Event event;

    //****************************            Mock                *********************************************/

    @Test
    @DisplayName("Test testAnouncementMockuno ")
    public void testAnouncementMockuno() {





    }
    @Test
    @DisplayName("Test announcement Mock")
    @Disabled
    public void testAnouncementMock() {
        event = new Event(1l,"eventopruebabussines",EventType.BUSINESS,eventService);
        ArgumentCaptor<Event>argumentCaptor=ArgumentCaptor.forClass(Event.class);
        eventService.announce(event);

        verify(eventService,times(1)).announce(argumentCaptor.capture());


        assertEquals(event,argumentCaptor.getValue());

    }
    //****************************            announce()                *********************************************/



    @Test
    @DisplayName("Test announcement")
    public void testAnouncement() {
        EventNotificationServiceImpl eventServiceTmp = new EventNotificationServiceImpl();
        Event eventTemp = new Event();
        eventTemp.setId(1l);
        eventTemp.setTitle("eventoPrueba");

        Attendee attendee = new Attendee(1l, "salvi", "salvi@gmail.com");
        List<Attendee> attendees = new ArrayList<Attendee>();
        List<Notification> notifications = new ArrayList<Notification>();
        attendee.setNotifications(notifications);
        attendees.add(attendee);
        eventTemp.setAttendees(attendees);
        eventServiceTmp.announce(eventTemp);
        assertEquals(MSG_ANNOUNCE, eventTemp.getAttendees().get(0).getNotifications().get(0).getMessage());
    }
    //****************************            confirmAttendance()                ***************************************/
    @Test
    @DisplayName("Test Confirm Anouncement")
    public void testConfirmAnouncement () {
        EventNotificationServiceImpl eventServiceTmp = new EventNotificationServiceImpl();
        Event eventTemp = new Event();
        eventTemp.setId(1l);
        eventTemp.setTitle("eventoPrueba");

        Attendee attendee = new Attendee(1l, "salvi", "salvi@gmail.com");
        List<Attendee> attendees = new ArrayList<Attendee>();
        List<Notification> notifications = new ArrayList<Notification>();
        attendee.setNotifications(notifications);
        attendees.add(attendee);
        eventTemp.setAttendees(attendees);


        eventServiceTmp.confirmAttendance(eventTemp, attendee);


        assertEquals(MSG_CONFIRM, eventTemp.getAttendees().get(0).getNotifications().get(0).getMessage());

    }

}