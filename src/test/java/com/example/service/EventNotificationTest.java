package com.example.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EventNotificationTest {


    private static final String MSG_ANNOUNCE = "The next big event is coming!";
    private static final String MSG_CONFIRM = "Dear Attendee, your subscription to the event has been confirmed successfully.";

    @Test
    void announce() {
    }

    @Test
    void confirmAttendance() {
    }
}