package com.capstone.eventmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capstone.eventmanagement.model.users;
@Repository

public interface UserRepository extends JpaRepository<users,Long> {
	Optional<users> findById(int userId);
	users findIdByEmail(String email);

}
