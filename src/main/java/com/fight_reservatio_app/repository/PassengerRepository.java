package com.fight_reservatio_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fight_reservatio_app.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
