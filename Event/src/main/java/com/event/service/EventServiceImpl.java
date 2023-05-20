package com.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.entity.Event;
import com.event.excepitons.EventNotFoundExcepiton;
import com.event.repo.EventRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;

@Service
public class EventServiceImpl implements EventService {
	
    private final EventRepo eventRepository;
    
    @Autowired
    public EventServiceImpl(EventRepo eventRepository) {
        this.eventRepository = eventRepository;
    }

	@Override
	public Event createEvent(Event event) {
		 return eventRepository.save(event);
	}

	@Override
	public List<Event> getAllEvents() {
		 return eventRepository.findAll();
	}

	@Override
	public Optional<Event> getEventById(Long eventId) {
		return eventRepository.findById(eventId);
	}

	@Override
	public List<Event> getLatestEvents(int limit, int page) {
		PageRequest pageRequest = PageRequest.of(page - 1, limit);
        return eventRepository.findAll(pageRequest).getContent();
	}

	@Override
	public Event updateEvent(Long eventId, Event event) throws EventNotFoundExcepiton {
		Event existingEvent = eventRepository.findById(eventId).orElse(null);
        if (existingEvent != null) {
            // Update the properties of the existing event
            existingEvent.setName(event.getName());
            existingEvent.setTagline(event.getTagline());
            existingEvent.setSchedule(event.getSchedule());
            existingEvent.setDescription(event.getDescription());
            existingEvent.setModerator(event.getModerator());
            existingEvent.setCategory(event.getCategory());
            existingEvent.setSubCategory(event.getSubCategory());
            existingEvent.setRigorRank(event.getRigorRank());
            existingEvent.setAttendees(event.getAttendees());

            return eventRepository.save(existingEvent);
        } else {
            throw new EventNotFoundExcepiton("Event not found with ID: " + eventId);
        }
	}

	@Override
	public void deleteEvent(Long eventId) throws EventNotFoundExcepiton {
		Event existingEvent = eventRepository.findById(eventId).orElse(null);
        if (existingEvent != null) {
            eventRepository.delete(existingEvent);
        } else {
            throw new EventNotFoundExcepiton("Event not found with ID: " + eventId);
        }
		
	}

    
}

