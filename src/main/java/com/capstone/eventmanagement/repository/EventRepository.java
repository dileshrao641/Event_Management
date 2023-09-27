package com.capstone.eventmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.eventmanagement.model.events;
import com.capstone.eventmanagement.model.users;
@Repository
public interface EventRepository extends JpaRepository<events,Long> {
	   List<events> findByCategory(String category);
	    Optional<events> findById(long eventId);
	    List<events> findByOrganiser(String organiser);
//		List<events> findByEventId(long id);
}
