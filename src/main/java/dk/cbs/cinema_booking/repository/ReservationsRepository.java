package dk.cbs.cinema_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dk.cbs.cinema_booking.entity.Reservations;

public interface ReservationsRepository extends JpaRepository<Reservations, Long> {
}