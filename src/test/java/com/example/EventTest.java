package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {



    //******************************************  Add attende   ***************************************************//


    @Test
    @DisplayName("addAttendeeNull")
    void addAttendeeNull() {
        Event event= new Event();
        event.addAttendee(null);
        assertTrue(event.getAttendees().size() ==0);
    }





    @Test
    void addAttendees() {
    }

    @Test
    void removeAttendee() {
    }

    @Test
    void removeAttendees() {
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