package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {



    //****************************************  Add attende   ***************************************//


    @Test
    @DisplayName("addAttendeeNull")
    void addAttendeeNull() {
        Event event= new Event();
        event.addAttendee(null);
        assertTrue(event.getAttendees().size() ==0);
    }
    @Test
    @DisplayName("addAttendee")
    void addAttendee() {
        Event event= new Event();
        Attendee attendee = new Attendee(1l,"salvi","salvi");
        event.setAttendees(null);
        event.addAttendee(attendee);
        assertTrue(event.getAttendees().size() >0);
    }

    @Test
    @DisplayName("addAttendeeWithContaintAttende")
    void addAttendeeWithContaintAttende() {
        Event event= new Event();
        Attendee attendee = new Attendee(1l,"salvi","salvi");
        event.addAttendee(attendee);

        event.addAttendee(attendee);
        assertTrue(event.getAttendees().size() ==1);
    }

    //*********************************  Add attendeess   ******************************************//

    @Test
    @DisplayName("addAttendeessNull")
    void addAttendeessNull() {
        Event event= new Event();
        event.addAttendees(null);
        assertTrue(event.getAttendees().size() ==0);
    }

    @Test
    @DisplayName("addAttendeess")
    void addAttendeess() {
        Event event= new Event();
        Attendee attendee = new Attendee(1l,"salvi","salvi");
        List<Attendee> attendees= new ArrayList<>();
        attendees.add(attendee);
        event.setAttendees(null);
        event.addAttendees(attendees);
        assertTrue(event.getAttendees().size() >0);
    }


    @Test
    @DisplayName("addAttendeessWithContaintAttendeess")
    void addAttendeessWithContaintAttendeess() {

        Event event= new Event();
        Attendee attendee = new Attendee(1l,"salvi","salvi");
        event.addAttendee(attendee);
        List<Attendee> attendees= new ArrayList<>();
        attendees.add(attendee);
        event.setAttendees(attendees);
        event.addAttendees(attendees);

        assertTrue(event.getAttendees().size() ==1);
    }
    //*********************************  Remove attendee   ******************************************//

    @Test
    @DisplayName("removeAttendeeNull")
    public void removeAttendeeNull() {
        Event event= new Event();
        event.removeAttendee(null);
        assertTrue(event.getAttendees().isEmpty());
    }
    @DisplayName("removeAttendeeNullWithContaintNull")
    public void removeAttendeeNullWithContaintNull() {
        Event event= new Event();
        event.setAttendees(null);
        Attendee attendee = new Attendee(1l,"salvi","salvi");
        event.setAttendees(null);
        event.removeAttendee(attendee);
        assertTrue(event.getAttendees() instanceof ArrayList && event.getAttendees().isEmpty());
    }



    @Test
    void notifyAssistants() {
    }

    @Test
    void addSpeaker() {
    }

    @Test
    void removeSpeaker() {
    }

    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getTitle() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void getType() {
    }

    @Test
    void setType() {
    }

    @Test
    void getSpeakers() {
    }

    @Test
    void setSpeakers() {
    }

    @Test
    void getAttendees() {
    }

    @Test
    void setAttendees() {
    }
}