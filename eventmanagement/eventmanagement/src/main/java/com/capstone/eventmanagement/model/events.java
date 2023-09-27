package com.capstone.eventmanagement.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class events {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long event_id;
private String name;
private String location;
private String category;
private int price;
private Date date;
private String organiser;
public long getId() {
	return event_id;
}
public void setId(long event_id) {
	this.event_id = event_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getOrganiser() {
	return organiser;
}
public void setOrganiser(String organiser) {
	this.organiser = organiser;
}

}
