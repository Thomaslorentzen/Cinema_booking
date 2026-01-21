package dk.cbs.cinema_booking.service;

import java.util.List;

import dk.cbs.cinema_booking.dto.PerformanceResponseDTO;
import dk.cbs.cinema_booking.dto.ReservationRequestDTO;
import dk.cbs.cinema_booking.entity.Performance;
import dk.cbs.cinema_booking.entity.Reservations;
import dk.cbs.cinema_booking.repository.PerformanceRepository;
import dk.cbs.cinema_booking.repository.ReservationsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class CinemaServiceImpl implements CinemaService {

    private final PerformanceRepository performanceRepository;
    private final ReservationsRepository reservationRepository;

    public CinemaServiceImpl(
            PerformanceRepository performanceRepository,
            ReservationsRepository reservationRepository) {
        this.performanceRepository = performanceRepository;
        this.reservationRepository = reservationRepository;
    }


    @Override
    public List<PerformanceResponseDTO> getAllPerformances() {
        return performanceRepository.findAll().stream()
                .map(this::mapToPerformanceDto)
                .toList();
        
    }

    @Override
    public void createReservation(ReservationRequestDTO request) {
        Performance performance = performanceRepository.findById(request.getPerformanceId())
                .orElseThrow(() -> new IllegalArgumentException("Performance not found"));

        if (request.getNumberOfSeats() > performance.getAvailableSeats()) {
            throw new IllegalStateException("Not enough available seats");
        }

        Reservations reservation = new Reservations(
                performance,
                request.getNumberOfSeats()
        );

        reservationRepository.save(reservation);
    }

    @Override
    public void cancelReservation(Long reservationId) {
        Reservations reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found"));

        reservationRepository.delete(reservation);
    }
 
    private PerformanceResponseDTO mapToPerformanceDto(Performance performance) {
        return new PerformanceResponseDTO(
                performance.getId(),
                performance.getTitle(),
                performance.getShowTime(),
                performance.getAvailableSeats()
        );
    }
}
