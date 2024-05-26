package com.fight_reservatio_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fight_reservatio_app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String emailId);

}
