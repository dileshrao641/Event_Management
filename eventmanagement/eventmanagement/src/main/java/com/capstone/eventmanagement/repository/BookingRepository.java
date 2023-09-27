package com.capstone.eventmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.eventmanagement.model.bookings;

@Repository
public interface BookingRepository extends JpaRepository<bookings,Long>{
	@Query("select t from bookings t where t.user.user_id = ?1")
    List<bookings> findBookingByUser_userId(int userId);
}
