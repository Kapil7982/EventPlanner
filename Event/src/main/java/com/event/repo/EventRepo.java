package com.event.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.event.entity.Event;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {

}





