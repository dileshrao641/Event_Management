package com.capstone.eventmanagement.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@E
@Data
@NoArgsConstructor
@AllArgsConstructor
public class bookings {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int bookingId;
@ManyToOne
@JoinColumn(name="user_id")
private users user;
@ManyToOne
@JoinColumn(name="event_id")
private events event;

public int getBookingId() {
	return bookingId;
}
public void setBookingId(int bookingId) {
	this.bookingId = bookingId;
}
public users getUser() {
	return user;
}
public void setUser(users user) {
	this.user = user;
}
public events getEvent() {
	return event;
}
public void setEvent(events event) {
	this.event = event;
}
private LocalDate bookingDate;
public LocalDate getBookingDate() {
	return bookingDate;
}
public void setBookingDate(LocalDate bookingDate) {
	this.bookingDate = bookingDate;
}

}
