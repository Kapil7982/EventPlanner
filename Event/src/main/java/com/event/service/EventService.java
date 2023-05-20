package com.event.service;


import com.event.entity.Event;
import com.event.excepitons.EventNotFoundExcepiton;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Event createEvent(Event event);
    List<Event> getAllEvents();
    Optional<Event> getEventById(Long eventId);
    List<Event> getLatestEvents(int limit, int page);
    Event updateEvent(Long eventId, Event event) throws EventNotFoundExcepiton;
    void deleteEvent(Long eventId) throws EventNotFoundExcepiton;
}
