package com.example;

import com.example.service.EventNotificationService;
import com.example.service.EventNotificationServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    private static final String MSG_ANNOUNCE = "The next big event is coming!";
    private static final String MSG_CONFIRM = "Dear Attendee, your subscription to the event has been confirmed successfully.";


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
    @Test
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
    @DisplayName("removeAttendeeNullWithContaint")
    public void removeAttendeeNullWithContaint() {
        Event event= new Event();
        event.setAttendees(null);
        Attendee attendee1 = new Attendee(1l,"salvi","salvi");
        Attendee attendee2 = new Attendee(2l,"pepe","salvi");
        List<Attendee> attendees= new ArrayList<>();
        attendees.add(attendee1);
        attendees.add(attendee2);
        event.setAttendees(attendees);
        event.removeAttendee(attendee1);
        assertTrue(event.getAttendees().size()==1);
    }

    //*********************************  Remove attendeess   ******************************************//

    @Test
    @DisplayName("removeAttendeessNull")
    public void removeAttendeessNull() {
        Event event= new Event();
        event.removeAttendees(null);
        assertTrue(event.getAttendees().isEmpty());
    }

    @Test
    @DisplayName("removeAttendeessNullWithContaintNull")
    public void removeAttendeessNullWithContaintNull() {
        Event event= new Event();
        event.setAttendees(null);
        Attendee attendee = new Attendee(1l,"salvi","salvi");

        Attendee attendee2 = new Attendee(2l,"pepe","salvi");
        List<Attendee> attendees= new ArrayList<>();
        attendees.add(attendee2);
        attendees.add(attendee);
        event.setAttendees(null);
        event.removeAttendees(attendees);
        assertTrue(event.getAttendees() instanceof ArrayList && event.getAttendees().isEmpty());
    }

    @Test
    @DisplayName("removeAttendeessNullWithContaint")
    public void removeAttendeessNullWithContaint() {
        Event event= new Event();
        event.setAttendees(null);
        Attendee attendee1 = new Attendee(1l,"salvi","salvi");
        Attendee attendee2 = new Attendee(2l,"pepe","salvi");
        List<Attendee> attendees= new ArrayList<>();
        attendees.add(attendee1);
        attendees.add(attendee2);
        event.setAttendees(attendees);
        event.removeAttendees(attendees);
        assertTrue(event.getAttendees().isEmpty());
    }

    //*********************************   notifyAssistants   ******************************************//


    @Test
    @DisplayName("notifyAssistants")
    public void notifyAssistants() {
        EventNotificationService eventNotification= new EventNotificationServiceImpl();
        Event event= new Event(1l,"eventonuevo",EventType.BUSINESS,eventNotification);
        Attendee attendee1 = new Attendee(1l,"salvi","salvi");
        Attendee attendee2 = new Attendee(2l,"pepe","salvi");
        List<Attendee> attendees= new ArrayList<>();
        List<Notification>notifications= new ArrayList<>();
        attendee1.setNotifications(notifications);
        attendees.add(attendee1);
        attendees.add(attendee2);
        event.setAttendees(attendees);
        event.notifyAssistants();
        assertTrue(event.getAttendees().get(0).getNotifications().get(0).getMessage().equals(MSG_ANNOUNCE));

    }

    //*********************************   addSpeaker   ******************************************//

    @Test
    @DisplayName("addSpeaker")
    public void addSpeaker() {
        EventNotificationService eventNotification= new EventNotificationServiceImpl();
        Event event= new Event(1l,"eventonuevo",EventType.BUSINESS,eventNotification);
        Speaker speaker= new Speaker(1l,"Speaker1","alta");
        event.addSpeaker(speaker);
        assertNotNull(event.getSpeakers().get(0));
    }

    @Test
    @DisplayName("addSpeakerNull")
    public void addSpeakerNull() {
        EventNotificationService eventNotification= new EventNotificationServiceImpl();
        Event event= new Event(1l,"eventonuevo",EventType.BUSINESS,eventNotification);
        event.addSpeaker(null);
        assertTrue(event.getSpeakers().isEmpty());
    }

    //*********************************   removeSpeaker   ******************************************//

    @Test
    @DisplayName("removeSpeaker")
    public void removeSpeaker() {
        EventNotificationService eventNotification= new EventNotificationServiceImpl();
        Event event= new Event(1l,"eventonuevo",EventType.BUSINESS,eventNotification);
        Speaker speaker= new Speaker(1l,"Speaker","media");
        Speaker speaker1= new Speaker(2l,"Speaker1","alta");
        event.addSpeaker(speaker);
        event.addSpeaker(speaker1);
        event.removeSpeaker(speaker);
        assertTrue(event.getSpeakers().size()==1);
    }

    @Test
    @DisplayName("removeSpeakerNull")
    public void removeSpeakerNull() {
        EventNotificationService eventNotification= new EventNotificationServiceImpl();
        Event event= new Event(1l,"eventonuevo",EventType.BUSINESS,eventNotification);
        Speaker speaker= new Speaker(1l,"Speaker","media");
        Speaker speaker1= new Speaker(2l,"Speaker1","alta");
        event.addSpeaker(speaker);
        event.addSpeaker(speaker1);
        event.removeSpeaker(null);
        assertTrue(event.getSpeakers().size()==2);
    }

    @Test
    @DisplayName("getID")
    public void getId() {
        EventNotificationService eventNotification= new EventNotificationServiceImpl();
        Event event= new Event(1l,"eventonuevo",EventType.BUSINESS,eventNotification);
        assertNotNull(event.getId());
    }





//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public EventType getType() {
//        return type;
//    }
//
//    public void setType(EventType type) {
//        this.type = type;
//    }
//
//    public List<Speaker> getSpeakers() {
//        return speakers;
//    }
//
//    public void setSpeakers(List<Speaker> speakers) {
//        this.speakers = speakers;
//    }
//
//    public List<Attendee> getAttendees() {
//        return attendees;
//    }
//
//    public void setAttendees(List<Attendee> attendees) {
//        this.attendees = attendees;
//    }




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