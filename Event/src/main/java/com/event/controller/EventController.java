package com.event.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.event.entity.Event;
import com.event.excepitons.EventNotFoundExcepiton;
import com.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v3/app/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @GetMapping("/getAllEvents")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
    
    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable("eventId") Long eventId) {
        Optional<Event> event = eventService.getEventById(eventId);
        if (event.isPresent()) {
            return new ResponseEntity<>(event.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping()
    public ResponseEntity<List<Event>> getLatestEvents(
            @RequestParam(defaultValue = "5") int limit,
            @RequestParam(defaultValue = "1") int page
    ) {
        List<Event> events = eventService.getLatestEvents(limit, page);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    
    @PutMapping("/{eventId}")
    public ResponseEntity<Event> updateEvent(
            @PathVariable("eventId") Long eventId,
            @RequestBody Event event
    ) throws EventNotFoundExcepiton {
        Event updatedEvent = eventService.updateEvent(eventId, event);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }
    
    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("eventId") Long eventId) throws EventNotFoundExcepiton {
        eventService.deleteEvent(eventId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}



