package com.example.service;

import com.example.Attendee;
import com.example.Event;
import com.example.EventType;
import com.example.Notification;
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
    Event event;


    @InjectMocks
    EventNotificationServiceImpl eventService;

    //****************************            announce()                *********************************************/

    @Test
    @DisplayName("Test announcement")
    public void testAnouncement() {
        event = new Event();
        event.setId(1l);
        event.setTitle("eventoPrueba");

        Attendee attendee= new Attendee(1l,"salvi","salvi@gmail.com");
        List<Attendee> attendees= new ArrayList<Attendee>();
        List<Notification> notifications= new ArrayList<Notification>();
        attendee.setNotifications(notifications);
        attendees.add(attendee);
        event.setAttendees(attendees);
        eventService.announce(event);
        assertEquals(MSG_ANNOUNCE,event.getAttendees().get(0).getNotifications().get(0).getMessage());

    }
    //****************************            confirmAttendance()                ***************************************/
    @Test
    @DisplayName("Test Confirm Anouncement")
    public void testConfirmAnouncement() {
        event = new Event();
        event.setId(1l);
        event.setTitle("eventoPrueba");

        Attendee attendee= new Attendee(1l,"salvi","salvi@gmail.com");
        List<Attendee> attendees= new ArrayList<Attendee>();
        List<Notification> notifications= new ArrayList<Notification>();
        attendee.setNotifications(notifications);
        attendees.add(attendee);
        event.setAttendees(attendees);


        eventService.confirmAttendance(event,attendee);


        assertEquals(MSG_CONFIRM,event.getAttendees().get(0).getNotifications().get(0).getMessage());

    }

}