package dk.cbs.cinema_booking.service;

import dk.cbs.cinema_booking.dto.PerformanceResponseDTO;
import dk.cbs.cinema_booking.dto.ReservationRequestDTO;

import java.util.List;

import dk.cbs.cinema_booking.repository.*;

public interface CinemaService {
    List<PerformanceResponseDTO> getAllPerformances();

    void createReservation(ReservationRequestDTO request);

    void cancelReservation(Long reservationId);
}
