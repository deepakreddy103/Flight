package com.fight_reservatio_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fight_reservatio_app.dto.ReservationRequest;
import com.fight_reservatio_app.entity.Flight;
import com.fight_reservatio_app.entity.Passenger;
import com.fight_reservatio_app.entity.Reservation;
import com.fight_reservatio_app.repository.FlightRepository;
import com.fight_reservatio_app.repository.PassengerRepository;
import com.fight_reservatio_app.repository.ReservationRepository;
import com.fight_reservatio_app.utilities.PDFgenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		String filepath = "D:\\ticket\\tickets";
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckIn(false);
		reservation.setNumberOfBags(0);
		
		reservationRepo.save(reservation);
		PDFgenerator pdf = new PDFgenerator();
		pdf.generatePDF(filepath+reservation.getId()+".pdf");
		
		return reservation;
	}

}
