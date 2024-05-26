package com.fight_reservatio_app.service;

import com.fight_reservatio_app.dto.ReservationRequest;
import com.fight_reservatio_app.entity.Reservation;

public interface ReservationService {
	Reservation bookFlight(ReservationRequest request);
}
