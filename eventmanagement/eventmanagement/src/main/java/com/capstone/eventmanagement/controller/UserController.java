package com.capstone.eventmanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.capstone.eventmanagement.exception.ResourceNotFoundException;
import com.capstone.eventmanagement.model.TransactionDetails;
import com.capstone.eventmanagement.model.bookings;
import com.capstone.eventmanagement.model.events;
import com.capstone.eventmanagement.model.users;
import com.capstone.eventmanagement.repository.BookingRepository;
import com.capstone.eventmanagement.repository.EventRepository;
import com.capstone.eventmanagement.repository.UserRepository;
import com.capstone.eventmanagement.service.UserService;
import com.capstone.eventmanagement.service.UserServiceImpl;

@CrossOrigin("*")
@RestController
public class UserController {
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private EventRepository eventrepository;
	@Autowired
	private BookingRepository bookingrepository;
	@Autowired
	private UserService userservice;
	
	//user registration
	@PostMapping("/users")
	public users  createUser(@RequestBody users users)
	{
		 return userrepository.save(users);
	}
	
	//to get details of user by id
	@GetMapping("/users/{id}")
	public ResponseEntity<users> getUserById(@PathVariable Long id) {
		users users=userrepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("user not exist with id:"+id));
		return ResponseEntity.ok(users);
	}
	
	//to get the list of events
	@GetMapping("/events")
	public List<events> getAllevents()
	{
		return eventrepository.findAll();
	}
	
	//add event details
	@PostMapping("/events")
	public events  createEvent(@RequestBody events events)
	{
		 return eventrepository.save(events);
	}
	
	//filtering events based on category
	@GetMapping("/events/{category}")
	public ResponseEntity<List<events>> getEventByCategory(@PathVariable String category) {
		List<events> events=eventrepository.findByCategory(category);

//			    if (events.isEmpty()) {
//			        throw new ResourceNotFoundException("No events found for category: " + category);
//			        
//			    }
		return ResponseEntity.ok(events);
	}
	
	@GetMapping("/events/event/{id}")
	public ResponseEntity<events> getEventById(@PathVariable long id) {
		events event = eventrepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Event id does not exist"));

		return ResponseEntity.ok(event);
	}
	
	//to store values into bookings table
	@PostMapping("/bookings/{eventId}/{userId}")
	public void bookEvent(@PathVariable int eventId, @PathVariable int userId) {
	    events event = eventrepository.findById(eventId)
	            .orElseThrow(() -> new ResourceNotFoundException("Event id does not exist"));

	    users user = userrepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User id does not exist"));

	    if (event != null && user != null) {
	        bookings booking = new bookings();
	        booking.setEvent(event);
	        booking.setUser(user);
	        bookingrepository.save(booking);
	    }
	}

	//to get details from bookings table
	@GetMapping("/bookings/{userId}")
	public List<bookings> findByBookingUser(@PathVariable int userId) {
	    return bookingrepository.findBookingByUser_userId(userId);
	}

	//login validation
	@GetMapping("users/{emailId}/{password}")
	public int UserLogin(@PathVariable("emailId") String emailId, @PathVariable("password") String password1) {
		int flag=userservice.loginValidation(emailId, password1);
		if(flag==0) {
			return 0;
		}
		return flag;
	}
	
	@PutMapping("/events/{id}")
	public events updateEvent(@PathVariable int id, @RequestBody events event) {
	events existsEvent = eventrepository.findById(id).orElseThrow();
	existsEvent.setLocation(event.getLocation());
	existsEvent.setName(event.getName());
	existsEvent.setCategory(event.getCategory());
	existsEvent.setOrganiser(event.getOrganiser());
	existsEvent.setDate(event.getDate());
	existsEvent.setPrice(event.getPrice());
	return eventrepository.save(existsEvent);
	}
	//filtering events based on org id
	@GetMapping("/events/org/{organiser}")
	public ResponseEntity<List<events>> getEventByOrganiser(@PathVariable String organiser) {
	    List<events> events = eventrepository.findByOrganiser(organiser);

	    if (events.isEmpty()) {
	        throw new ResourceNotFoundException("No events found for organiser: " + organiser);
	    }

	    return ResponseEntity.ok(events);
	}
    
	@GetMapping("/users/email/{email}")
    public ResponseEntity<Long> getUserId(@PathVariable String email) {
        users users = userrepository.findIdByEmail(email);

//        if (users == null) {
//            return ResponseEntity.notFound().build();
//        }

        return ResponseEntity.ok(users.getId());
    }
	@GetMapping("/users/mail/{email}")
    public ResponseEntity<Map<String,String>> getUserName(@PathVariable String email) {
        users users = userrepository.findIdByEmail(email);

//        if (users == null) {
//            return ResponseEntity.notFound().build();
//        }
        Map<String, String> response = new HashMap<>();
        response.put("name", users.getFullname());
        return ResponseEntity.ok(response);
    }
	
	@GetMapping("/createTransaction/{amount}")
	public TransactionDetails createTransaction(@PathVariable Double amount) {
	return userservice.createTransaction(amount);
	}
//    @PutMapping("/events/{eventId}")
//    public ResponseEntity<String> updateEvent(@PathVariable Long eventId, @RequestBody events updatedEvent) {
//        // Find the existing event
//        Optional<events> existingEventOptional = eventrepository.findById(eventId);
//        if (!existingEventOptional.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        
//        events existingEvent = existingEventOptional.get();
//        
//        // Update the existing event's details
//        existingEvent.setName(updatedEvent.getName());
//        existingEvent.setDescription(updatedEvent.getDescription());
//        existingEvent.setStartDate(updatedEvent.getStartDate());
//        existingEvent.setEndDate(updatedEvent.getEndDate());
//        
//        // Save the updated event
//        eventrepository.save(existingEvent);
//        
//        return ResponseEntity.ok("Event updated successfully");
//    }








	
}
